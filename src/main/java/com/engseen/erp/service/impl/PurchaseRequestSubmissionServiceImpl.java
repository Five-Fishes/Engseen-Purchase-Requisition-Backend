package com.engseen.erp.service.impl;

import java.util.Date;
import java.util.List;

import com.engseen.erp.domain.PurchaseRequisitionApproval;
import com.engseen.erp.domain.PurchaseRequisitionApprovalItem;
import com.engseen.erp.domain.PurchaseRequisitionRequest;
import com.engseen.erp.domain.PurchaseRequisitionRequestItem;
import com.engseen.erp.repository.PurchaseRequisitionApprovalItemRepository;
import com.engseen.erp.repository.PurchaseRequisitionApprovalRepository;
import com.engseen.erp.repository.PurchaseRequisitionRequestItemRepository;
import com.engseen.erp.repository.PurchaseRequisitionRequestRepository;
import com.engseen.erp.service.PurchaseRequestSubmissionService;
import com.engseen.erp.service.dto.PurchaseRequisitionRequestDTO;

import com.engseen.erp.service.mapper.PurchaseRequisitionRequestItemMapper;
import com.engseen.erp.service.mapper.PurchaseRequisitionRequestMapper;
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
public class PurchaseRequestSubmissionServiceImpl implements PurchaseRequestSubmissionService {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequestSubmissionServiceImpl.class);

    private final PurchaseRequisitionApprovalRepository purchaseRequisitionApprovalRepository;
    private final PurchaseRequisitionApprovalItemRepository purchaseRequisitionApprovalItemRepository;
    private final PurchaseRequisitionRequestRepository purchaseRequisitionRequestRepository;
    private final PurchaseRequisitionRequestItemRepository purchaseRequisitionRequestItemRepository;
    private final PurchaseRequisitionRequestMapper purchaseRequisitionRequestMapper;
    private final PurchaseRequisitionRequestItemMapper purchaseRequisitionRequestItemMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequisitionRequestDTO> findAll(Pageable pageable) {
        log.debug("Request to findAll Purchase Request Submission");
        List<PurchaseRequisitionRequest> purchaseRequisitionRequestList = purchaseRequisitionRequestRepository
                .findAll(pageable)
                .toList();

        return purchaseRequisitionRequestMapper.toDto(purchaseRequisitionRequestList);
    }

    @Override
    public PurchaseRequisitionRequestDTO create(PurchaseRequisitionRequestDTO purchaseRequisitionRequestDto) {
        log.debug("Request to create Purchase Request Submission: {}", purchaseRequisitionRequestDto);

        /*
         * - Create Purchase Requisition Request
         * - Create Purchase Requisition Approval based on created Purchase Requisition Request
         */
        PurchaseRequisitionRequest purchaseRequisitionRequest = purchaseRequisitionRequestMapper.toEntity(purchaseRequisitionRequestDto);
        log.debug("purchaseRequisitionRequest: {}", purchaseRequisitionRequest);
        purchaseRequisitionRequest.setCreatedDate(new Date());
        PurchaseRequisitionRequest savedPurchaseRequisitionRequest = purchaseRequisitionRequestRepository.saveAndFlush(purchaseRequisitionRequest);

        purchaseRequisitionRequestDto
                .getPurchaseRequisitionRequestItems()
                .forEach(purchaseRequisitionRequestItemDTO -> {
                    PurchaseRequisitionRequestItem purchaseRequisitionRequestItem = purchaseRequisitionRequestItemMapper.toEntity(purchaseRequisitionRequestItemDTO);
                    purchaseRequisitionRequestItem.setPurchaseRequisitionRequest(savedPurchaseRequisitionRequest);
                    log.debug("purchaseRequisitionRequestItem: {}", purchaseRequisitionRequestItem);
                    purchaseRequisitionRequestItemRepository.saveAndFlush(purchaseRequisitionRequestItem);
                });

        PurchaseRequisitionApproval purchaseRequisitionApproval = new PurchaseRequisitionApproval();
        purchaseRequisitionApproval.setCreatedDate(new Date());
        purchaseRequisitionApproval.setRemarks(savedPurchaseRequisitionRequest.getRemarks());
        PurchaseRequisitionApproval savedPurchaseRequisitionApproval = purchaseRequisitionApprovalRepository.saveAndFlush(purchaseRequisitionApproval);

        savedPurchaseRequisitionRequest
                .getPurchaseRequisitionRequestItems()
                .forEach(purchaseRequisitionRequestItem -> {
                    PurchaseRequisitionApprovalItem purchaseRequisitionApprovalItem = new PurchaseRequisitionApprovalItem();
                    purchaseRequisitionApprovalItem.setPurchaseRequisitionApproval(savedPurchaseRequisitionApproval);
                    purchaseRequisitionApprovalItemRepository.save(purchaseRequisitionApprovalItem);
                });

        return purchaseRequisitionRequestMapper.toDto(savedPurchaseRequisitionRequest);
    }

}
