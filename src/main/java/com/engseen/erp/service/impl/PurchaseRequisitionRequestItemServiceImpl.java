package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.service.PurchaseRequisitionRequestItemService;
import com.engseen.erp.service.dto.PurchaseRequisitionRequestItemDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.PurchaseRequisitionRequestItem}.
 */
@Service
@Transactional
public class PurchaseRequisitionRequestItemServiceImpl implements PurchaseRequisitionRequestItemService {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequisitionRequestItemServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequisitionRequestItemDTO> findAllByPurchaseRequestSubmissionId(Long purchaseRequestSubmissionId, Pageable pageable) {
        log.debug("Request to findAll Purchase Request Submission Item");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseRequisitionRequestItemDTO create(PurchaseRequisitionRequestItemDTO purchaseRequisitionRequestItemDTO) {
        log.debug("Request to create Purchase Request Submission Item: {}", purchaseRequisitionRequestItemDTO);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteByPurchaseRequestSubmissionItemId(Long purchaseRequestSubmissionItemId) {
        log.debug("Request to delete Purchase RequestSubmission Item by Id: {}", purchaseRequestSubmissionItemId);
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteByPurchaseRequestSubmissionId(Long purchaseRequestSubmissionId) {
        log.debug("Request to delete Purchase RequestSubmission by Id: {}", purchaseRequestSubmissionId);
        // TODO Auto-generated method stub
    }

}
