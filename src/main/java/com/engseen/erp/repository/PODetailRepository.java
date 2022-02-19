package com.engseen.erp.repository;

import java.math.BigDecimal;
import java.time.Instant;

import com.engseen.erp.domain.PODetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PODetailRepository extends JpaRepository<PODetail, Integer> {

    @Query(value = "EXEC PODetailInsert :PONumber, :LineNumber, :Item, :LineType, :LineSelector, :OrderQuantity, :QuantityReceived, :QuantityInInspection, :QuantityOnHand, :QuantityOnHold, :BlanketQuantity, :ETADate, :NeedDate, :DateLastReceipt, :LeadTime, :Discount, :LineStatus, :UnitPrice, :ExtendedPrice, :Remark, :VendorItem, :VIDescription, :VIConversion, :VIUnitOfMeasure, :VIOrderQuantity, :VIUnitPrice, :ItemFailure, :PrintUOM, :DepartmentCode, :SegmentCode, :Created, :CreatedBy, :Modified, :ModifiedBy", nativeQuery = true)
    PODetail insertPODetail(@Param("PONumber") String PONumber, @Param("LineNumber") Integer LineNumber, @Param("Item") String Item, @Param("LineType") Character LineType, @Param("LineSelector") Character LineSelector, @Param("OrderQuantity") BigDecimal OrderQuantity,
                            @Param("QuantityReceived") BigDecimal QuantityReceived, @Param("QuantityInInspection") BigDecimal QuantityInInspection, @Param("QuantityOnHand") BigDecimal QuantityOnHand, @Param("QuantityOnHold") BigDecimal QuantityOnHold, @Param("BlanketQuantity") BigDecimal BlanketQuantity, @Param("ETADate") Instant ETADate,
                            @Param("NeedDate") Instant NeedDate, @Param("DateLastReceipt") Instant DateLastReceipt, @Param("LeadTime") Integer LeadTime, @Param("Discount") Integer Discount, @Param("LineStatus") Character LineStatus, @Param("UnitPrice") BigDecimal UnitPrice,
                            @Param("ExtendedPrice") BigDecimal ExtendedPrice, @Param("Remark") String Remark, @Param("VendorItem") String VendorItem, @Param("VIDescription") String VIDescription, @Param("VIConversion") BigDecimal VIConversion, @Param("VIUnitOfMeasure") String VIUnitOfMeasure,
                            @Param("VIOrderQuantity") BigDecimal VIOrderQuantity, @Param("VIUnitPrice") BigDecimal VIUnitPrice, @Param("ItemFailure") String ItemFailure, @Param("PrintUOM") String PrintUOM, @Param("DepartmentCode") String DepartmentCode, @Param("SegmentCode") String SegmentCode,
                            @Param("Created") Instant Created, @Param("CreatedBy") String CreatedBy, @Param("Modified") Instant Modified, @Param("ModifiedBy") String ModifiedBy);

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