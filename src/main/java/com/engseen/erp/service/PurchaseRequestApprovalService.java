package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseRequestApprovalDto;

import org.springframework.data.domain.Pageable;

public interface PurchaseRequestApprovalService {

	/**
     * Get all the PurchaseRequestApproval.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
	List<PurchaseRequestApprovalDto> findAll(Pageable pageable);

	/**
     * Update Purchase Request Approval
     *
	 * @param purchaseRequestApprovalId "id" of Purchase Request Approval to update
     * @param purchaseRequestApprovalDto entity to be update
     * @return the entity updated
     */
	PurchaseRequestApprovalDto update(Long purchaseRequestApprovalId, PurchaseRequestApprovalDto purchaseRequestApprovalDto);

}
