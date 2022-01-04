package com.engseen.erp.controller.rest;

import java.util.Date;
import java.util.List;

import com.engseen.erp.service.PurchaseRequestSubmissionService;
import com.engseen.erp.service.dto.PurchaseRequestSubmissionDto;

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
 * Rest Controller for managing {@link com.engseen.erp.entity.PurchaseRequestSubmission}
 */
@RequestMapping("/api/purchase-requisition")
@RestController
public class PurchaseRequestSubmissionController {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequestSubmissionController.class);
  
    private PurchaseRequestSubmissionService purchaseRequestSubmissionService;

    @Autowired
    public PurchaseRequestSubmissionController(PurchaseRequestSubmissionService purchaseRequestSubmissionService) {
        this.purchaseRequestSubmissionService = purchaseRequestSubmissionService;
    }

    /**
     * {@code GET /purchase-requisition/submission} : Get all Purchase Request Submission
     * 
     * @param pageable Pagination Info
     * @param startDate startDate to filter based on created date of Purchase Request Submission
     * @param endDate endDate to filter based on created date of Purchase Request Submission
     */
    @GetMapping(value="/submission")
    public ResponseEntity<List<PurchaseRequestSubmissionDto>> getAllPurchaseRequestSubmission(Pageable pageable, @RequestParam(required = false, name = "startDate") Date startDate, @RequestParam(required = false, name = "endDate") Date endDate) {
        log.info("REST Request to getAllPurchaseRequestSubmission");
        log.debug("Pagination Info: {}", pageable);
        log.debug("Filter by Start Date: {}, End Date: {}", startDate, endDate);
        List<PurchaseRequestSubmissionDto> purchaseRequestSubmissionDtoList = purchaseRequestSubmissionService.findAll(pageable);
        return ResponseEntity.ok()
            .body(purchaseRequestSubmissionDtoList);
    }

    /**
     * {@code POST /purchase-requisition/request} : Add Purchase Request Submission
     * 
     * @param purchaseRequestSubmissionDto PurchaseRequestSubmissionDto Object to add
     */
    @PostMapping(value="/request")
    public ResponseEntity<PurchaseRequestSubmissionDto> addPurchaseRequestSubmission(@RequestBody PurchaseRequestSubmissionDto purchaseRequestSubmissionDto) {
        log.info("REST Request to addPurchaseRequestSubmission: {}", purchaseRequestSubmissionDto);
        // TODO: have to insert on Submission and Approval Table
        PurchaseRequestSubmissionDto savedPurchaseRequestSubmissionDto = purchaseRequestSubmissionService.create(purchaseRequestSubmissionDto);
        return ResponseEntity.ok()
            .body(savedPurchaseRequestSubmissionDto);
    }

}