package com.engseen.erp.service.impl;

import java.sql.Timestamp;

import com.engseen.erp.domain.POReceiptHeader;
import com.engseen.erp.repository.POReceiptHeaderRepository;
import com.engseen.erp.service.POReceiptHeaderService;
import com.engseen.erp.util.TimestampUtil;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class POReceiptHeaderServiceImpl implements POReceiptHeaderService {

    private final POReceiptHeaderRepository poReceiptHeaderRepository;

    @Override
    public POReceiptHeader findOneByGrnNo(String grnNo) {
        return poReceiptHeaderRepository.findOneByGrnNo(grnNo);
    }

    @Override
    public POReceiptHeader insert(POReceiptHeader poReceiptHeader) {
        log.debug("Request to insert POReceiptHeader: {}", poReceiptHeader);
        poReceiptHeaderRepository.insertPOReceiptHeader(poReceiptHeader.getGrnNo(), TimestampUtil.fromInstant(poReceiptHeader.getGrnDate()), poReceiptHeader.getStatus(), poReceiptHeader.getVendorID(), poReceiptHeader.getExchangeRate(), poReceiptHeader.getTransportVia(), 
            poReceiptHeader.getFreightBillNumber(), poReceiptHeader.getPackingListNumber(), poReceiptHeader.getGrnReference(), poReceiptHeader.getDiscountAmount(), poReceiptHeader.getRemark(), poReceiptHeader.getGrnType(), 
            poReceiptHeader.getInvoiceAmount(), poReceiptHeader.getHold(), poReceiptHeader.getPaid(), poReceiptHeader.getPosted(), TimestampUtil.fromInstant(poReceiptHeader.getCreated()), poReceiptHeader.getCreatedBy(), 
            TimestampUtil.fromInstant(poReceiptHeader.getModified()), poReceiptHeader.getModifiedBy(), TimestampUtil.fromInstant(poReceiptHeader.getAccessed()), poReceiptHeader.getAccessedBy(), TimestampUtil.fromInstant(poReceiptHeader.getCustomFormDate()), poReceiptHeader.getCifValue(), 
            poReceiptHeader.getCustomFormNo());
        return poReceiptHeaderRepository.findOneByGrnNo(poReceiptHeader.getGrnNo());
    }

    @Override
    public POReceiptHeader update(POReceiptHeader poReceiptHeader) {
        log.debug("Request to update POReceiptHeader: {}", poReceiptHeader);
        poReceiptHeaderRepository.updatePOReceiptHeader(poReceiptHeader.getId(),
            poReceiptHeader.getGrnNo(), TimestampUtil.fromInstant(poReceiptHeader.getGrnDate()), poReceiptHeader.getStatus(), poReceiptHeader.getVendorID(), poReceiptHeader.getExchangeRate(), poReceiptHeader.getTransportVia(), 
            poReceiptHeader.getFreightBillNumber(), poReceiptHeader.getPackingListNumber(), poReceiptHeader.getGrnReference(), poReceiptHeader.getDiscountAmount(), poReceiptHeader.getRemark(), poReceiptHeader.getGrnType(), 
            poReceiptHeader.getInvoiceAmount(), poReceiptHeader.getHold(), poReceiptHeader.getPaid(), poReceiptHeader.getPosted(), TimestampUtil.fromInstant(poReceiptHeader.getCreated()), poReceiptHeader.getCreatedBy(), 
            TimestampUtil.fromInstant(poReceiptHeader.getModified()), poReceiptHeader.getModifiedBy(), TimestampUtil.fromInstant(poReceiptHeader.getAccessed()), poReceiptHeader.getAccessedBy(), TimestampUtil.fromInstant(poReceiptHeader.getCustomFormDate()), poReceiptHeader.getCifValue(), 
            poReceiptHeader.getCustomFormNo());
        return poReceiptHeaderRepository.findById(poReceiptHeader.getId()).orElse(new POReceiptHeader());
    }

    @Override
    public void delete(Integer id) {
        log.debug("Request to delete POReceiptHeader with ID: {}", id);
        poReceiptHeaderRepository.deletePOReceiptHeader(id);
    }
    
}
