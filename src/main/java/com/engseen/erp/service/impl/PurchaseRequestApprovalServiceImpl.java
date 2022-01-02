package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.service.PurchaseRequestApprovalService;
import com.engseen.erp.service.dto.PurchaseRequestApprovalDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PurchaseRequestApproval}.
 */
@Service
@Transactional
public class PurchaseRequestApprovalServiceImpl implements PurchaseRequestApprovalService {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequestApprovalServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequestApprovalDto> findAll(Pageable pageable) {
        log.debug("Request to findAll Purchase Request Approval");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseRequestApprovalDto update(Long purchaseRequestApprovalId, PurchaseRequestApprovalDto purchaseRequestApprovalDto) {
        log.debug("Request to update Purchase Request Approval");
        // TODO Auto-generated method stub
        return null;
    }
    
}
