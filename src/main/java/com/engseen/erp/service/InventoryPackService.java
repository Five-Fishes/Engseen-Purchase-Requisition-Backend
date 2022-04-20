package com.engseen.erp.service;

import com.engseen.erp.domain.InventoryPack;
import com.engseen.erp.service.dto.POReceiptDTO;

public interface InventoryPackService {
    
    InventoryPack insert(InventoryPack inventoryPack);

    InventoryPack update(InventoryPack inventoryPack);

    InventoryPack findByItemAndStoreNoAndStoreBin(String item, String storeNo, String storeBin);

	InventoryPack updateInventoryPackForPOReceipt(POReceiptDTO poReceiptDto);
}
