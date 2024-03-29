package com.engseen.erp.service.impl;

import java.util.Date;
import java.util.List;

import com.engseen.erp.constant.AppConstant;
import com.engseen.erp.domain.Inventory;
import com.engseen.erp.domain.PODetail;
import com.engseen.erp.repository.InventoryRepository;
import com.engseen.erp.service.InventoryService;
import com.engseen.erp.service.dto.POReceiptDTO;
import com.engseen.erp.service.dto.POReceiptHeaderDTO;
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
    public Inventory insertInventoryForPOReceipt(POReceiptDTO poReceiptDto, POReceiptHeaderDTO poReceiptHeaderDto, PODetail poDetail) {
        log.info("Request to insertInventoryForPOReceipt");
        Inventory inventory = constructInventory(poReceiptDto, poReceiptHeaderDto, poDetail);
        return insert(inventory);
    }

    private Inventory constructInventory(POReceiptDTO poReceiptDto, POReceiptHeaderDTO poReceiptHeader, PODetail poDetail) {
        Inventory inventory = new Inventory();
        inventory.setItem(poReceiptDto.getComponentCode());
        inventory.setStoreNo(AppConstant.DEFAULT_STORE_NO);
        inventory.setStoreBin(AppConstant.DEFAULT_STORE_BIN);
        inventory.setInventoryCode(AppConstant.INVENTORY_INVENTORY_CODE);
        inventory.setQuantity(poReceiptDto.getReceivingQuantity());
        inventory.setUnitCost(poReceiptDto.getUnitCost());
        inventory.setInspectionCode(AppConstant.INVENTORY_INSPECTION_CODE);
        inventory.setReceiptID(poReceiptDto.getPid());
        inventory.setReceiptDate(Date.from(poReceiptHeader.getGrnDate()));
        inventory.setVendorID(poReceiptHeader.getVendorID());
        inventory.setgRNNo(poReceiptHeader.getGrnNo());
        inventory.setReferenceNo(poReceiptHeader.getDoNumber());
        inventory.setReferenceNo2(poReceiptHeader.getInvoiceNumber());
        inventory.setOrderType(AppConstant.INVENTORY_ORDER_TYPE);
        inventory.setOrderNumber(poDetail.getPoNumber());
        inventory.setLineNumber(poDetail.getLineNumber());
        inventory.setCreated(new Date());
        inventory.setCreatedBy(AppConstant.DEFAULT_AUDIT_BY);
        return inventory;
    }

    @Override
    public Inventory insert(Inventory inventory) {
        log.debug("Request to insert Inventory: {}", inventory);
        inventoryRepository.insertInventory(inventory.getItem(), inventory.getStoreNo(), inventory.getStoreBin(), inventory.getInventoryCode(), inventory.getQuantity(), inventory.getUnitCost(), 
            inventory.getInspectionCode(), inventory.getReceiptID(), TimestampUtil.fromInstant(inventory.getReceiptDate().toInstant()), inventory.getVendorID(), inventory.getLotNo(), inventory.getgRNNo(), 
            inventory.getReferenceNo(), inventory.getReferenceNo2(), inventory.getOrderType(), inventory.getOrderNumber(), inventory.getLineNumber(), inventory.getFromID(), 
            inventory.getToOrderType(), inventory.getToOrderNumber(), inventory.getToLineNumber(), inventory.getWeight(), inventory.getSellingPrice(), inventory.getfUnitCost(), 
            inventory.getfCurrencyCode(), inventory.getfExchangeRate(), TimestampUtil.fromInstant(inventory.getCreated().toInstant()), inventory.getCreatedBy());
        List<Inventory> inventoryList = inventoryRepository.findByItemAndStoreNoAndStoreBinAndReceiptID(inventory.getItem(), inventory.getStoreNo(), inventory.getStoreBin(), inventory.getReceiptID());
        return inventoryList.get(inventoryList.size() - 1);
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
