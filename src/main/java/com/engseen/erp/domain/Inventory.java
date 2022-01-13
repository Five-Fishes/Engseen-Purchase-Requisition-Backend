package com.engseen.erp.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@ToString
@Table(name = "Inventory")
public class Inventory {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "Item")
    private String item;

    @Column(name = "StoreNo")
    private String storeNo;

    @Column(name = "StoreBin")
    private String storeBin;

    @Column(name = "InventoryCode")
    private char inventoryCode;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    @Column(name = "UnitCost")
    private BigDecimal unitCost;

    @Column(name = "InspectionCode")
    private char inspectionCode;

    @Column(name = "ReceiptID")
    private int receiptID;

    @Column(name = "ReceiptDate")
    private Date receiptDate;

    @Column(name = "VendorID")
    private String vendorID;

    @Column(name = "LotNo")
    private String lotNo;

    @Column(name = "GRNNo")
    private String gRNNo;

    @Column(name = "ReferenceNo")
    private String referenceNo;

    @Column(name = "ReferenceNo2")
    private String referenceNo2;

    @Column(name = "OrderType")
    private char orderType;

    @Column(name = "OrderNumber")
    private String orderNumber;

    @Column(name = "LineNumber")
    private int lineNumber;

    @Column(name = "FromID")
    private int fromID;

    @Column(name = "ToOrderType")
    private char toOrderType;

    @Column(name = "ToOrderNumber")
    private String toOrderNumber;

    @Column(name = "ToLineNumber")
    private int toLineNumber;

    @Column(name = "Weight")
    private BigDecimal weight;

    @Column(name = "SellingPrice")
    private BigDecimal sellingPrice;

    @Column(name = "FUnitCost")
    private BigDecimal fUnitCost;

    @Column(name = "FCurrencyCode")
    private String fCurrencyCode;

    @Column(name = "FExchangeRate")
    private BigDecimal fExchangeRate;

    @Column(name = "Created")
    private Date created;

    @Column(name = "CreatedBy")
    private String createdBy;

}
