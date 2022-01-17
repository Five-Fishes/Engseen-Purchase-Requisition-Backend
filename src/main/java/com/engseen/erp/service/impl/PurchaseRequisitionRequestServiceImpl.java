package com.engseen.erp.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.engseen.erp.domain.PurchaseRequisitionApproval;
import com.engseen.erp.domain.PurchaseRequisitionApprovalItem;
import com.engseen.erp.domain.PurchaseRequisitionRequest;
import com.engseen.erp.domain.PurchaseRequisitionRequestItem;
import com.engseen.erp.repository.PurchaseRequisitionApprovalItemRepository;
import com.engseen.erp.repository.PurchaseRequisitionApprovalRepository;
import com.engseen.erp.repository.PurchaseRequisitionRequestItemRepository;
import com.engseen.erp.repository.PurchaseRequisitionRequestRepository;
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

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequisitionRequestDTO> findAll(Pageable pageable) {
        log.debug("Request to findAll Purchase Request Submission");
        List<PurchaseRequisitionRequest> purchaseRequisitionRequestList = purchaseRequisitionRequestRepository
                .findAll(pageable)
                .toList();

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
        latestPurchaseRequisitionRequest.ifPresent( latestPurchaseRequisitionRequestPresent -> {
            PurchaseRequisitionApproval purchaseRequisitionApproval = purchaseRequisitionRequestToApprovalMapper.toApproval(latestPurchaseRequisitionRequestPresent);
            purchaseRequisitionApproval.setPurchaseRequisitionApprovalItems(purchaseRequisitionRequestToApprovalMapper.toApprovalItem(purchaseRequisitionRequestItemList));
            PurchaseRequisitionApproval savedPurchaseRequisitionApproval = purchaseRequisitionApprovalRepository.saveAndFlush(purchaseRequisitionApproval);

            List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItemList = purchaseRequisitionApproval.getPurchaseRequisitionApprovalItems()
                    .parallelStream()
                    .peek(purchaseRequisitionApprovalItem -> purchaseRequisitionApprovalItem.setPurchaseRequisitionApproval(savedPurchaseRequisitionApproval)).collect(Collectors.toList());

            purchaseRequisitionApprovalItemRepository.saveAllAndFlush(purchaseRequisitionApprovalItemList);
        });

        PurchaseRequisitionRequestDTO mappedPurchaseRequisitionDto = purchaseRequisitionRequestMapper.toDto(savedPurchaseRequisitionRequest);
        mappedPurchaseRequisitionDto.setPurchaseRequisitionRequestItems(purchaseRequisitionRequestItemMapper.toDto(savedPurchaseRequisitionRequestItemList));

        return mappedPurchaseRequisitionDto;
    }

}
