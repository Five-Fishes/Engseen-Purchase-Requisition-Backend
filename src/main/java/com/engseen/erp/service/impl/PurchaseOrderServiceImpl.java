package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.service.PurchaseOrderService;
import com.engseen.erp.service.dto.PurchaseOrderDto;
import com.engseen.erp.service.dto.PurchaseOrderRequestApprovalDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PurchaseOrder}.
 */
@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private final Logger log = LoggerFactory.getLogger(PurchaseOrderServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderRequestApprovalDto> findAllGroupByPurchaseRequestApproval(Pageable pageable) {
        log.debug("Request to findAll Purchase Order group by Purchase Request Approval");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderDto> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable) {
        log.debug("Request to findAll Purchase Order by Purchase Request Approval Id");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<PurchaseOrderDto> issuePO(Long purchaseRequestApprovalId) {
        log.debug("Request to issue PO by Purchase Request Approval Id");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean emailPO(Long purchaseOrderId) {
        log.debug("Request to email PO by Purchase Order Id");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String downloadPO(Long purchaseOrderId) {
        log.debug("Request to download PO by Purchase Order Id");
        // TODO Auto-generated method stub
        return null;
    }
    
}
