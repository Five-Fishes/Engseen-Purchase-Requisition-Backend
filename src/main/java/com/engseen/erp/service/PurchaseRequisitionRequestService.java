package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseRequisitionRequestDTO;

import org.springframework.data.domain.Pageable;

public interface PurchaseRequisitionRequestService {

    /**
     * Get all the PurchaseRequestSubmissions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    List<PurchaseRequisitionRequestDTO> findAll(Pageable pageable);

    /**
     * Create New Purchase Request Submission
     *
     * @param purchaseRequisitionRequestDto entity to be create
     * @return the entity created
     */
    PurchaseRequisitionRequestDTO create(PurchaseRequisitionRequestDTO purchaseRequisitionRequestDto);

}
