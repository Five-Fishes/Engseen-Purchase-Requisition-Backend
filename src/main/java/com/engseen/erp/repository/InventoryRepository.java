package com.engseen.erp.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.engseen.erp.domain.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    List<Inventory> findAllByItem(String item);

    Inventory findOneByItemAndStoreNoAndStoreBinAndReceiptID(String item, String storeNo, String storeBin, Integer receiptID);

    /*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
    @Query(value = "EXEC InventoryInsert :Item, :StoreNo, :StoreBin, :InventoryCode, :Quantity, :UnitCost, :InspectionCode, :ReceiptID, :ReceiptDate, :VendorID, :LotNo, :GRNNo, :ReferenceNo, :ReferenceNo2, :OrderType, :OrderNumber, :LineNumber, :FromID, :ToOrderType, :ToOrderNumber, :ToLineNumber, :Weight, :SellingPrice, :FUnitCost, :FCurrencyCode, :FExchangeRate, :Created, :CreatedBy", 
        nativeQuery = true)
    Inventory insertInventory(@Param("Item") String Item, @Param("StoreNo") String StoreNo, @Param("StoreBin") String StoreBin, @Param("InventoryCode") Character InventoryCode, @Param("Quantity") BigDecimal Quantity, @Param("UnitCost") BigDecimal UnitCost,
                            @Param("InspectionCode") Character InspectionCode, @Param("ReceiptID") Integer ReceiptID, @Param("ReceiptDate") Timestamp ReceiptDate, @Param("VendorID") String VendorID, @Param("LotNo") String LotNo, @Param("GRNNo") String GRNNo, 
                            @Param("ReferenceNo") String ReferenceNo, @Param("ReferenceNo2") String ReferenceNo2, @Param("OrderType") Character OrderType, @Param("OrderNumber") String OrderNumber, @Param("LineNumber") Integer LineNumber, @Param("FromID") Integer FromID, 
                            @Param("ToOrderType") Character ToOrderType, @Param("ToOrderNumber") String ToOrderNumber, @Param("ToLineNumber") Integer ToLineNumber, @Param("Weight") BigDecimal Weight, @Param("SellingPrice") BigDecimal SellingPrice, @Param("FUnitCost") BigDecimal FUnitCost, 
                            @Param("FCurrencyCode") String FCurrencyCode, @Param("FExchangeRate") BigDecimal FExchangeRate, @Param("Created") Timestamp Created, @Param("CreatedBy") String CreatedBy
    );

    /*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
    @Query(value = "EXEC InventoryUpdate :ID, :Item, :StoreNo, :StoreBin, :InventoryCode, :Quantity, :UnitCost, :InspectionCode, :ReceiptID, :ReceiptDate, :VendorID, :LotNo, :GRNNo, :ReferenceNo, :ReferenceNo2, :OrderType, :OrderNumber, :LineNumber, :FromID, :ToOrderType, :ToOrderNumber, :ToLineNumber, :Weight, :SellingPrice, :FUnitCost, :FCurrencyCode, :FExchangeRate, :Created, :CreatedBy", 
        nativeQuery = true)
    Inventory updateInventory(@Param("ID") Integer ID,
                            @Param("Item") String Item, @Param("StoreNo") String StoreNo, @Param("StoreBin") String StoreBin, @Param("InventoryCode") Character InventoryCode, @Param("Quantity") BigDecimal Quantity, @Param("UnitCost") BigDecimal UnitCost,
                            @Param("InspectionCode") Character InspectionCode, @Param("ReceiptID") Integer ReceiptID, @Param("ReceiptDate") Timestamp ReceiptDate, @Param("VendorID") String VendorID, @Param("LotNo") String LotNo, @Param("GRNNo") String GRNNo, 
                            @Param("ReferenceNo") String ReferenceNo, @Param("ReferenceNo2") String ReferenceNo2, @Param("OrderType") Character OrderType, @Param("OrderNumber") String OrderNumber, @Param("LineNumber") Integer LineNumber, @Param("FromID") Integer FromID, 
                            @Param("ToOrderType") Character ToOrderType, @Param("ToOrderNumber") String ToOrderNumber, @Param("ToLineNumber") Integer ToLineNumber, @Param("Weight") BigDecimal Weight, @Param("SellingPrice") BigDecimal SellingPrice, @Param("FUnitCost") BigDecimal FUnitCost, 
                            @Param("FCurrencyCode") String FCurrencyCode, @Param("FExchangeRate") BigDecimal FExchangeRate, @Param("Created") Timestamp Created, @Param("CreatedBy") String CreatedBy
    );

    @Query(value = "EXEC InventoryDelete :ID", nativeQuery = true)
    void deleteInventory(@Param("ID") Integer ID);

}
