package com.engseen.erp.repository;

import java.math.BigDecimal;
import java.time.Instant;

import com.engseen.erp.domain.PODetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface PODetailRepository extends JpaRepository<PODetail, Integer> {

    @Procedure(value = "PODetailInsert")
    PODetail insertPODetail(String PONumber, Integer LineNumber, String Item, Character LineType, Character LineSelector, BigDecimal OrderQuantity, 
        BigDecimal QuantityReceived, BigDecimal QuantityInInspection, BigDecimal QuantityOnHand, BigDecimal QuantityOnHold, BigDecimal BlanketQuantity, Instant ETADate, 
        Instant NeedDate, Instant DateLastReceipt, Integer LeadTime, Integer Discount, Character LineStatus, BigDecimal UnitPrice, 
        BigDecimal ExtendedPrice, String Remark, String VendorItem, String VIDescription, BigDecimal VIConversion, String VIUnitOfMeasure, 
        BigDecimal VIOrderQuantity, BigDecimal VIUnitPrice, String ItemFailure, String PrintUOM, String DepartmentCode, String SegmentCode, 
        Instant Created, String CreatedBy, Instant Modified, String ModifiedBy);

    @Procedure(value = "PODetailUpdate")
    PODetail updatePODetail(Integer ID,
        String PONumber, Integer LineNumber, String Item, Character LineType, Character LineSelector, BigDecimal OrderQuantity, 
        BigDecimal QuantityReceived, BigDecimal QuantityInInspection, BigDecimal QuantityOnHand, BigDecimal QuantityOnHold, BigDecimal BlanketQuantity, Instant ETADate, 
        Instant NeedDate, Instant DateLastReceipt, Integer LeadTime, Integer Discount, Character LineStatus, BigDecimal UnitPrice, 
        BigDecimal ExtendedPrice, String Remark, String VendorItem, String VIDescription, BigDecimal VIConversion, String VIUnitOfMeasure, 
        BigDecimal VIOrderQuantity, BigDecimal VIUnitPrice, String ItemFailure, String PrintUOM, String DepartmentCode, String SegmentCode, 
        Instant Created, String CreatedBy, Instant Modified, String ModifiedBy);

    @Procedure(value = "PODetailDelete")
    void deletePODetail(Integer ID);
    
}