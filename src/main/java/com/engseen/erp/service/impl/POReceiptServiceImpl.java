package com.engseen.erp.service.impl;

import com.engseen.erp.domain.POReceipt;
import com.engseen.erp.repository.POReceiptRepository;
import com.engseen.erp.service.POReceiptService;
import com.engseen.erp.util.TimestampUtil;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class POReceiptServiceImpl implements POReceiptService {

    private final POReceiptRepository poReceiptRepository;

    @Override
    public POReceipt insert(POReceipt poReceipt) {
        log.debug("Request to insert POReceipt: {}", poReceipt);
        poReceiptRepository.insertPOReceipt(poReceipt.getGrnNo(), poReceipt.getPid(), poReceipt.getQuantityReceived(), poReceipt.getQuantityReversed(), poReceipt.getUnitCost(), poReceipt.getOrigUnitCost(), 
            poReceipt.getInspectionCode(), poReceipt.getIid(), poReceipt.getStoreNo(), poReceipt.getStoreBin(), poReceipt.getInventoryCode(), poReceipt.getLotNo(), 
            poReceipt.getIrid(), TimestampUtil.fromInstant(poReceipt.getCreated()), poReceipt.getCreatedBy(), poReceipt.getPackReceived(), poReceipt.getPackReversed());
        return poReceiptRepository.findOneByGrnNoAndPidAndIid(poReceipt.getGrnNo(), poReceipt.getPid(), poReceipt.getIid());
    }

    @Override
    public POReceipt update(POReceipt poReceipt) {
        log.debug("Request to update POReceipt: {}", poReceipt);
        poReceiptRepository.updatePOReceipt(poReceipt.getId(), 
            poReceipt.getGrnNo(), poReceipt.getPid(), poReceipt.getQuantityReceived(), poReceipt.getQuantityReversed(), poReceipt.getUnitCost(), poReceipt.getOrigUnitCost(), 
            poReceipt.getInspectionCode(), poReceipt.getIid(), poReceipt.getStoreNo(), poReceipt.getStoreBin(), poReceipt.getInventoryCode(), poReceipt.getLotNo(), 
            poReceipt.getIrid(), TimestampUtil.fromInstant(poReceipt.getCreated()), poReceipt.getCreatedBy(), poReceipt.getPackReceived(), poReceipt.getPackReversed());
        return poReceiptRepository.findOneByGrnNoAndPidAndIid(poReceipt.getGrnNo(), poReceipt.getPid(), poReceipt.getIid());
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete POReceipt with ID: {}", id);
        poReceiptRepository.deletePOReceipt(id);
    }
    
}
