package com.engseen.erp.service;

import java.util.Date;
import java.util.List;

import com.engseen.erp.service.dto.POReceiptHeaderDTO;

import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.engseen.erp.domain.POReceiptHeader}.
 */
public interface PurchaseOrderReceiptHeaderService {

    POReceiptHeaderDTO findOneByGrnNo(String grnNo);

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

    /**
     * Creation of New PO Receipt with Inventory Insertion
     * 
     * @param poReceiptHeaderDto to be create
     * @return PO Receipt Header created
     */
    POReceiptHeaderDTO createNewPOReceipt(POReceiptHeaderDTO poReceiptHeaderDto);

    /**
     * Creation of New PO Receipt by VendorId
     * 
     * @param vendorId to create for new PO Receipt Header
     * @return PO Receipt Header created
     */
	POReceiptHeaderDTO createPOReceiptHeaderByVendorId(String vendorId);

    /**
     * Search PO Receipt Header based on criteria
     * 
     * @param poReceiptHeaderDto search criteria
     * @return PO Receipt Header List
     */
	List<POReceiptHeaderDTO> search(POReceiptHeaderDTO poReceiptHeaderDto, Pageable pageable);
    
}
