package com.engseen.erp.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.engseen.erp.domain.PODetail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PODetailRepository extends JpaRepository<PODetail, Integer> {

    List<PODetail> findAllByPoNumber(String PONumber);

    @Query(value = "EXEC PODetailInsert :PONumber, :LineNumber, :Item, :LineType, :LineSelector, :OrderQuantity, :QuantityReceived, :QuantityInInspection, :QuantityOnHand, :QuantityOnHold, :BlanketQuantity, :ETADate, :NeedDate, :DateLastReceipt, :LeadTime, :Discount, :LineStatus, :UnitPrice, :ExtendedPrice, :Remark, :VendorItem, :VIDescription, :VIConversion, :VIUnitOfMeasure, :VIOrderQuantity, :VIUnitPrice, :ItemFailure, :PrintUOM, :DepartmentCode, :SegmentCode, :Created, :CreatedBy, :Modified, :ModifiedBy", nativeQuery = true)
    PODetail insertPODetail(@Param("PONumber") String PONumber, @Param("LineNumber") Integer LineNumber, @Param("Item") String Item, @Param("LineType") Character LineType, @Param("LineSelector") Character LineSelector, @Param("OrderQuantity") BigDecimal OrderQuantity,
                            @Param("QuantityReceived") BigDecimal QuantityReceived, @Param("QuantityInInspection") BigDecimal QuantityInInspection, @Param("QuantityOnHand") BigDecimal QuantityOnHand, @Param("QuantityOnHold") BigDecimal QuantityOnHold, @Param("BlanketQuantity") BigDecimal BlanketQuantity, @Param("ETADate") Timestamp ETADate,
                            @Param("NeedDate") Timestamp NeedDate, @Param("DateLastReceipt") Timestamp DateLastReceipt, @Param("LeadTime") Integer LeadTime, @Param("Discount") Integer Discount, @Param("LineStatus") Character LineStatus, @Param("UnitPrice") BigDecimal UnitPrice,
                            @Param("ExtendedPrice") BigDecimal ExtendedPrice, @Param("Remark") String Remark, @Param("VendorItem") String VendorItem, @Param("VIDescription") String VIDescription, @Param("VIConversion") BigDecimal VIConversion, @Param("VIUnitOfMeasure") String VIUnitOfMeasure,
                            @Param("VIOrderQuantity") BigDecimal VIOrderQuantity, @Param("VIUnitPrice") BigDecimal VIUnitPrice, @Param("ItemFailure") String ItemFailure, @Param("PrintUOM") String PrintUOM, @Param("DepartmentCode") String DepartmentCode, @Param("SegmentCode") String SegmentCode,
                            @Param("Created") Timestamp Created, @Param("CreatedBy") String CreatedBy, @Param("Modified") Timestamp Modified, @Param("ModifiedBy") String ModifiedBy);

    @Query(value = "EXEC PODetailUpdate :ID, :PONumber, :LineNumber, :Item, :LineType, :LineSelector, :OrderQuantity, :QuantityReceived, :QuantityInInspection, :QuantityOnHand, :QuantityOnHold, :BlanketQuantity, :ETADate, :NeedDate, :DateLastReceipt, :LeadTime, :Discount, :LineStatus, :UnitPrice, :ExtendedPrice, :Remark, :VendorItem, :VIDescription, :VIConversion, :VIUnitOfMeasure, :VIOrderQuantity, :VIUnitPrice, :ItemFailure, :PrintUOM, :DepartmentCode, :SegmentCode, :Created, :CreatedBy, :Modified, :ModifiedBy", nativeQuery = true)
    PODetail updatePODetail(@Param("ID")Integer ID,
                            @Param("PONumber") String PONumber, @Param("LineNumber") Integer LineNumber, @Param("Item") String Item, @Param("LineType") Character LineType, @Param("LineSelector") Character LineSelector, @Param("OrderQuantity") BigDecimal OrderQuantity,
                            @Param("QuantityReceived") BigDecimal QuantityReceived, @Param("QuantityInInspection") BigDecimal QuantityInInspection, @Param("QuantityOnHand") BigDecimal QuantityOnHand, @Param("QuantityOnHold") BigDecimal QuantityOnHold, @Param("BlanketQuantity") BigDecimal BlanketQuantity, @Param("ETADate") Timestamp ETADate,
                            @Param("NeedDate") Timestamp NeedDate, @Param("DateLastReceipt") Timestamp DateLastReceipt, @Param("LeadTime") Integer LeadTime, @Param("Discount") Integer Discount, @Param("LineStatus") Character LineStatus, @Param("UnitPrice") BigDecimal UnitPrice,
                            @Param("ExtendedPrice") BigDecimal ExtendedPrice, @Param("Remark") String Remark, @Param("VendorItem") String VendorItem, @Param("VIDescription") String VIDescription, @Param("VIConversion") BigDecimal VIConversion, @Param("VIUnitOfMeasure") String VIUnitOfMeasure,
                            @Param("VIOrderQuantity") BigDecimal VIOrderQuantity, @Param("VIUnitPrice") BigDecimal VIUnitPrice, @Param("ItemFailure") String ItemFailure, @Param("PrintUOM") String PrintUOM, @Param("DepartmentCode") String DepartmentCode, @Param("SegmentCode") String SegmentCode,
                            @Param("Created") Timestamp Created, @Param("CreatedBy") String CreatedBy, @Param("Modified") Timestamp Modified, @Param("ModifiedBy") String ModifiedBy);

    @Query(value = "EXEC PODetailDelete :ID", nativeQuery = true)
    void deletePODetail(@Param("ID")Integer ID);

    @Query("SELECT pd FROM PODetail pd "
        + "WHERE pd.orderQuantity > pd.quantityReceived ")
    Page<PODetail> findAllOutstandingItem(Pageable pageable);
    
    @Query("SELECT pd FROM PODetail pd "
        + "WHERE pd.orderQuantity > pd.quantityReceived "
        + "AND pd.poNumber IN :poNumberList ")
    Page<PODetail> findAllOutstandingItemInPoNumberList(Pageable pageable, List<String> poNumberList);

}