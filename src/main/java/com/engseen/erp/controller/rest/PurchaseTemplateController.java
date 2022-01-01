package com.engseen.erp.controller.rest;

import com.engseen.erp.service.PurchaseTemplateService;
import com.engseen.erp.service.dto.PurchaseTemplateDto;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Rest Controller for managing {@link com.engseen.erp.entity.PurchaseTemplate}
 */
@RequestMapping("/api/purchase-template")
@RestController
public class PurchaseTemplateController {

    private final Logger log = LoggerFactory.getLogger(PurchaseTemplateController.class);
  
    private PurchaseTemplateService purchaseTemplateService;

    @Autowired
    public PurchaseTemplateController(PurchaseTemplateService purchaseTemplateService) {
        this.purchaseTemplateService = purchaseTemplateService;
    }

    /**
     * {@code GET /purchase-template} : Get all Purchase Template
     * 
     * @param pageable Pagination Info
     */
    @GetMapping(value="")
    public ResponseEntity<List<PurchaseTemplateDto>> getAllPurchaseTemplate(Pageable pageable) {
        log.info("REST Request to getAllPurchaseTemplate");
        log.debug("Pagination Info: {}", pageable);
        List<PurchaseTemplateDto> purchaseTemplateDtoList = purchaseTemplateService.findAll(pageable);
        return ResponseEntity.ok()
            .body(purchaseTemplateDtoList);
    }

    /**
     * {@code POST /purchase-template} : Add Purchase Template
     * 
     * @param purchaseTemplateDto PurchaseTemplateDto Object to add
     */
    @PostMapping(value="")
    public ResponseEntity<PurchaseTemplateDto> addPurchaseTemplate(@RequestBody PurchaseTemplateDto purchaseTemplateDto) {
        log.info("REST Request to addPurchaseTemplate: {}", purchaseTemplateDto);
        PurchaseTemplateDto savedPurchaseTemplateDto = purchaseTemplateService.create(purchaseTemplateDto);
        return ResponseEntity.ok()
            .body(savedPurchaseTemplateDto);
    }

    /**
     * {@code PUT /purchase-template/{purchaseTemplateId}} : Update Purchase Template with Id
     * 
     * @param purchaseTemplateId Id of Purchase Template to be update
     * @param purchaseTemplateDto PurchaseTemplateDto Object to update
     */
    @PutMapping(value="/{purchaseTemplateId}")
    public ResponseEntity<PurchaseTemplateDto> updatePurchaseTemplate(@PathVariable Long purchaseTemplateId, @RequestBody PurchaseTemplateDto purchaseTemplateDto) {
        log.info("REST Request to updatePurchaseTemplate: {}", purchaseTemplateDto);
        log.debug("Purchase Template Id: {}", purchaseTemplateId);
        PurchaseTemplateDto savedPurchaseTemplateDto = purchaseTemplateService.update(purchaseTemplateId, purchaseTemplateDto);
        return ResponseEntity.ok()
            .body(savedPurchaseTemplateDto);
    }

    /**
     * {@code DELETE /purchase-template/{purchaseTemplateId}} : Delete Purchase Template with Id
     * 
     * @param purchaseTemplateId Id of Purchase Template to be delete
     */
    @DeleteMapping(value="/{purchaseTemplateId}")
    public ResponseEntity<Void> deletePurchaseTemplate(@PathVariable Long purchaseTemplateId) {
        log.info("REST Request to deletePurchaseTemplate with Id: {}", purchaseTemplateId);
        purchaseTemplateService.deleteByPurchaseTemplateId(purchaseTemplateId);
        return ResponseEntity.noContent()
            .build();
    }
  
}