package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.domain.PurchaseRequisitionRequestItem;
import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import com.engseen.erp.repository.PurchaseRequisitionTemplateItemRepository;
import com.engseen.erp.service.PurchaseRequisitionTemplateItemService;
import com.engseen.erp.service.dto.PurchaseRequisitionTemplateItemDTO;

import com.engseen.erp.service.mapper.PurchaseRequisitionTemplateItemMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.PurchaseRequisitionTemplateItem}.
 */
@Service
@RequiredArgsConstructor
public class PurchaseRequisitionTemplateItemServiceImpl implements PurchaseRequisitionTemplateItemService {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequisitionTemplateItemServiceImpl.class);
    
    private final PurchaseRequisitionTemplateItemRepository purchaseRequisitionTemplateItemRepository;
    private final PurchaseRequisitionTemplateItemMapper purchaseRequisitionTemplateItemMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequisitionTemplateItemDTO> findAllByPurchaseTemplateId(Long purchaseTemplateId, Pageable pageable) {
        log.debug("Request to findAll Purchase Template by Id: {}", purchaseTemplateId);
        
        List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItemList = purchaseRequisitionTemplateItemRepository
                .findAllByPurchaseRequisitionTemplate_Id(pageable, purchaseTemplateId)
                .toList();
        
        return purchaseRequisitionTemplateItemMapper.toDto(purchaseRequisitionTemplateItemList);
    }

    @Override
    public PurchaseRequisitionTemplateItemDTO create(PurchaseRequisitionTemplateItemDTO purchaseRequisitionTemplateItemDTO) {
        log.debug("Request to create Purchase Template Item: {}", purchaseRequisitionTemplateItemDTO);

        PurchaseRequisitionTemplateItem purchaseRequisitionTemplateItem = purchaseRequisitionTemplateItemMapper.toEntity(purchaseRequisitionTemplateItemDTO);
        PurchaseRequisitionTemplateItem savedPurchaseRequisitionTemplateItem = purchaseRequisitionTemplateItemRepository.save(purchaseRequisitionTemplateItem);
        
        return purchaseRequisitionTemplateItemMapper.toDto(savedPurchaseRequisitionTemplateItem);
    }

    @Override
    @Transactional
    public PurchaseRequisitionTemplateItemDTO update(Long purchaseTemplateItemId, PurchaseRequisitionTemplateItemDTO purchaseRequisitionTemplateItemDTO) {
        log.debug("Request to update Purchase Template Item: {} with id: {}", purchaseRequisitionTemplateItemDTO, purchaseTemplateItemId);
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public void deleteByPurchaseTemplateItemId(Long purchaseTemplateItemId) {
        log.debug("Request to delete Purchase Template Item by Id: {}", purchaseTemplateItemId);
        // TODO Auto-generated method stub
    }

    @Override
    @Transactional
    public void deleteByPurchaseTemplateId(Long purchaseTemplateId) {
        log.debug("Request to delete Purchase Template by Id: {}", purchaseTemplateId);
        // TODO Auto-generated method stub
    }
    
}
