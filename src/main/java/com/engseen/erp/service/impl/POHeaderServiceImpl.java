package com.engseen.erp.service.impl;

import com.engseen.erp.domain.POHeader;
import com.engseen.erp.repository.POHeaderRepository;
import com.engseen.erp.service.POHeaderService;
import com.engseen.erp.util.TimestampUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class POHeaderServiceImpl implements POHeaderService {

    private final POHeaderRepository poHeaderRepository;

    @Override
    public POHeader insert(POHeader poHeader) {
        poHeaderRepository.insertPOHeader(poHeader.getPoNumber(), poHeader.getVendorID(), poHeader.getBuyer(), poHeader.getContact(), poHeader.getPhone(), poHeader.getOurContact(),
                poHeader.getOrderStatus(), TimestampUtil.fromInstant(poHeader.getOriginalPODate()), TimestampUtil.fromInstant(poHeader.getPORevisionDate()), poHeader.getPOReference(), poHeader.getPORevision(), poHeader.getLocationID(),
                poHeader.getShipTo(), poHeader.getAddress1(), poHeader.getAddress2(), poHeader.getCity(), poHeader.getState(), poHeader.getZipCode(),
                poHeader.getCountry(), poHeader.getShipVia(), poHeader.getFOBPoint(), poHeader.getStandardTerms(), poHeader.getCash1Percent(), poHeader.getCash1Days(),
                poHeader.getCash2Percent(), poHeader.getCash2Days(), poHeader.getNetDays(), poHeader.getDueDay(), poHeader.getCutoffDay(), poHeader.getMonthsDelay(),
                poHeader.getBlanketOrder(), poHeader.getPrintPO(), poHeader.getContract(), poHeader.getControllingCurrency(), poHeader.getCurrencyCode(), poHeader.getExchangeRate(),
                poHeader.getRemark(), poHeader.getLess1(), poHeader.getLess1Amount(), poHeader.getLess2(), poHeader.getLess2Amount(), poHeader.getOrderTotal(),
                poHeader.getNoOfLines(), poHeader.getPrintPONo(), poHeader.getCounterID(), poHeader.getPOType(), poHeader.getApprovalStatus(), poHeader.getCurrentApprover(),
                poHeader.getImported(), poHeader.getGst(), TimestampUtil.fromInstant(poHeader.getCreated()), poHeader.getCreatedBy(), TimestampUtil.fromInstant(poHeader.getModified()), poHeader.getModifiedBy(),
                TimestampUtil.fromInstant(poHeader.getAccessed()), poHeader.getAccessedBy(), poHeader.getPurchaseRequestApprovalId(), poHeader.getEmailed(), poHeader.getDownloaded()
        );
        return poHeaderRepository.findOneByPoNumber(poHeader.getPoNumber());
    }

    @Override
    public POHeader update(POHeader poHeader) {
        poHeaderRepository.updatePOHeader(poHeader.getId(), poHeader.getPoNumber(), poHeader.getVendorID(), poHeader.getBuyer(), poHeader.getContact(), poHeader.getPhone(), poHeader.getOurContact(),
                poHeader.getOrderStatus(), TimestampUtil.fromInstant(poHeader.getOriginalPODate()), TimestampUtil.fromInstant(poHeader.getPORevisionDate()), poHeader.getPOReference(), poHeader.getPORevision(), poHeader.getLocationID(),
                poHeader.getShipTo(), poHeader.getAddress1(), poHeader.getAddress2(), poHeader.getCity(), poHeader.getState(), poHeader.getZipCode(),
                poHeader.getCountry(), poHeader.getShipVia(), poHeader.getFOBPoint(), poHeader.getStandardTerms(), poHeader.getCash1Percent(), poHeader.getCash1Days(),
                poHeader.getCash2Percent(), poHeader.getCash2Days(), poHeader.getNetDays(), poHeader.getDueDay(), poHeader.getCutoffDay(), poHeader.getMonthsDelay(),
                poHeader.getBlanketOrder(), poHeader.getPrintPO(), poHeader.getContract(), poHeader.getControllingCurrency(), poHeader.getCurrencyCode(), poHeader.getExchangeRate(),
                poHeader.getRemark(), poHeader.getLess1(), poHeader.getLess1Amount(), poHeader.getLess2(), poHeader.getLess2Amount(), poHeader.getOrderTotal(),
                poHeader.getNoOfLines(), poHeader.getPrintPONo(), poHeader.getCounterID(), poHeader.getPOType(), poHeader.getApprovalStatus(), poHeader.getCurrentApprover(),
                poHeader.getImported(), poHeader.getGst(), TimestampUtil.fromInstant(poHeader.getCreated()), poHeader.getCreatedBy(), TimestampUtil.fromInstant(poHeader.getModified()), poHeader.getModifiedBy(),
                TimestampUtil.fromInstant(poHeader.getAccessed()), poHeader.getAccessedBy(), poHeader.getPurchaseRequestApprovalId(), poHeader.getEmailed(), poHeader.getDownloaded()
        );
        return poHeaderRepository.findOneByPoNumber(poHeader.getPoNumber());
    }
}
