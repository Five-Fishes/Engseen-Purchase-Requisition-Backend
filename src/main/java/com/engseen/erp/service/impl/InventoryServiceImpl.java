package com.engseen.erp.service.impl;

import com.engseen.erp.domain.Inventory;
import com.engseen.erp.repository.InventoryRepository;
import com.engseen.erp.service.InventoryService;
import com.engseen.erp.util.TimestampUtil;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Inventory insert(Inventory inventory) {
        log.debug("Request to insert Inventory: {}", inventory);
        inventoryRepository.insertInventory(inventory.getItem(), inventory.getStoreNo(), inventory.getStoreBin(), inventory.getInventoryCode(), inventory.getQuantity(), inventory.getUnitCost(), 
            inventory.getInspectionCode(), inventory.getReceiptID(), TimestampUtil.fromInstant(inventory.getReceiptDate().toInstant()), inventory.getVendorID(), inventory.getLotNo(), inventory.getgRNNo(), 
            inventory.getReferenceNo(), inventory.getReferenceNo2(), inventory.getOrderType(), inventory.getOrderNumber(), inventory.getLineNumber(), inventory.getFromID(), 
            inventory.getToOrderType(), inventory.getToOrderNumber(), inventory.getToLineNumber(), inventory.getWeight(), inventory.getSellingPrice(), inventory.getfUnitCost(), 
            inventory.getfCurrencyCode(), inventory.getfExchangeRate(), TimestampUtil.fromInstant(inventory.getCreated().toInstant()), inventory.getCreatedBy());
        return inventoryRepository.findOneByItemAndStoreNoAndStoreBin(inventory.getItem(), inventory.getStoreNo(), inventory.getStoreBin());
    }

    @Override
    public Inventory update(Inventory inventory) {
        log.debug("Request to update Inventory: {}", inventory);
        inventoryRepository.updateInventory(inventory.getId(),
            inventory.getItem(), inventory.getStoreNo(), inventory.getStoreBin(), inventory.getInventoryCode(), inventory.getQuantity(), inventory.getUnitCost(), 
            inventory.getInspectionCode(), inventory.getReceiptID(), TimestampUtil.fromInstant(inventory.getReceiptDate().toInstant()), inventory.getVendorID(), inventory.getLotNo(), inventory.getgRNNo(), 
            inventory.getReferenceNo(), inventory.getReferenceNo2(), inventory.getOrderType(), inventory.getOrderNumber(), inventory.getLineNumber(), inventory.getFromID(), 
            inventory.getToOrderType(), inventory.getToOrderNumber(), inventory.getToLineNumber(), inventory.getWeight(), inventory.getSellingPrice(), inventory.getfUnitCost(), 
            inventory.getfCurrencyCode(), inventory.getfExchangeRate(), TimestampUtil.fromInstant(inventory.getCreated().toInstant()), inventory.getCreatedBy());
        return inventoryRepository.findById(inventory.getId()).orElse(new Inventory());
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete Inventory with ID: {}", id);
        inventoryRepository.deleteInventory(id);
    }
    
}
