package com.engseen.erp.service;

import java.util.Date;
import java.util.List;

import com.engseen.erp.service.dto.POReceiptHeaderDTO;

import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.engseen.erp.domain.POReceiptHeader}.
 */
public interface PurchaseOrderReceiptHeaderService {

    /**
     * Get all the POReceiptHeader
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    List<POReceiptHeaderDTO> findAll(Pageable pageable);

    /**
     * Get all the POReceiptHeader with date filter
     *
     * @param pageable the pagination information.
     * @param startDate start date of filter
     * @param endDate end date of filter
     * @return the list of entities.
     */
    List<POReceiptHeaderDTO> findAll(Pageable pageable, Date startDate, Date endDate);
    
}
