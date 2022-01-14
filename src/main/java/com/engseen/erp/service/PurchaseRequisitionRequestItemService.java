package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseRequisitionRequestItemDTO;

import org.springframework.data.domain.Pageable;

public interface PurchaseRequisitionRequestItemService {

    /**
     * Get all the PurchaseRequestSubmissionItems by PurchaseRequestSubmissionId.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    List<PurchaseRequisitionRequestItemDTO> findAllByPurchaseRequestSubmissionId(Long purchaseRequestSubmissionId, Pageable pageable);

    /**
     * Create New Purchase Request Submission Item
     *
     * @param purchaseRequisitionRequestItemDTO entity to be create
     * @return the entity created
     */
    PurchaseRequisitionRequestItemDTO create(PurchaseRequisitionRequestItemDTO purchaseRequisitionRequestItemDTO);

    /**
     * Delete the "id" PurchaseRequestSubmissionItem
     *
     * @param purchaseRequestSubmissionItemId the id of the entity.
     */
    void deleteByPurchaseRequestSubmissionItemId(Long purchaseRequestSubmissionItemId);

    /**
     * Delete all PurchaseRequestSubmissionItem based on PurchaseRequestSubmissionId
     *
     * @param purchaseRequestSubmissionId the id of Purchase Request Submission.
     */
    void deleteByPurchaseRequestSubmissionId(Long purchaseRequestSubmissionId);

}
