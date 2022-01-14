package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.service.PurchaseTemplateService;
import com.engseen.erp.service.dto.PurchaseRequisitionTemplateDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.PurchaseRequisitionTemplate}.
 */
@Service
@Transactional
public class PurchaseTemplateServiceImpl implements PurchaseTemplateService {

    private final Logger log = LoggerFactory.getLogger(PurchaseTemplateServiceImpl.class);

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequisitionTemplateDTO> findAll(Pageable pageable) {
        log.debug("Request to findAll Purchase Template");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseRequisitionTemplateDTO create(PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO) {
        log.debug("Request to create Purchase Template: {}", purchaseRequisitionTemplateDTO);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseRequisitionTemplateDTO update(Long purchaseTemplateId, PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO) {
        log.debug("Request to update Purchase Template: {} with Id: {}", purchaseRequisitionTemplateDTO, purchaseTemplateId);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteByPurchaseTemplateId(Long purchaseTemplateId) {
        log.debug("Request to delete Purchase Template with Id: {}", purchaseTemplateId);
        // TODO Auto-generated method stub
    }

}
