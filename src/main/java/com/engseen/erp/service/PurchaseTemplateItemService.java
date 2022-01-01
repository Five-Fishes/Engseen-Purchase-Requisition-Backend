package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseTemplateItemDto;

import org.springframework.data.domain.Pageable;

public interface PurchaseTemplateItemService {
    
    /**
     * Get all the PurchaseTemplateItems by PurchaseTemplateId.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    List<PurchaseTemplateItemDto> findAllByPurchaseTemplateId(Long purchaseTemplateId, Pageable pageable);

    /**
     * Create New Purchase Template Item
     *
     * @param purchaseTemplateItemDto entity to be create
     * @return the entity created
     */
	PurchaseTemplateItemDto create(PurchaseTemplateItemDto purchaseTemplateItemDto);

    /**
     * Update Purchase Template Item
     *
	 * @param purchaseTemplateItemId id of PurchaseTemplateItem to update
     * @param purchaseTemplateItemDto entity to be update
     * @return the entity updated
     */
	PurchaseTemplateItemDto update(Long purchaseTemplateItemId, PurchaseTemplateItemDto purchaseTemplateItemDto);

    /**
     * Delete the "id" PurchaseTemplateItem
	 * 
     * @param purchaseTemplateItemId the id of the entity.
     */
    void deleteByPurchaseTemplateItemId(Long purchaseTemplateItemId);

    /**
     * Delete all PurchaseTemplateItem based on PurchaseTemplateId
	 * 
     * @param purchaseTemplateId the id of Purchase Template.
     */
    void deleteByPurchaseTemplateId(Long purchaseTemplateId);
    
}
