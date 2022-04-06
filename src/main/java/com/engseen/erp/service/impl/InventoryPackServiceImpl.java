package com.engseen.erp.service.impl;

import java.math.BigDecimal;

import com.engseen.erp.constant.AppConstant;
import com.engseen.erp.domain.InventoryPack;
import com.engseen.erp.repository.InventoryPackRepository;
import com.engseen.erp.service.InventoryPackService;
import com.engseen.erp.service.dto.POReceiptDTO;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class InventoryPackServiceImpl implements InventoryPackService {
    
    private final InventoryPackRepository inventoryPackRepository;

    @Override
    public InventoryPack insert(InventoryPack inventoryPack) {
        log.info("Request to insert Inventory Pack");
        log.debug("Inventory Pack: {}", inventoryPack);
        inventoryPackRepository.insertInventoryPack(inventoryPack.getItem(), inventoryPack.getStoreNo(), inventoryPack.getStoreBin(), inventoryPack.getPack());
        return inventoryPackRepository.findOneByItemAndStoreNoAndStoreBin(inventoryPack.getItem(), inventoryPack.getStoreNo(), inventoryPack.getStoreBin());
    }

    @Override
    public InventoryPack update(InventoryPack inventoryPack) {
        log.info("Request to update Inventory Pack");
        log.debug("Inventory Pack: {}", inventoryPack);
        inventoryPackRepository.updateInventoryPack(inventoryPack.getId(), inventoryPack.getItem(), inventoryPack.getStoreNo(), inventoryPack.getStoreBin(), inventoryPack.getPack());
        return inventoryPackRepository.findById(inventoryPack.getId())
            .orElse(null);
    }

    @Override
    public InventoryPack findByItemAndStoreNoAndStoreBin(String item, String storeNo, String storeBin) {
        log.info("Request to find unique Inventory Pack based on item, storeNo, storeBin");
        log.debug("Item: {}, Store No: {}, Store Bin: {}", item, storeNo, storeBin);
        return inventoryPackRepository.findOneByItemAndStoreNoAndStoreBin(item, storeNo, storeBin);
    }

    @Override
    public InventoryPack updateInventoryPackForPOReceipt(POReceiptDTO poReceiptDto) {
        log.info("Request to find unique Inventory Pack based on item, storeNo, storeBin");
        log.debug("Item: {}", poReceiptDto.getComponentCode());
        InventoryPack inventoryPack = inventoryPackRepository.findOneByItemAndStoreNoAndStoreBin(poReceiptDto.getComponentCode(), AppConstant.DEFAULT_STORE_NO, AppConstant.DEFAULT_STORE_BIN);
        Integer totalPack = poReceiptDto.getReceivingQuantityPack().intValue();
        if (inventoryPack == null) {
            inventoryPack = new InventoryPack();
            inventoryPack.setItem(poReceiptDto.getComponentCode());
            inventoryPack.setStoreNo(AppConstant.DEFAULT_STORE_NO);
            inventoryPack.setStoreBin(AppConstant.DEFAULT_STORE_BIN);
            inventoryPack.setPack(totalPack);
            inventoryPack = insert(inventoryPack);
        } else {
            totalPack = Integer.sum(totalPack, inventoryPack.getPack());
            inventoryPack.setPack(totalPack);
            inventoryPack = update(inventoryPack);
        }
        return inventoryPack;
    }
}
