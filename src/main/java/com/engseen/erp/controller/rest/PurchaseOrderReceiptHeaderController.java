package com.engseen.erp.controller.rest;

import com.engseen.erp.service.PurchaseOrderReceiptHeaderService;
import com.engseen.erp.service.dto.POReceiptHeaderDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for managing {@link com.engseen.erp.domain.PurchaseOrderReceiptHeader}
 */
@RequestMapping("/api/purchase-order-receipt-header")
@RestController
public class PurchaseOrderReceiptHeaderController {
    
    private final Logger log = LoggerFactory.getLogger(PurchaseOrderReceiptHeaderController.class);

    private PurchaseOrderReceiptHeaderService purchaseOrderReceiptHeaderService;

    public PurchaseOrderReceiptHeaderController(PurchaseOrderReceiptHeaderService purchaseOrderReceiptHeaderService) {
        this.purchaseOrderReceiptHeaderService = purchaseOrderReceiptHeaderService;
    }

    /**
     * {@code POST /purchase-order-receipt-header/{vendorId}} : Create new PO Receipt Header
     * 
     * @param vendorId
     * @return PO Receipt Header DTO
     */
    @PostMapping("/{vendorId}")
    public ResponseEntity<POReceiptHeaderDTO> createPurchaseOrderReceiptHeader(@PathVariable String vendorId) {
        log.info("REST Request to addPurchaseOrderReceipt");
        log.debug("Vendor Id: {}", vendorId);
        POReceiptHeaderDTO poReceiptHeaderDto = purchaseOrderReceiptHeaderService.createPOReceiptHeaderByVendorId(vendorId);
        return ResponseEntity.ok()
            .body(poReceiptHeaderDto);
    }

}