package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.service.PurchaseRequestApprovalItemService;
import com.engseen.erp.service.dto.PurchaseRequestApprovalItemDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PurchaseRequestApprovalItem}.
 */
@Service
@Transactional
public class PurchaseRequestApprovalItemServiceImpl implements PurchaseRequestApprovalItemService {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequestApprovalServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequestApprovalItemDto> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable) {
        log.debug("Request to findAll Purchase Request Approval Item");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseRequestApprovalItemDto add(PurchaseRequestApprovalItemDto purchaseRequestApprovalItemDto) {
        log.debug("Request to add Purchase Request Approval Item");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseRequestApprovalItemDto update(Long purchaseRequestApprovalItemId, PurchaseRequestApprovalItemDto purchaseRequestApprovalItemDto) {
        log.debug("Request to update Purchase Request Approval Item");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long purchaseRequestApprovalItemId) {
        log.debug("Request to delete Purchase Request Approval Item");
        // TODO Auto-generated method stub
    }
    
}
