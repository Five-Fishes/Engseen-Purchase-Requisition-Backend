package com.engseen.erp.service;

import java.util.Date;
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
     * Get all the PurchaseRequestSubmissions with date filter.
     *
     * @param pageable the pagination information
     * @param startDate start date of filter
     * @param endDate end date of filter
     * @return the list of entities
     */
    List<PurchaseRequisitionRequestDTO> findAll(Pageable pageable, Date startDate, Date endDate);

    /**
     * Create New Purchase Request Submission
     *
     * @param purchaseRequisitionRequestDto entity to be create
     * @return the entity created
     */
    PurchaseRequisitionRequestDTO create(PurchaseRequisitionRequestDTO purchaseRequisitionRequestDto);

}
