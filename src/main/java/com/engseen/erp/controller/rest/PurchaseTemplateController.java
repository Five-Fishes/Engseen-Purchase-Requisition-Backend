package com.engseen.erp.controller.rest;

import com.engseen.erp.service.PurchaseRequisitionTemplateService;
import com.engseen.erp.service.dto.PurchaseRequisitionTemplateDTO;

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
 * Rest Controller for managing {@link com.engseen.erp.domain.PurchaseRequisitionTemplate}
 */
@RequestMapping("/api/purchase-template")
@RestController
public class PurchaseTemplateController {

    private final Logger log = LoggerFactory.getLogger(PurchaseTemplateController.class);
  
    private final PurchaseRequisitionTemplateService purchaseTemplateService;

    @Autowired
    public PurchaseTemplateController(PurchaseRequisitionTemplateService purchaseTemplateService) {
        this.purchaseTemplateService = purchaseTemplateService;
    }

    /**
     * {@code GET /purchase-template} : Get all Purchase Template
     *
     * @param pageable Pagination Info
     */
    @GetMapping(value="")
    public ResponseEntity<List<PurchaseRequisitionTemplateDTO>> getAllPurchaseTemplate(Pageable pageable) {
        log.info("REST Request to getAllPurchaseTemplate");
        log.debug("Pagination Info: {}", pageable);
        List<PurchaseRequisitionTemplateDTO> purchaseRequisitionTemplateDTOList = purchaseTemplateService.findAll(pageable);
        return ResponseEntity.ok()
                .body(purchaseRequisitionTemplateDTOList);
    }

    /**
     * {@code GET /purchase-template/{purchaseRequisitionTemplateId}} : Get Purchase Template by Id
     * 
     * @param purchaseRequisitionTemplateId Id of {@link com.engseen.erp.domain.PurchaseRequisitionTemplate}
     */
    @GetMapping(value="/{purchaseRequisitionTemplateId}")
    public ResponseEntity<PurchaseRequisitionTemplateDTO> getAllPurchaseTemplate(@PathVariable long purchaseRequisitionTemplateId) {
        log.info("REST Request to getPurchaseTemplateById");
        log.debug("PurchaseTemplate Id: {}", purchaseRequisitionTemplateId);
        PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO = purchaseTemplateService.findById(purchaseRequisitionTemplateId);
        return ResponseEntity.ok()
            .body(purchaseRequisitionTemplateDTO);
    }

    /**
     * {@code POST /purchase-template} : Add Purchase Template
     * 
     * @param purchaseRequisitionTemplateDTO PurchaseTemplateDto Object to add
     */
    @PostMapping(value="")
    public ResponseEntity<PurchaseRequisitionTemplateDTO> addPurchaseTemplate(@RequestBody PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO) {
        log.info("REST Request to addPurchaseTemplate: {}", purchaseRequisitionTemplateDTO);
        PurchaseRequisitionTemplateDTO savedPurchaseRequisitionTemplateDTO = purchaseTemplateService.create(purchaseRequisitionTemplateDTO);
        return ResponseEntity.ok()
            .body(savedPurchaseRequisitionTemplateDTO);
    }

    /**
     * {@code PUT /purchase-template/{purchaseTemplateId}} : Update Purchase Template with Id
     * 
     * @param purchaseTemplateId Id of Purchase Template to be update
     * @param purchaseRequisitionTemplateDTO PurchaseTemplateDto Object to update
     */
    @PutMapping(value="/{purchaseTemplateId}")
    public ResponseEntity<PurchaseRequisitionTemplateDTO> updatePurchaseTemplate(@PathVariable Long purchaseTemplateId, @RequestBody PurchaseRequisitionTemplateDTO purchaseRequisitionTemplateDTO) {
        log.info("REST Request to updatePurchaseTemplate: {}", purchaseRequisitionTemplateDTO);
        log.debug("Purchase Template Id: {}", purchaseTemplateId);
        PurchaseRequisitionTemplateDTO savedPurchaseRequisitionTemplateDTO = purchaseTemplateService.update(purchaseTemplateId, purchaseRequisitionTemplateDTO);
        return ResponseEntity.ok()
            .body(savedPurchaseRequisitionTemplateDTO);
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