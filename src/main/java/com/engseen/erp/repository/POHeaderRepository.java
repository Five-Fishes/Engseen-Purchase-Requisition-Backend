package com.engseen.erp.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.engseen.erp.domain.POHeader;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface POHeaderRepository extends JpaRepository<POHeader, Integer> {

    Page<POHeader> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable);

    List<POHeader> findByPoNumber(String poNumber);

    /*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
    @Query(value = "EXEC POHeaderInsert :PONumber, :VendorID, :Buyer, :Contact, :Phone, :OurContact, :OrderStatus, :OriginalPODate, :PORevisionDate, :POReference, :PORevision, :LocationID, :ShipTo, :Address1, :Address2, :City, :State, :ZipCode, :Country, :ShipVia, :FOBPoint, :StandardTerms, :Cash1Percent, :Cash1Days, :Cash2Percent, :Cash2Days, :NetDays, :DueDay, :CutoffDay, :MonthsDelay, :BlanketOrder, :PrintPO, :Contract, :ControllingCurrency, :CurrencyCode, :ExchangeRate, :Remark, :Less1, :Less1Amount, :Less2, :Less2Amount, :OrderTotal, :NoOfLines, :PrintPONo, :CounterID, :POType, :ApprovalStatus, :CurrentApprover, :Imported, :GST, :Created, :CreatedBy, :Modified, :ModifiedBy, :Accessed, :AccessedBy, :PurchaseRequestApprovalId, :Emailed, :Downloaded", nativeQuery = true)
    POHeader insertPOHeader(@Param("PONumber") String PONumber, @Param("VendorID") String VendorID, @Param("Buyer") String Buyer, @Param("Contact") String Contact, @Param("Phone") String Phone, @Param("OurContact") String OurContact,
                            @Param("OrderStatus") Character OrderStatus, @Param("OriginalPODate") Timestamp OriginalPODate, @Param("PORevisionDate") Timestamp PORevisionDate, @Param("POReference") String POReference, @Param("PORevision") String PORevision, @Param("LocationID") Integer LocationID,
                            @Param("ShipTo") String ShipTo, @Param("Address1") String Address1, @Param("Address2") String Address2, @Param("City") String City, @Param("State") String State, @Param("ZipCode") String ZipCode,
                            @Param("Country") String Country, @Param("ShipVia") String ShipVia, @Param("FOBPoint") String FOBPoint, @Param("StandardTerms") Character StandardTerms, @Param("Cash1Percent") BigDecimal Cash1Percent, @Param("Cash1Days") Integer Cash1Days,
                            @Param("Cash2Percent") BigDecimal Cash2Percent, @Param("Cash2Days") Integer Cash2Days, @Param("NetDays") Integer NetDays, @Param("DueDay") Integer DueDay, @Param("CutoffDay") Integer CutoffDay, @Param("MonthsDelay") Integer MonthsDelay,
                            @Param("BlanketOrder") Character BlanketOrder, @Param("PrintPO") Character PrintPO, @Param("Contract") String Contract, @Param("ControllingCurrency") Character ControllingCurrency, @Param("CurrencyCode") String CurrencyCode, @Param("ExchangeRate") BigDecimal ExchangeRate,
                            @Param("Remark") String Remark, @Param("Less1") String Less1, @Param("Less1Amount") BigDecimal Less1Amount, @Param("Less2") String Less2, @Param("Less2Amount") BigDecimal Less2Amount, @Param("OrderTotal") BigDecimal OrderTotal,
                            @Param("NoOfLines") Integer NoOfLines, @Param("PrintPONo") Integer PrintPONo, @Param("CounterID") Integer CounterID, @Param("POType") Character POType, @Param("ApprovalStatus") Character ApprovalStatus, @Param("CurrentApprover") String CurrentApprover,
                            @Param("Imported") Character Imported, @Param("GST") Integer GST, @Param("Created") Timestamp Created, @Param("CreatedBy") String CreatedBy, @Param("Modified") Timestamp Modified, @Param("ModifiedBy") String ModifiedBy,
                            @Param("Accessed") Timestamp Accessed, @Param("AccessedBy") String AccessedBy, @Param("PurchaseRequestApprovalId") Long PurchaseRequestApprovalId, @Param("Emailed") boolean Emailed, @Param("Downloaded") boolean Downloaded
    );

    /*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
    @Query(value = "EXEC POHeaderUpdate :ID, :PONumber, :VendorID, :Buyer, :Contact, :Phone, :OurContact, :OrderStatus, :OriginalPODate, :PORevisionDate, :POReference, :PORevision, :LocationID, :ShipTo, :Address1, :Address2, :City, :State, :ZipCode, :Country, :ShipVia, :FOBPoint, :StandardTerms, :Cash1Percent, :Cash1Days, :Cash2Percent, :Cash2Days, :NetDays, :DueDay, :CutoffDay, :MonthsDelay, :BlanketOrder, :PrintPO, :Contract, :ControllingCurrency, :CurrencyCode, :ExchangeRate, :Remark, :Less1, :Less1Amount, :Less2, :Less2Amount, :OrderTotal, :NoOfLines, :PrintPONo, :CounterID, :POType, :ApprovalStatus, :CurrentApprover, :Imported, :GST, :Created, :CreatedBy, :Modified, :ModifiedBy, :Accessed, :AccessedBy, :PurchaseRequestApprovalId, :Emailed, :Downloaded", nativeQuery = true)
    POHeader updatePOHeader(@Param("ID") Integer ID,
                            @Param("PONumber") String PONumber, @Param("VendorID") String VendorID, @Param("Buyer") String Buyer, @Param("Contact") String Contact, @Param("Phone") String Phone, @Param("OurContact") String OurContact,
                            @Param("OrderStatus") Character OrderStatus, @Param("OriginalPODate") Timestamp OriginalPODate, @Param("PORevisionDate") Timestamp PORevisionDate, @Param("POReference") String POReference, @Param("PORevision") String PORevision, @Param("LocationID") Integer LocationID,
                            @Param("ShipTo") String ShipTo, @Param("Address1") String Address1, @Param("Address2") String Address2, @Param("City") String City, @Param("State") String State, @Param("ZipCode") String ZipCode,
                            @Param("Country") String Country, @Param("ShipVia") String ShipVia, @Param("FOBPoint") String FOBPoint, @Param("StandardTerms") Character StandardTerms, @Param("Cash1Percent") BigDecimal Cash1Percent, @Param("Cash1Days") Integer Cash1Days,
                            @Param("Cash2Percent") BigDecimal Cash2Percent, @Param("Cash2Days") Integer Cash2Days, @Param("NetDays") Integer NetDays, @Param("DueDay") Integer DueDay, @Param("CutoffDay") Integer CutoffDay, @Param("MonthsDelay") Integer MonthsDelay,
                            @Param("BlanketOrder") Character BlanketOrder, @Param("PrintPO") Character PrintPO, @Param("Contract") String Contract, @Param("ControllingCurrency") Character ControllingCurrency, @Param("CurrencyCode") String CurrencyCode, @Param("ExchangeRate") BigDecimal ExchangeRate,
                            @Param("Remark") String Remark, @Param("Less1") String Less1, @Param("Less1Amount") BigDecimal Less1Amount, @Param("Less2") String Less2, @Param("Less2Amount") BigDecimal Less2Amount, @Param("OrderTotal") BigDecimal OrderTotal,
                            @Param("NoOfLines") Integer NoOfLines, @Param("PrintPONo") Integer PrintPONo, @Param("CounterID") Integer CounterID, @Param("POType") Character POType, @Param("ApprovalStatus") Character ApprovalStatus, @Param("CurrentApprover") String CurrentApprover,
                            @Param("Imported") Character Imported, @Param("GST") Integer GST, @Param("Created") Timestamp Created, @Param("CreatedBy") String CreatedBy, @Param("Modified") Timestamp Modified, @Param("ModifiedBy") String ModifiedBy,
                            @Param("Accessed") Timestamp Accessed, @Param("AccessedBy") String AccessedBy, @Param("PurchaseRequestApprovalId") Long PurchaseRequestApprovalId, @Param("Emailed") boolean Emailed, @Param("Downloaded") boolean Downloaded
    );

    @Query(value = "EXEC POHeaderDelete :ID", nativeQuery = true)
    void deletePOHeader(@Param("ID") Integer ID);

	Page<POHeader> findAllByVendorID(Pageable pageable, String vendorId);

}