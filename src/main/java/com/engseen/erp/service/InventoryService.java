package com.engseen.erp.service;

import com.engseen.erp.domain.Inventory;

public interface InventoryService {
 
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
