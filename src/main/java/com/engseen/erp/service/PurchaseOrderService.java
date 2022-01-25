package com.engseen.erp.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.engseen.erp.service.dto.PurchaseOrderDto;
import com.engseen.erp.service.dto.PurchaseOrderRequestApprovalDto;

import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.engseen.erp.domain.POHeader} and {@link com.engseen.erp.domain.PODetail}.
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
     * @param purchaseRequestApprovalId Id of purchase request approval
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
     * @throws Exception exception while generating PO
     */
	List<PurchaseOrderDto> issuePO(Long purchaseRequestApprovalId) throws Exception;

    /**
     * Email PO to vendor
     * 
     * @param purchaseOrderId id of PO to email
     * @return status of email sent
     * @throws IOException exception while emailing PO
     */
	Boolean emailPO(Long purchaseOrderId) throws Exception;

    /**
     * Generate PO as PDF file to download
     *  
     * @param purchaseOrderId Id of purchase order
     * @return Base64 encoded String of PO PDF file
	 * @throws IOException Exception generating pdf
     */
	String downloadPOBase64String(Long purchaseOrderId) throws IOException;

	/**
	 * Generate PO as PDF file to download
	 *
	 * @param purchaseOrderId Id of purchase order
	 * @return generated PO pdf file
	 * @throws IOException Exception generating pdf
	 */
	File downloadPOFile(Long purchaseOrderId) throws IOException;

}
