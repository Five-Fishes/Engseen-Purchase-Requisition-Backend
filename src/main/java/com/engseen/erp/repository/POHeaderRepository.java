package com.engseen.erp.repository;

import java.math.BigDecimal;
import java.time.Instant;

import com.engseen.erp.domain.POHeader;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface POHeaderRepository extends JpaRepository<POHeader, Integer> {

    Page<POHeader> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable);
    
    @Procedure(value = "POHeaderInsert")
    Integer insertPOHeader(String PONumber, String VendorID, String Buyer, String Contact, String Phone, String OurContact, 
        Character OrderStatus, Instant OriginalPODate, Instant PORevisionDate, String POReference, String PORevision, Integer LocationID, 
        String ShipTo, String Address1, String Address2, String City, String State, String ZipCode, 
        String Country, String ShipVia, String FOBPoint, Character StandardTerms, BigDecimal Cash1Percent, Integer Cash1Days, 
        BigDecimal Cash2Percent, Integer Cash2Days, Integer NetDays, Integer DueDay, Integer CutoffDay, Integer MonthsDelay, 
        Character BlanketOrder, Character PrintPO, String Contract, Character ControllingCurrency, String CurrencyCode, BigDecimal ExchangeRate, 
        String Remark, String Less1, BigDecimal Less1Amount, String Less2, BigDecimal Less2Amount, BigDecimal OrderTotal, 
        Integer NoOfLines, Integer PrintPONo, Integer CounterID, Character POType, Character ApprovalStatus, String CurrentApprover, 
        Character Imported, Integer GST, Instant Created, String CreatedBy, Instant Modified, String ModifiedBy, 
        Instant Accessed, String AccessedBy, Long PurchaseRequestApprovalId, boolean Emailed, boolean Downloaded
    );
    
}