package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseTemplateDto;

import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.thirdcc.webapp.entity.PruchaseTemplate}.
 */
public interface PurchaseTemplateService {

	/**
     * Get all the PurchaseTemplates.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    List<PurchaseTemplateDto> findAll(Pageable pageable);

	/**
     * Create New Purchase Template
     *
     * @param purchaseTemplateDto entity to be create
     * @return the entity created
     */
	PurchaseTemplateDto create(PurchaseTemplateDto purchaseTemplateDto);

	/**
     * Update Purchase Template
     *
	 * @param purchaseTemplateId id of PurchaseTemplate to update
     * @param purchaseTemplateDto entity to be update
     * @return the entity updated
     */
	PurchaseTemplateDto update(Long purchaseTemplateId, PurchaseTemplateDto purchaseTemplateDto);

	/**
     * Delete the "id" PurchaseTemplate.
     * Remove all template items tied to purchase template
	 * 
     * @param purchaseTemplateId the id of the entity.
     */
	void deleteByPurchaseTemplateId(Long purchaseTemplateId);

}
