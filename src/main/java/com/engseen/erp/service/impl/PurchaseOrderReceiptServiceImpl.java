package com.engseen.erp.service.impl;

import java.time.Instant;
import java.util.List;

import com.engseen.erp.constant.AppConstant;
import com.engseen.erp.domain.Inventory;
import com.engseen.erp.domain.POReceipt;
import com.engseen.erp.domain.POReceiptHeader;
import com.engseen.erp.repository.POReceiptRepository;
import com.engseen.erp.service.POReceiptService;
import com.engseen.erp.service.PurchaseOrderReceiptService;
import com.engseen.erp.service.dto.POReceiptDTO;
import com.engseen.erp.service.mapper.POReceiptMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.POReceipt}.
 */
@Service
@RequiredArgsConstructor
public class PurchaseOrderReceiptServiceImpl implements PurchaseOrderReceiptService {
    
    private final Logger log = LoggerFactory.getLogger(PurchaseOrderReceiptServiceImpl.class);

    private final POReceiptRepository poReceiptRepository;
    private final POReceiptMapper poReceiptMapper;

    private final POReceiptService poReceiptService;

    @Override
    public List<POReceiptDTO> findAllByGrnNo(Pageable pageable, String grnNo) {
        log.debug("Request to findAll Purchase Order Receipt by GRNNo: {}", grnNo);
        return poReceiptRepository.findAllByGrnNo(pageable, grnNo)
            .map(poReceiptMapper::toDto)
            .toList();
    }

    @Override
    public POReceipt createPOReceipt(POReceiptDTO poReceiptDto, POReceiptHeader poReceiptHeader) {
        log.info("Request to createPOReceipt");
        log.debug("PO Receipt DTO: {}", poReceiptDto);
        log.debug("PO Receipt Header: {}", poReceiptHeader);
        POReceipt poReceipt = constructPOReceipt(poReceiptDto, poReceiptHeader);
        return poReceiptService.insert(poReceipt);
    }

    private POReceipt constructPOReceipt(POReceiptDTO poReceiptDto, POReceiptHeader poReceiptHeader) {
        log.debug("Perform constructPOReceipt");
        POReceipt poReceipt = new POReceipt();
        poReceipt.setGrnNo(poReceiptHeader.getGrnNo());
        poReceipt.setPid(poReceiptDto.getPid());
        poReceipt.setQuantityReceived(poReceiptDto.getReceivingQuantity());
        poReceipt.setQuantityReversed(poReceiptDto.getQuantityReversed());
        poReceipt.setUnitCost(poReceiptDto.getUnitCost());
        poReceipt.setOrigUnitCost(poReceiptDto.getOrigUnitCost());
        poReceipt.setCreated(Instant.now());
        poReceipt.setCreatedBy(AppConstant.DEFAULT_AUDIT_BY);
        poReceipt.setPackReceived(poReceiptDto.getReceivingQuantityPack().intValue());
        poReceipt.setPackReversed(poReceiptDto.getPackReversed());
        return poReceipt;
    }

    @Override
    public POReceipt updatePOReceiptWithInventory(POReceipt poReceipt, Inventory inventory) {
        log.info("Request to updatePOReceiptWithInventory");
        log.debug("PO Receipt: {}", poReceipt);
        log.debug("Inventory: {}", inventory);
        poReceipt.setInspectionCode(inventory.getInspectionCode());
        poReceipt.setIid(inventory.getId());
        poReceipt.setStoreNo(inventory.getStoreNo());
        poReceipt.setStoreBin(inventory.getStoreBin());
        poReceipt.setInventoryCode(inventory.getInventoryCode());
        return poReceiptService.update(poReceipt);
    }
}
