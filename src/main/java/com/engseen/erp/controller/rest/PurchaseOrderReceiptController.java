package com.engseen.erp.controller.rest;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.engseen.erp.service.PurchaseOrderReceiptHeaderService;
import com.engseen.erp.service.dto.POReceiptHeaderDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for managing {@link com.engseen.erp.domain.PurchaseRequisitionApproval}
 */
@RequestMapping("/api/purchase-order-receipt")
@RestController
public class PurchaseOrderReceiptController {

    private final Logger log = LoggerFactory.getLogger(PurchaseOrderReceiptController.class);
    
    private final PurchaseOrderReceiptHeaderService purchaseOrderReceiptHeaderService;

    @Autowired
    public PurchaseOrderReceiptController(PurchaseOrderReceiptHeaderService purchaseOrderReceiptHeaderService) {
        this.purchaseOrderReceiptHeaderService = purchaseOrderReceiptHeaderService;
    }

    /**
     * {@code GET /purchase-order-receipt} : Get all Purchase Order Receipt
     *
     * @param pageable  Pagination Info
     * @param startDate startDate to filter based on created date of Purchase Order Receipt
     * @param endDate   endDate to filter based on created date of Purchase Order Receipt
     */
    @GetMapping(value = "")
    public ResponseEntity<List<POReceiptHeaderDTO>> getAllPurchaseOrderReceipt(Pageable pageable, @RequestParam(required = false, name = "startDate") Date startDate, @RequestParam(required = false, name = "endDate") Date endDate) {
        log.info("REST Request to getAllPurchaseOrderReceipt");
        log.debug("Pagination Info: {}", pageable);
        log.debug("Filter by Start Date: {}, End Date: {}", startDate, endDate);

        List<POReceiptHeaderDTO> poReceiptHeaderDtoList;

        if (Objects.nonNull(startDate) && Objects.nonNull(endDate)) {
            poReceiptHeaderDtoList = purchaseOrderReceiptHeaderService.findAll(pageable, startDate, endDate);
        } else {
            poReceiptHeaderDtoList = purchaseOrderReceiptHeaderService.findAll(pageable);
        }
        return ResponseEntity.ok()
            .body(poReceiptHeaderDtoList);
    }

    /**
     * {@code POST /purchase-order-receipt} : Add new PO Receipt Header, PO Receipt, Inventory Info
     * 
     * @param poReceiptHeaderDto PO Receipt Header DTO object to be add
     * @return
     */
    @PostMapping(value = "")
    public ResponseEntity<POReceiptHeaderDTO> addPurchaseOrderReceipt(@RequestBody POReceiptHeaderDTO poReceiptHeaderDto) {
        log.info("REST Request to addPurchaseOrderReceipt");
        log.debug("Request Body PO Receipt Header DTO: {}", poReceiptHeaderDto);
        // TODO: Insert for PO Receipt Header, PO Receipt and related Inventory
        return ResponseEntity.ok()
            .body(poReceiptHeaderDto);
    }

}
