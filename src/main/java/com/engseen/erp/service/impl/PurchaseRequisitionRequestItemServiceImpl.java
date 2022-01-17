package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.domain.PurchaseRequisitionRequestItem;
import com.engseen.erp.repository.PurchaseRequisitionRequestItemRepository;
import com.engseen.erp.service.PurchaseRequisitionRequestItemService;
import com.engseen.erp.service.dto.PurchaseRequisitionRequestItemDTO;

import com.engseen.erp.service.mapper.PurchaseRequisitionRequestItemMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.PurchaseRequisitionRequestItem}.
 */
@Service
@RequiredArgsConstructor
public class PurchaseRequisitionRequestItemServiceImpl implements PurchaseRequisitionRequestItemService {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequisitionRequestItemServiceImpl.class);

    private final PurchaseRequisitionRequestItemRepository purchaseRequisitionRequestItemRepository;
    private final PurchaseRequisitionRequestItemMapper purchaseRequisitionRequestItemMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequisitionRequestItemDTO> findAllByPurchaseRequestSubmissionId(Long purchaseRequestSubmissionId, Pageable pageable) {
        log.debug("Request to findAll Purchase Request Submission Item");

        List<PurchaseRequisitionRequestItem> purchaseRequisitionRequestItemList = purchaseRequisitionRequestItemRepository
                .findAllByPurchaseRequisitionRequest_Id(pageable, purchaseRequestSubmissionId)
                .toList();

        return purchaseRequisitionRequestItemMapper.toDto(purchaseRequisitionRequestItemList);
    }

    @Override
    public PurchaseRequisitionRequestItemDTO create(PurchaseRequisitionRequestItemDTO purchaseRequisitionRequestItemDTO) {
        log.debug("Request to create Purchase Request Submission Item: {}", purchaseRequisitionRequestItemDTO);

        PurchaseRequisitionRequestItem purchaseRequisitionRequestItem = purchaseRequisitionRequestItemMapper.toEntity(purchaseRequisitionRequestItemDTO);
        PurchaseRequisitionRequestItem savedPurchaseRequisitionItem = purchaseRequisitionRequestItemRepository.save(purchaseRequisitionRequestItem);

        return purchaseRequisitionRequestItemMapper.toDto(savedPurchaseRequisitionItem);
    }

    @Override
    @Transactional
    public void deleteByPurchaseRequestSubmissionItemId(Long purchaseRequestSubmissionItemId) {
        log.debug("Request to delete Purchase RequestSubmission Item by Id: {}", purchaseRequestSubmissionItemId);

        purchaseRequisitionRequestItemRepository.deleteById(purchaseRequestSubmissionItemId);
    }

    @Override
    @Transactional
    public void deleteByPurchaseRequestSubmissionId(Long purchaseRequisitionRequestId) {
        log.debug("Request to delete Purchase RequestSubmission by Id: {}", purchaseRequisitionRequestId);

        purchaseRequisitionRequestItemRepository.deleteAllByPurchaseRequisitionRequest_Id(purchaseRequisitionRequestId);
    }

    // TODO: [LU] Please ensure the reference to dependent entity is set correctly before saving child items
}
