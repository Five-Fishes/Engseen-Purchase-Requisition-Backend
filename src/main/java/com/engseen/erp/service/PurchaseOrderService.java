package com.engseen.erp.service;

import java.io.File;
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
     * @param purchaseRequestApprovalId purchase requisition approval id
     * @param pageable                  the pagination information.
     * @return the list of entities.
     */
    List<PurchaseOrderDto> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable);

    /**
     * Issue PO based on vendor
     * <p>One PO per vendor</p>
     *
     * @param purchaseRequestApprovalId Id of Purchase Request Approval to issue PO
     * @return the list of PO issue/created
     * @throws Exception exception while issuing PO
     */
    List<PurchaseOrderDto> issuePO(Long purchaseRequestApprovalId) throws Exception;

    /**
     * Email PO to vendor
     *
     * @param purchaseOrderId id of PO to email
     * @return status of email sent
     * @throws IOException exception while mailing PO
     */
    Boolean emailPO(Long purchaseOrderId) throws Exception;

    /**
     * Generate PO as PDF file to download
     *
     * @param purchaseOrderId exception while generating PO pdf base 64 string
     * @return Base64 encoded String of PO PDF file
     */
    String downloadPOPdfBase64String(Long purchaseOrderId) throws IOException;

    /**
     * Generate PO as PDF file to download
     *
     * @param purchaseOrderId Id of purchase order
     * @return generated PO pdf file
     * @throws IOException Exception generating PO pdf file
     */
    File downloadPOFile(Long purchaseOrderId) throws IOException;

    /**
     * Generate HTML String to be used for PDF generation
     *
     * @param purchaseOrderId ID of purchase order to generate an HTML String
     * @return HTML String
     */
    String getPOHtml(Long purchaseOrderId);
}
