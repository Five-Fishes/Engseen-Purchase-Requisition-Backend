package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseRequestApprovalItemDto;

import org.springframework.data.domain.Pageable;

public interface PurchaseRequestApprovalItemService {

    /**
     * Get all the PurchaseRequestApprovalItems by PurchaseRequestApprovalId.
     *
     * @param purchaseRequestApprovalId Id of Purchase Request Approval
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    List<PurchaseRequestApprovalItemDto> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable);

    /**
     * Add Purchase Request Approval Item
     *
     * @param purchaseRequestApprovalItemDto entity to be add
     * @return the entity added
     */
    PurchaseRequestApprovalItemDto add(PurchaseRequestApprovalItemDto purchaseRequestApprovalItemDto);

    /**
     * Update Purchase Request Approval Item
     *
	 * @param purchaseRequestApprovalItemId "id" of Purchase Request Approval Item to update
     * @param purchaseRequestApprovalItemDto entity to be update
     * @return the entity updated
     */
	PurchaseRequestApprovalItemDto update(Long purchaseRequestApprovalItemId, PurchaseRequestApprovalItemDto purchaseRequestApprovalItemDto);

    /**
     * Delete Purchase Request Approval Item
     *
	 * @param purchaseRequestApprovalItemId "id" of Purchase Request Approval Item to delete
     */
	void delete(Long purchaseRequestApprovalItemId);

}
