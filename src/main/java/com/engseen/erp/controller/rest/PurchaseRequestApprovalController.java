package com.engseen.erp.controller.rest;

import java.util.Date;
import java.util.List;

import com.engseen.erp.service.PurchaseRequestApprovalItemService;
import com.engseen.erp.service.PurchaseRequestApprovalService;
import com.engseen.erp.service.dto.PurchaseRequestApprovalDto;
import com.engseen.erp.service.dto.PurchaseRequestApprovalItemDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for managing {@link com.engseen.erp.entity.PurchaseRequestApporval}
 */
@RequestMapping("/api/purchase-requisition/approval")
@RestController
public class PurchaseRequestApprovalController {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequestApprovalController.class);

    private PurchaseRequestApprovalService purchaseRequestApprovalService;
    private PurchaseRequestApprovalItemService purchaseRequestApprovalItemService;

    @Autowired
    public PurchaseRequestApprovalController(PurchaseRequestApprovalService purchaseRequestApprovalService, PurchaseRequestApprovalItemService purchaseRequestApprovalItemService) {
        this.purchaseRequestApprovalService = purchaseRequestApprovalService;
        this.purchaseRequestApprovalItemService = purchaseRequestApprovalItemService;
    }

    /**
     * {@code GET /purchase-requisition/approval} : Get all Purchase Request Approval
     * 
     * @param pageable Pagination Info
     * @param startDate startDate to filter based on created date of Purchase Request Approval
     * @param endDate endDate to filter based on created date of Purchase Request Approval
     */
    @GetMapping(value="")
    public ResponseEntity<List<PurchaseRequestApprovalDto>> getAllPurchaseRequestApproval(Pageable pageable, @RequestParam(required = false, name = "startDate") Date startDate, @RequestParam(required = false, name = "endDate") Date endDate) {
        log.info("REST Request to getAllPurchaseRequestApproval");
        log.debug("Pagination Info: {}", pageable);
        log.debug("Filter by Start Date: {}, End Date: {}", startDate, endDate);
        List<PurchaseRequestApprovalDto> purchaseRequestApprovalDtoList = purchaseRequestApprovalService.findAll(pageable);
        return ResponseEntity.ok()
            .body(purchaseRequestApprovalDtoList);
    }

    /**
     * {@code PUT /purchase-requisition/approval/{purchaseRequestApprovalId}} : Update Purchase Request Approval
     * 
     * @param purchaseRequestApprovalId Id of Purchase Request Approval to update
     * @param purchaseRequestApprovalDto PurchaseRequestApprovalDto Object to add
     */
    @PutMapping(value="/{purchaseRequestApprovalId}")
    public ResponseEntity<PurchaseRequestApprovalDto> updatePurchaseRequestApproval(@PathVariable Long purchaseRequestApprovalId, @RequestBody PurchaseRequestApprovalDto purchaseRequestApprovalDto) {
        log.info("REST Request to updatePurchaseRequestApproval: {} with Id: {}", purchaseRequestApprovalDto, purchaseRequestApprovalId);
        PurchaseRequestApprovalDto savedPurchaseRequestApprovalDto = purchaseRequestApprovalService.update(purchaseRequestApprovalId, purchaseRequestApprovalDto);
        return ResponseEntity.ok()
            .body(savedPurchaseRequestApprovalDto);
    }


    /**
     * {@code POST /purchase-requisition/approval/item/{purchaseRequestApprovalId}} : Add Purchase Request Approval Item to Purchase Request Approval
     * 
     * @param purchaseRequestApprovalId Id of Purchase Request Approval for item to be add
     * @param purchaseRequestApprovalItemDto PurchaseRequestApprovalItemDto Object to add
     */
    @PostMapping(value="/item/{purchaseRequestApprovalId}")
    public ResponseEntity<PurchaseRequestApprovalItemDto> addPurchaseRequestApprovalItem(@PathVariable Long purchaseRequestApprovalId, @RequestBody PurchaseRequestApprovalItemDto purchaseRequestApprovalItemDto) {
        log.info("REST Request to addPurchaseRequestApprovalItem: {} to Request Id: {}", purchaseRequestApprovalItemDto, purchaseRequestApprovalId);
        purchaseRequestApprovalItemDto.setRequestApprovalId(purchaseRequestApprovalId);
        PurchaseRequestApprovalItemDto savedPurchaseRequestApprovalItemDto = purchaseRequestApprovalItemService.add(purchaseRequestApprovalItemDto);
        return ResponseEntity.ok()
            .body(savedPurchaseRequestApprovalItemDto);
    }

    /**
     * {@code PUT /purchase-requisition/approval/item/{purchaseRequestApprovalItemId}} : Update Purchase Request Approval Item
     * 
     * @param purchaseRequestApprovalItemId Id of Purchase Request Approval Item to be update
     * @param purchaseRequestApprovalItemDto PurchaseRequestApprovalItemDto Object to add
     */
    @PutMapping(value="/item/{purchaseRequestApprovalItemId}")
    public ResponseEntity<PurchaseRequestApprovalItemDto> updatePurchaseRequestApprovalItem(@PathVariable Long purchaseRequestApprovalItemId, @RequestBody PurchaseRequestApprovalItemDto purchaseRequestApprovalItemDto) {
        log.info("REST Request to updatePurchaseRequestApprovalItem: {} with Id: {}", purchaseRequestApprovalItemDto, purchaseRequestApprovalItemId);
        PurchaseRequestApprovalItemDto savedPurchaseRequestApprovalItemDto = purchaseRequestApprovalItemService.update(purchaseRequestApprovalItemId, purchaseRequestApprovalItemDto);
        return ResponseEntity.ok()
            .body(savedPurchaseRequestApprovalItemDto);
    }
    
    /**
     * {@code PATCH /purchase-requisition/approval/{purchaseRequestApprovalItemId}} : Patch Purchase Request Approval on item cost
     * 
     * @param purchaseRequestApprovalItemDto PurchaseRequestApprovalDto Object to add
     */
    @PatchMapping(value="/item/{purchaseRequestApprovalItemId}")
    public ResponseEntity<PurchaseRequestApprovalItemDto> patchPurchaseRequestApprovalItemCost(@PathVariable Long purchaseRequestApprovalItemId, @RequestBody PurchaseRequestApprovalItemDto purchaseRequestApprovalItemDto) {
        log.info("REST Request to patch PurchaseRequestApprovalItem with Id: {} to cost: {}", purchaseRequestApprovalItemId, purchaseRequestApprovalItemDto.getItemCost());
        PurchaseRequestApprovalItemDto savedPurchaseRequestApprovalItemDto = purchaseRequestApprovalItemService.update(purchaseRequestApprovalItemId, purchaseRequestApprovalItemDto);
        return ResponseEntity.ok()
            .body(savedPurchaseRequestApprovalItemDto);
    }

    /**
     * {@code DELETE /purchase-requisition/approval/item/{purchaseRequestApprovalItemId}} : Update Purchase Request Approval Item
     * 
     * @param purchaseRequestApprovalItemId Id of Purchase Request Approval Item to be update
     * @param purchaseRequestApprovalItemDto PurchaseRequestApprovalItemDto Object to add
     */
    @DeleteMapping(value="/item/{purchaseRequestApprovalItemId}")
    public ResponseEntity<Void> deletePurchaseRequestApprovalItem(@PathVariable Long purchaseRequestApprovalItemId) {
        log.info("REST Request to deletePurchaseRequestApprovalItem with Id: {}", purchaseRequestApprovalItemId);
        purchaseRequestApprovalItemService.delete(purchaseRequestApprovalItemId);
        return ResponseEntity.noContent()
            .build();
    }

}
