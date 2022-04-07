package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.domain.Inventory;
import com.engseen.erp.domain.POReceipt;
import com.engseen.erp.domain.POReceiptHeader;
import com.engseen.erp.service.dto.POReceiptDTO;

import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.engseen.erp.domain.POReceipt}.
 */
public interface PurchaseOrderReceiptService {

	List<POReceiptDTO> findAllByGrnNo(Pageable pageable, String grnNo);

	POReceipt createPOReceipt(POReceiptDTO poReceiptDto, POReceiptHeader poReceiptHeader);

	POReceipt updatePOReceiptWithInventory(POReceipt poReceipt, Inventory inventory);
    
}
