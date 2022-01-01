package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.service.PurchaseTemplateService;
import com.engseen.erp.service.dto.PurchaseTemplateDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PurchaseTemplate}.
 */
@Service
@Transactional
public class PurchaseTemplateServiceImpl implements PurchaseTemplateService {

    private final Logger log = LoggerFactory.getLogger(PurchaseTemplateServiceImpl.class);

    @Override
    public List<PurchaseTemplateDto> findAll(Pageable pageable) {
        log.debug("Request to findAll Purchase Template");
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseTemplateDto create(PurchaseTemplateDto purchaseTemplateDto) {
        log.debug("Request to create Purchase Template: {}", purchaseTemplateDto);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseTemplateDto update(Long purchaseTemplateId, PurchaseTemplateDto purchaseTemplateDto) {
        log.debug("Request to update Purchase Template: {} with Id: {}", purchaseTemplateDto, purchaseTemplateId);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteByPurchaseTemplateId(Long purchaseTemplateId) {
        log.debug("Request to delete Purchase Template with Id: {}", purchaseTemplateId);
        // TODO Auto-generated method stub
    }

}
