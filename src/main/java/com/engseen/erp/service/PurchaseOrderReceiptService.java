package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.POReceiptDTO;

import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.engseen.erp.domain.POReceipt}.
 */
public interface PurchaseOrderReceiptService {

	List<POReceiptDTO> findAllByGrnNo(Pageable pageable, String grnNo);
    
}
