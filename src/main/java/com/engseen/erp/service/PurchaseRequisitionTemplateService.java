package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseRequisitionTemplateDTO;

import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.engseen.erp.domain.PurchaseRequisitionTemplate}.
 */
public interface PurchaseRequisitionTemplateService {

    /**
     * Get all the PurchaseTemplates.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    List<PurchaseRequisitionTemplateDTO> findAll(Pageable pageable);

    /**
     * Get all the PurchaseTemplates.
     *
     * @param purchaseRequisitionTemplateId Id of Purchase Requisition Template.
     * @return the list of entities.
     */
    PurchaseRequisitionTemplateDTO findById(long purchaseRequisitionTemplateId);

    /**
     * Create New Purchase Template
     *
     * @param purchaseRequisitionTemplateDTO entity to be create
     * @return the entity created
     */
    PurchaseRequisitionTemplateDTO create(PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO);

    /**
     * Update Purchase Template
     *
     * @param purchaseTemplateId id of PurchaseTemplate to update
     * @param purchaseRequisitionTemplateDTO entity to be update
     * @return the entity updated
     */
    PurchaseRequisitionTemplateDTO update(Long purchaseTemplateId, PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO);

    /**
     * Delete the "id" PurchaseTemplate.
     * Remove all template items tied to purchase template
     * 
     * @param purchaseTemplateId the id of the entity.
     */
    void deleteByPurchaseTemplateId(Long purchaseTemplateId);

}
