package com.engseen.erp.controller.rest;

import java.util.Date;
import java.util.List;

import com.engseen.erp.service.PurchaseRequisitionRequestService;
import com.engseen.erp.service.dto.PurchaseRequisitionRequestDTO;

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
 * Rest Controller for managing {@link com.engseen.erp.domain.PurchaseRequisitionRequest}
 */
@RequestMapping("/api/purchase-requisition")
@RestController
public class PurchaseRequestSubmissionController {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequestSubmissionController.class);

    private final PurchaseRequisitionRequestService purchaseRequisitionRequestService;

    @Autowired
    public PurchaseRequestSubmissionController(PurchaseRequisitionRequestService purchaseRequisitionRequestService) {
        this.purchaseRequisitionRequestService = purchaseRequisitionRequestService;
    }

    /**
     * {@code GET /purchase-requisition/submission} : Get all Purchase Request Submission
     *
     * @param pageable  Pagination Info
     * @param startDate startDate to filter based on created date of Purchase Request Submission
     * @param endDate   endDate to filter based on created date of Purchase Request Submission
     */
    @GetMapping(value = "/submission")
    public ResponseEntity<List<PurchaseRequisitionRequestDTO>> getAllPurchaseRequestSubmission(Pageable pageable, @RequestParam(required = false, name = "startDate") Date startDate, @RequestParam(required = false, name = "endDate") Date endDate) {
        log.info("REST Request to getAllPurchaseRequestSubmission");
        log.debug("Pagination Info: {}", pageable);
        log.debug("Filter by Start Date: {}, End Date: {}", startDate, endDate);
        List<PurchaseRequisitionRequestDTO> purchaseRequisitionRequestDTOList = purchaseRequisitionRequestService.findAll(pageable);
        return ResponseEntity.ok()
                .body(purchaseRequisitionRequestDTOList);
    }

    /**
     * {@code POST /purchase-requisition/request} : Add Purchase Request Submission
     *
     * @param purchaseRequisitionRequestDto PurchaseRequestSubmissionDto Object to add
     */
    @PostMapping(value = "/request")
    public ResponseEntity<PurchaseRequisitionRequestDTO> addPurchaseRequestSubmission(@RequestBody PurchaseRequisitionRequestDTO purchaseRequisitionRequestDto) {
        log.info("REST Request to addPurchaseRequestSubmission: {}", purchaseRequisitionRequestDto);
        PurchaseRequisitionRequestDTO savedPurchaseRequisitionRequestDTO = purchaseRequisitionRequestService.create(purchaseRequisitionRequestDto);
        return ResponseEntity.ok()
                .body(savedPurchaseRequisitionRequestDTO);
    }

}