package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseRequisitionTemplateItemDTO;

import org.springframework.data.domain.Pageable;

public interface PurchaseRequisitionTemplateItemService {
    
    /**
     * Get all the PurchaseTemplateItems by PurchaseTemplateId.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    List<PurchaseRequisitionTemplateItemDTO> findAllByPurchaseTemplateId(Long purchaseTemplateId, Pageable pageable);

    /**
     * Create New Purchase Template Item
     *
     * @param purchaseRequisitionTemplateItemDTO entity to be create
     * @return the entity created
     */
	PurchaseRequisitionTemplateItemDTO create(PurchaseRequisitionTemplateItemDTO purchaseRequisitionTemplateItemDTO);

    /**
     * Update Purchase Template Item
     *
	 * @param purchaseTemplateItemId id of PurchaseTemplateItem to update
     * @param purchaseRequisitionTemplateItemDTO entity to be update
     * @return the entity updated
     */
	PurchaseRequisitionTemplateItemDTO update(Long purchaseTemplateItemId, PurchaseRequisitionTemplateItemDTO purchaseRequisitionTemplateItemDTO);

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
