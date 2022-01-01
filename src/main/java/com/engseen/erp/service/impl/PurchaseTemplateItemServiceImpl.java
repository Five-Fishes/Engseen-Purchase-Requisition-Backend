package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.service.PurchaseTemplateItemService;
import com.engseen.erp.service.dto.PurchaseTemplateItemDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PurchaseTemplateItem}.
 */
@Service
@Transactional
public class PurchaseTemplateItemServiceImpl implements PurchaseTemplateItemService {

    private final Logger log = LoggerFactory.getLogger(PurchaseTemplateItemServiceImpl.class);

    @Override
    public List<PurchaseTemplateItemDto> findAllByPurchaseTemplateId(Long purchaseTemplateId, Pageable pageable) {
        log.debug("Request to findAll Purchase Template by Id: {}", purchaseTemplateId);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseTemplateItemDto create(PurchaseTemplateItemDto purchaseTemplateItemDto) {
        log.debug("Request to create Purchase Template Item: {}", purchaseTemplateItemDto);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PurchaseTemplateItemDto update(Long purchaseTemplateItemId, PurchaseTemplateItemDto purchaseTemplateItemDto) {
        log.debug("Request to update Purchase Template Item: {} with id: {}", purchaseTemplateItemDto, purchaseTemplateItemId);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteByPurchaseTemplateItemId(Long purchaseTemplateItemId) {
        log.debug("Request to delete Purchase Template Item by Id: {}", purchaseTemplateItemId);
        // TODO Auto-generated method stub
    }

    @Override
    public void deleteByPurchaseTemplateId(Long purchaseTemplateId) {
        log.debug("Request to delete Purchase Template by Id: {}", purchaseTemplateId);
        // TODO Auto-generated method stub
    }
    
}
