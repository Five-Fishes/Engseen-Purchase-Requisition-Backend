package com.engseen.erp.service;

import com.engseen.erp.domain.Inventory;
import com.engseen.erp.domain.PODetail;
import com.engseen.erp.service.dto.POReceiptDTO;
import com.engseen.erp.service.dto.POReceiptHeaderDTO;

public interface InventoryService {

    /**
     * Insert Inventory for each po receipt
     * @param poReceiptDto
     * @param poReceiptHeader
     * @param poDetail
     * @return inventory inserted
     */
    Inventory insertInventoryForPOReceipt(POReceiptDTO poReceiptDto, POReceiptHeaderDTO poReceiptHeaderDto, PODetail poDetail);
 
    /**
     * Create new Inventory
     * @param Inventory Inventory to be inserted
     * @return new Inventory
     */
    Inventory insert(Inventory inventory);

    /**
     * Update new Inventory
     * @param Inventory Inventory to be updated
     * @return updated Inventory
     */
    Inventory update(Inventory inventory);

    /**
     * Delete Inventory
     * @param id ID of Inventory to be delete
     */
    void delete(Integer id);
}
