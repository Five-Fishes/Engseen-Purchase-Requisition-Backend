package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseRequestSubmissionDto;

import org.springframework.data.domain.Pageable;

public interface PurchaseRequestSubmissionService {

    /**
     * Get all the PurchaseRequestSubmissions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    List<PurchaseRequestSubmissionDto> findAll(Pageable pageable);

    /**
     * Create New Purchase Request Submission
     *
     * @param purchaseRequestSubmissionDto entity to be create
     * @return the entity created
     */
	PurchaseRequestSubmissionDto create(PurchaseRequestSubmissionDto purchaseRequestSubmissionDto);

}
