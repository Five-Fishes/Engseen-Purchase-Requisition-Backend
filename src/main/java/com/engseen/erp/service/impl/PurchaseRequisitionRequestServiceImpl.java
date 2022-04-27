package com.engseen.erp.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.engseen.erp.constant.enumeration.PurchaseRequisitionApprovalItemStatus;
import com.engseen.erp.domain.*;
import com.engseen.erp.repository.*;
import com.engseen.erp.service.PurchaseRequisitionRequestService;
import com.engseen.erp.service.dto.PurchaseRequisitionRequestDTO;

import com.engseen.erp.service.mapper.PurchaseRequisitionRequestItemMapper;
import com.engseen.erp.service.mapper.PurchaseRequisitionRequestMapper;
import com.engseen.erp.service.mapper.PurchaseRequisitionRequestToApprovalMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing {@link com.engseen.erp.domain.PurchaseRequisitionRequest}.
 */
@Service
@RequiredArgsConstructor
public class PurchaseRequisitionRequestServiceImpl implements PurchaseRequisitionRequestService {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequisitionRequestServiceImpl.class);

    private final PurchaseRequisitionApprovalRepository purchaseRequisitionApprovalRepository;
    private final PurchaseRequisitionApprovalItemRepository purchaseRequisitionApprovalItemRepository;
    private final PurchaseRequisitionRequestRepository purchaseRequisitionRequestRepository;
    private final PurchaseRequisitionRequestItemRepository purchaseRequisitionRequestItemRepository;
    private final PurchaseRequisitionRequestMapper purchaseRequisitionRequestMapper;
    private final PurchaseRequisitionRequestItemMapper purchaseRequisitionRequestItemMapper;
    private final PurchaseRequisitionRequestToApprovalMapper purchaseRequisitionRequestToApprovalMapper;
    private final VendorItemRepository vendorItemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequisitionRequestDTO> findAll(Pageable pageable) {
        log.debug("Request to findAll Purchase Request Submission");
        List<PurchaseRequisitionRequest> purchaseRequisitionRequestList = purchaseRequisitionRequestRepository
                .findAll(pageable)
                .toList();

        return getPurchaseRequisitionRequestDTOS(purchaseRequisitionRequestList);
    }

    @Override
    public List<PurchaseRequisitionRequestDTO> findAll(Pageable pageable, Date startDate, Date endDate) {
        log.debug("Request to findAll Purchase Request Submission with date range filter");
        List<PurchaseRequisitionRequest> purchaseRequisitionRequestList = purchaseRequisitionRequestRepository
                .findAllByCreatedDateBetween(pageable, startDate, endDate)
                .toList();

        return getPurchaseRequisitionRequestDTOS(purchaseRequisitionRequestList);
    }

    @Override
    public PurchaseRequisitionRequestDTO create(PurchaseRequisitionRequestDTO purchaseRequisitionRequestDto) {
        log.debug("Request to create Purchase Request Submission: {}", purchaseRequisitionRequestDto);

        /*
         * - Create Purchase Requisition Request
         * - Create Purchase Requisition Approval based on created Purchase Requisition Request
         */
        PurchaseRequisitionRequest purchaseRequisitionRequest = purchaseRequisitionRequestMapper.toEntity(purchaseRequisitionRequestDto);
        purchaseRequisitionRequest.setCreatedDate(new Date());
        PurchaseRequisitionRequest savedPurchaseRequisitionRequest = purchaseRequisitionRequestRepository.saveAndFlush(purchaseRequisitionRequest);

        List<PurchaseRequisitionRequestItem> purchaseRequisitionRequestItemList = purchaseRequisitionRequestItemMapper.toEntity(purchaseRequisitionRequestDto.getPurchaseRequisitionRequestItems())
                .parallelStream()
                .peek(purchaseRequisitionRequestItem -> purchaseRequisitionRequestItem.setPurchaseRequisitionRequest(savedPurchaseRequisitionRequest))
                .collect(Collectors.toList());
        List<PurchaseRequisitionRequestItem> savedPurchaseRequisitionRequestItemList = purchaseRequisitionRequestItemRepository.saveAllAndFlush(purchaseRequisitionRequestItemList);

        Optional<PurchaseRequisitionRequest> latestPurchaseRequisitionRequest = purchaseRequisitionRequestRepository.findById(savedPurchaseRequisitionRequest.getId());

        /*
        Generate Purchase Requisition Approval after creating Purchase Requisition Request Successfully
         */
        latestPurchaseRequisitionRequest.ifPresent(latestPurchaseRequisitionRequestPresent -> {
            PurchaseRequisitionApproval purchaseRequisitionApproval = purchaseRequisitionRequestToApprovalMapper.toApproval(latestPurchaseRequisitionRequestPresent);
            purchaseRequisitionApproval.setPurchaseRequisitionApprovalItems(purchaseRequisitionRequestToApprovalMapper.toApprovalItem(purchaseRequisitionRequestItemList));
            PurchaseRequisitionApproval savedPurchaseRequisitionApproval = purchaseRequisitionApprovalRepository.saveAndFlush(purchaseRequisitionApproval);

            List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItemList = purchaseRequisitionApproval.getPurchaseRequisitionApprovalItems()
                    .parallelStream()
                    .peek(purchaseRequisitionApprovalItem -> {
                        purchaseRequisitionApprovalItem.setPurchaseRequisitionApproval(savedPurchaseRequisitionApproval);
                        purchaseRequisitionApprovalItem.setStatus(PurchaseRequisitionApprovalItemStatus.TO_CONFIRM);

                        /*
                        Set Item cost to the unit price of vendor item by default, user can override by updating approval item
                        Set default to unit price, or else set to 0
                         */
                        vendorItemRepository.findOneByVendorIDAndItem(
                                purchaseRequisitionApprovalItem.getVendorId(),
                                purchaseRequisitionApprovalItem.getComponentCode()
                        ).ifPresentOrElse(
                                vendorItem -> purchaseRequisitionApprovalItem.setItemCost(vendorItem.getViUnitPrice()),
                                () -> purchaseRequisitionApprovalItem.setItemCost(BigDecimal.ZERO)
                        );
                    })
                    .collect(Collectors.toList());

            purchaseRequisitionApprovalItemRepository.saveAllAndFlush(purchaseRequisitionApprovalItemList);
        });

        PurchaseRequisitionRequestDTO mappedPurchaseRequisitionDto = purchaseRequisitionRequestMapper.toDto(savedPurchaseRequisitionRequest);
        mappedPurchaseRequisitionDto.setPurchaseRequisitionRequestItems(purchaseRequisitionRequestItemMapper.toDto(savedPurchaseRequisitionRequestItemList));

        return mappedPurchaseRequisitionDto;
    }

    private List<PurchaseRequisitionRequestDTO> getPurchaseRequisitionRequestDTOS(List<PurchaseRequisitionRequest> purchaseRequisitionRequestList) {
        List<PurchaseRequisitionRequestDTO> purchaseRequisitionRequestDTOList = purchaseRequisitionRequestMapper.toDto(purchaseRequisitionRequestList);

        return purchaseRequisitionRequestDTOList
                .parallelStream()
                .peek(purchaseRequisitionRequestDTO -> {
                    Optional<PurchaseRequisitionRequest> purchaseRequisitionRequestOptional = purchaseRequisitionRequestList
                            .stream()
                            .filter(purchaseRequisitionRequest -> purchaseRequisitionRequest.getId() == purchaseRequisitionRequestDTO.getId())
                            .findFirst();

                    purchaseRequisitionRequestOptional.ifPresent(
                            purchaseRequisitionRequest -> purchaseRequisitionRequestDTO.setPurchaseRequisitionRequestItems(
                                    purchaseRequisitionRequestItemMapper.toDto(purchaseRequisitionRequest.getPurchaseRequisitionRequestItems())
                            )

                    );

                })
                .collect(Collectors.toList());
    }

}
