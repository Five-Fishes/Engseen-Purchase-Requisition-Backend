package com.engseen.erp.controller.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.engseen.erp.service.PurchaseOrderItemService;
import com.engseen.erp.service.PurchaseOrderService;
import com.engseen.erp.service.dto.PurchaseOrderDto;
import com.engseen.erp.service.dto.PurchaseOrderItemDto;
import com.engseen.erp.service.dto.PurchaseOrderRequestApprovalDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for managing {@link com.engseen.erp.domain.POHeader} and {@link com.engseen.erp.domain.PODetail}.
 */
@RequestMapping("/api/purchase-order")
@RestController
public class PurchaseOrderController {

    private final Logger log = LoggerFactory.getLogger(PurchaseOrderController.class);

    private final PurchaseOrderService purchaseOrderService;

    private final PurchaseOrderItemService purchaseOrderItemService;

    @Autowired
    public PurchaseOrderController(PurchaseOrderService purchaseOrderService, PurchaseOrderItemService purchaseOrderItemService) {
        this.purchaseOrderService = purchaseOrderService;
        this.purchaseOrderItemService = purchaseOrderItemService;
    }

    /**
     * {@code GET /purchase-order} : Get all Purchase Order
     * 
     * @param pageable Pagination Info
     * @param startDate startDate to filter based on created date of Purchase Order
     * @param endDate endDate to filter based on created date of Purchase Order
     */
    @GetMapping(value="")
    public ResponseEntity<List<PurchaseOrderRequestApprovalDto>> getAllPurchaseOrder(Pageable pageable, @RequestParam(required = false, name = "startDate") Date startDate, @RequestParam(required = false, name = "endDate") Date endDate) {
        log.info("REST Request to getAllPurchaseOrder");
        log.debug("Pagination Info: {}", pageable);
        log.debug("Filter by Start Date: {}, End Date: {}", startDate, endDate);
        List<PurchaseOrderRequestApprovalDto> purchaseOrderDtoList = purchaseOrderService.findAllGroupByPurchaseRequestApproval(pageable);
        return ResponseEntity.ok()
            .body(purchaseOrderDtoList);
    }

    /**
     * {@code POST /purchase-order/{purchaseRequestApprovalId}} : Issue Purchase Order based on Purchase Request Approval Id
     * 
     * @param purchaseRequestApprovalId Id of Purchase Request Approval to Issue PO
     * @throws Exception error while issuing PO
     */
    @PostMapping(value="/{purchaseRequestApprovalId}")
    public ResponseEntity<List<PurchaseOrderDto>> issuePurchaseOrder(@PathVariable Long purchaseRequestApprovalId) throws Exception {
        log.info("REST Request to issuePurchaseOrder on confirmed Item for Purchase Request Approval with Id: {}", purchaseRequestApprovalId);
        List<PurchaseOrderDto> savedPurchaseOrderDto = purchaseOrderService.issuePO(purchaseRequestApprovalId);
        return ResponseEntity.ok()
            .body(savedPurchaseOrderDto);
    }

    /**
     * {@code POST /purchase-order/email/{purchaseOrderId}} : Email Purchase Order
     * 
     * @param purchaseOrderId Id of Purchase Order
     */
    @PostMapping(value="/email/{purchaseOrderId}")
    public ResponseEntity<Void> emailPurchaseOrder(@PathVariable Long purchaseOrderId) throws Exception {
        log.info("REST Request to emailPurchaseOrder with Id: {}", purchaseOrderId);
        Boolean emailSent = purchaseOrderService.emailPO(purchaseOrderId);
        return ResponseEntity.ok()
            .build();
    }

    /**
     * {@code POST /purchase-order/download/{purchaseOrderId}} : Download Purchase Order
     *
     * @param purchaseOrderId Id of Purchase Order
     */
    @PostMapping(value = "/download/{purchaseOrderId}")
    public ResponseEntity<Resource> downloadPurchaseOrder(@PathVariable Long purchaseOrderId) throws IOException {
        log.info("REST Request to downloadPurchaseOrder with Id: {}", purchaseOrderId);

        File poPdfFile = purchaseOrderService.downloadPOFile(purchaseOrderId);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(poPdfFile));

        return ResponseEntity.ok()
                .contentLength(poPdfFile.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    /**
     * {@code POST /purchase-order/download-email/{purchaseRequestApprovalId}} : Download and Email all Purchase Order based on purchaseRequestApprovalId
     * 
     * @param purchaseRequestApprovalId Id of Purchase Request Approval
     */
    @PostMapping(value="/download-email/{purchaseRequestApprovalId}")
    public ResponseEntity<?> downloadAndEmailByPurchaseRequestApprvoalId(@PathVariable Long purchaseRequestApprovalId) throws Exception {
        log.info("REST Request to downloadAndEmailByPurchaseRequestApprvoalId with Purchase Request Approval Id: {}", purchaseRequestApprovalId);
        List<PurchaseOrderDto> purchaseOrderDtoList = purchaseOrderService.findAllByPurchaseRequestApprovalId(purchaseRequestApprovalId, Pageable.unpaged()              );
        for (PurchaseOrderDto purchaseOrderDto : purchaseOrderDtoList) {
            Boolean emailSent = purchaseOrderService.emailPO(purchaseOrderDto.getId());
            String fileBase64String = purchaseOrderService.downloadPOPdfBase64String(purchaseOrderDto.getId());
        }
        return ResponseEntity.ok()
            .body(null);
    }

    @GetMapping("/po-html/{purchaseOrderId}")
    public ResponseEntity<String> getPOHtmlString(@PathVariable Long purchaseOrderId) {
        return ResponseEntity.ok(purchaseOrderService.getPOHtml(purchaseOrderId));
    }

    /**
     * {@code GET /purchase-order/outstanding-item} : Get all Purchase Order Outstanding Item
     *
     * @param pageable Pagination Info
     * @param vendorId VendorId of Purchase Order for filtering
     */
    @GetMapping(value="/outstanding-item")
    public ResponseEntity<List<PurchaseOrderItemDto>> getAllOutstandingPOItem(@RequestParam(required = false) Pageable pageable, @RequestParam(required = false, name = "vendorId") String vendorId) {
        log.info("REST Request to getAllOutstandingPOItem");
        log.debug("Pagination Info: {}", pageable);
        log.debug("Filter by Vendor Id: {}", vendorId);
        List<PurchaseOrderItemDto> purchaseOrderItemDtoList;
        purchaseOrderItemDtoList = purchaseOrderItemService.findAllOutstandingPurchaseOrderItemByVendorId(pageable, vendorId);
        return ResponseEntity.ok()
            .body(purchaseOrderItemDtoList);
    }

    /**
     * {@code GET /purchase-order/{grnNo}/outstanding-item/{vendorId}} : Get all Purchase Order Receipt
     *
     * @param grnNo GRN No for received PO Item
     * @param vendorId VendorId for outstandin PO Item
     */
    @GetMapping(value = "/{grnNo}/outstanding-item/{vendorId}")
    public ResponseEntity<List<PurchaseOrderItemDto>> getGrnPOReceiptWithVendorOutstandingPO(@PathVariable("grnNo") String grnNo, @PathVariable("vendorId") String vendorId) {
        log.info("REST Request to getGrnPOReceiptWithVendorOutstandingPO");
        log.debug("Vendor ID: {}", vendorId);
        log.debug("GRN No: {}", grnNo);

        List<PurchaseOrderItemDto> purchaseOrderItemDtoList = purchaseOrderItemService.findAllOutstandingPurchaseOrderItemByVendorId(Pageable.unpaged(), vendorId);
        log.debug("Outstanding PO Item List: {}", purchaseOrderItemDtoList);
        List<PurchaseOrderItemDto> purchaseOrderItemCompletedList = purchaseOrderItemService.findAllReceivedPurchaseOrderItemByGrnNo(Pageable.unpaged(), grnNo);
        log.debug("Received Item List by GRN No: {}", purchaseOrderItemCompletedList);
        List<PurchaseOrderItemDto> resultList = new ArrayList<>(purchaseOrderItemDtoList);
        resultList.addAll(purchaseOrderItemCompletedList);

        return ResponseEntity.ok()
            .body(resultList);
    }

}
