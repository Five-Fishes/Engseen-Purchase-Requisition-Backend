package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseOrderDto;
import com.engseen.erp.service.dto.PurchaseOrderRequestApprovalDto;

import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.thirdcc.webapp.entity.PurchaseOrder}.
 */
public interface PurchaseOrderService {

	/**
     * Get all the PurchaseOrderRequestApproval.
     *
     * @param pageable the pagination information.
     * @return the list of entities group by Purchase Request Approval.
     */
	List<PurchaseOrderRequestApprovalDto> findAllGroupByPurchaseRequestApproval(Pageable pageable);

    /**
     * Get all the PurchaseOrder by Purchase Request Approval Id.
     *
     * @param purchaseRequestApprovalId
     * @param pageable the pagination information.
     * @return the list of entities.
     */
	List<PurchaseOrderDto> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable);

    /**
     * Issue PO based on vendor
     * <p>One PO per vendor</p>
     *
     * @param purchaseRequestApprovalId Id of Purchase Request Approval to issue PO
     * @return the list of PO issue/created
     */
	List<PurchaseOrderDto> issuePO(Long purchaseRequestApprovalId);

    /**
     * Email PO to vendor
     * 
     * @param purchaseOrderId id of PO to email
     * @return status of email sent
     */
	Boolean emailPO(Long purchaseOrderId);

    /**
     * Generate PO as PDF file to download
     *  
     * @param purchaseOrderId
     * @return Base64 encoded String of PO PDF file
     */
	String downloadPO(Long purchaseOrderId);

}
