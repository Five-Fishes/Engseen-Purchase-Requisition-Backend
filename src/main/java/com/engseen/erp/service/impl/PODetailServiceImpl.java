package com.engseen.erp.service.impl;

import com.engseen.erp.domain.PODetail;
import com.engseen.erp.repository.PODetailRepository;
import com.engseen.erp.service.PODetailService;
import com.engseen.erp.util.TimestampUtil;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PODetailServiceImpl implements PODetailService {

    private final PODetailRepository poDetailRepository;

    @Override
    public PODetail insert(PODetail poDetail) {
        poDetailRepository.insertPODetail(poDetail.getPoNumber(), poDetail.getLineNumber(), poDetail.getItem(), poDetail.getLineType(), poDetail.getLineSelector(), poDetail.getOrderQuantity(), 
            poDetail.getQuantityReceived(), poDetail.getQuantityInInspection(), poDetail.getQuantityOnHand(), poDetail.getQuantityOnHold(), poDetail.getBlanketQuantity(), TimestampUtil.fromInstant(poDetail.getEtaDate()), 
            TimestampUtil.fromInstant(poDetail.getNeedDate()), TimestampUtil.fromInstant(poDetail.getDateLastReceipt()), poDetail.getLeadTime(), poDetail.getDiscount(), poDetail.getLineStatus(), poDetail.getUnitPrice(), 
            poDetail.getExtendedPrice(), poDetail.getRemark(), poDetail.getVendorItem(), poDetail.getVIDescription(), poDetail.getVIConversion(), poDetail.getVIUnitOfMeasure(), 
            poDetail.getVIOrderQuantity(), poDetail.getVIUnitPrice(), poDetail.getItemFailure(), poDetail.getPrintUOM(), poDetail.getDepartmentCode(), poDetail.getSegmentCode(), 
            TimestampUtil.fromInstant(poDetail.getCreated()), poDetail.getCreatedBy(), TimestampUtil.fromInstant(poDetail.getModified()), poDetail.getModifiedBy()
        );
        return poDetailRepository.findOneByPoNumberAndItem(poDetail.getPoNumber(), poDetail.getItem());
    }

    @Override
    public PODetail update(PODetail poDetail) {
        poDetailRepository.updatePODetail(poDetail.getId(),
            poDetail.getPoNumber(), poDetail.getLineNumber(), poDetail.getItem(), poDetail.getLineType(), poDetail.getLineSelector(), poDetail.getOrderQuantity(), 
            poDetail.getQuantityReceived(), poDetail.getQuantityInInspection(), poDetail.getQuantityOnHand(), poDetail.getQuantityOnHold(), poDetail.getBlanketQuantity(), TimestampUtil.fromInstant(poDetail.getEtaDate()), 
            TimestampUtil.fromInstant(poDetail.getNeedDate()), TimestampUtil.fromInstant(poDetail.getDateLastReceipt()), poDetail.getLeadTime(), poDetail.getDiscount(), poDetail.getLineStatus(), poDetail.getUnitPrice(), 
            poDetail.getExtendedPrice(), poDetail.getRemark(), poDetail.getVendorItem(), poDetail.getVIDescription(), poDetail.getVIConversion(), poDetail.getVIUnitOfMeasure(), 
            poDetail.getVIOrderQuantity(), poDetail.getVIUnitPrice(), poDetail.getItemFailure(), poDetail.getPrintUOM(), poDetail.getDepartmentCode(), poDetail.getSegmentCode(), 
            TimestampUtil.fromInstant(poDetail.getCreated()), poDetail.getCreatedBy(), TimestampUtil.fromInstant(poDetail.getModified()), poDetail.getModifiedBy()
        );
        return poDetailRepository.findById(poDetail.getId()).get();
    }
    
}
