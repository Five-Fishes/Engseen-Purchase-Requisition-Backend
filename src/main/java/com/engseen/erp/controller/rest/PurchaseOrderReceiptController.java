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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{grnNo}")
    public ResponseEntity<POReceiptHeaderDTO> getPurchaseOrderReceiptHeaderByGrnNo(@PathVariable String grnNo) {
        log.info("REST Request to getPurchaseOrderReceiptHeaderByGrnNo");
        log.debug("grnNo: {}", grnNo);

        return ResponseEntity.ok()
                .body(purchaseOrderReceiptHeaderService.findOneByGrnNo(grnNo));
    }

    /**
     * {@code POST /purchase-order-receipt/search} : Search Purchase Order Receipt
     *
     * @param pageable  Pagination Info
     * @param poReceiptHeaderDto search criteria for po receipt header records
     */
    @PostMapping(value = "/search")
    public ResponseEntity<List<POReceiptHeaderDTO>> searchPurchaseOrderReceiptHeader(Pageable pageable, @RequestBody POReceiptHeaderDTO poReceiptHeaderDto) {
        log.info("REST Request to getAllPurchaseOrderReceipt");
        log.debug("Pagination Info: {}", pageable);
        log.debug("Filter Criteria: {}", poReceiptHeaderDto);

        List<POReceiptHeaderDTO> poReceiptHeaderDtoList = purchaseOrderReceiptHeaderService.search(poReceiptHeaderDto, pageable);

        return ResponseEntity.ok()
            .body(poReceiptHeaderDtoList);
    }

    /**
     * {@code POST /purchase-order-receipt} : Add records for receiving of Purchase Order Items
     * <p>Update PO Detail: increase “QuantityReceived”, “QuantityOnHand”, “PackReceived”, update “DateLastReceipt” with GRNDate</p>
     * <p>Insert Inventory" for each PO receipt</p>
     * <p>Insert Inventory Pack: only 1 record per item per location, increase “Pack” if record already exists</p>
     * <p>Insert InventoryHistory: only 1 record per item per month, increase “QuantityReceived”,”CostReceived” if record already exists</p>
     * <p>Insert PO Receipt: for each Item</p>
     * 
     * <p>If Unit Price changed::</p>
     * <p>Update ItemMaster: VariableOverheadCost = new price, TotalCost = new price, RolledVariableOverheadCost = new price, TotalRolledCost = new price, Modified, ModifiedBy</p>
     * <p>Insert HistoryItemMaster: UserAction = “E”, Item = Item Code, VariableOverheadCost = new price, TotalCost = new price, Modified, ModifiedBy</p>
     * <p>Insert ItemCostBook: with “Updated” set to “N”
     * 
     * @param poReceiptHeaderDto PO Receipt Header DTO object to be add
     * @return
     */
    @PostMapping(value = "")
    public ResponseEntity<POReceiptHeaderDTO> addPurchaseOrderReceipt(@RequestBody POReceiptHeaderDTO poReceiptHeaderDto) {
        log.info("REST Request to addPurchaseOrderReceipt");
        log.debug("Request Body PO Receipt Header DTO: {}", poReceiptHeaderDto);
        // TODO: Insert for PO Receipt Header, PO Receipt and related Inventory
        POReceiptHeaderDTO poReceiptHeaderDTOcreated = purchaseOrderReceiptHeaderService.createNewPOReceipt(poReceiptHeaderDto);
        return ResponseEntity.ok()
            .body(poReceiptHeaderDTOcreated);
    }

}
