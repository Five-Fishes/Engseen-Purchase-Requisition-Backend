package com.engseen.erp.domain;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@ToString
@Table(name = "InventoryViewLegacy", schema = "dbo")
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
    private Character inventoryCode;

    @Column(name = "Quantity")
    private BigDecimal quantity;

    @Column(name = "UnitCost")
    private BigDecimal unitCost;

    @Column(name = "InspectionCode")
    private Character inspectionCode;

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
    private Character orderType;

    @Column(name = "OrderNumber")
    private String orderNumber;

    @Column(name = "LineNumber")
    private Integer lineNumber;

    @Column(name = "FromID")
    private Integer fromID;

    @Column(name = "ToOrderType")
    private Character toOrderType;

    @Column(name = "ToOrderNumber")
    private String toOrderNumber;

    @Column(name = "ToLineNumber")
    private Integer toLineNumber;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getStoreBin() {
        return storeBin;
    }

    public void setStoreBin(String storeBin) {
        this.storeBin = storeBin;
    }

    public Character getInventoryCode() {
        return inventoryCode;
    }

    public void setInventoryCode(Character inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public Character getInspectionCode() {
        return inspectionCode;
    }

    public void setInspectionCode(Character inspectionCode) {
        this.inspectionCode = inspectionCode;
    }

    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getgRNNo() {
        return gRNNo;
    }

    public void setgRNNo(String gRNNo) {
        this.gRNNo = gRNNo;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getReferenceNo2() {
        return referenceNo2;
    }

    public void setReferenceNo2(String referenceNo2) {
        this.referenceNo2 = referenceNo2;
    }

    public Character getOrderType() {
        return orderType;
    }

    public void setOrderType(Character orderType) {
        this.orderType = orderType;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getFromID() {
        return fromID;
    }

    public void setFromID(Integer fromID) {
        this.fromID = fromID;
    }

    public Character getToOrderType() {
        return toOrderType;
    }

    public void setToOrderType(Character toOrderType) {
        this.toOrderType = toOrderType;
    }

    public String getToOrderNumber() {
        return toOrderNumber;
    }

    public void setToOrderNumber(String toOrderNumber) {
        this.toOrderNumber = toOrderNumber;
    }

    public Integer getToLineNumber() {
        return toLineNumber;
    }

    public void setToLineNumber(Integer toLineNumber) {
        this.toLineNumber = toLineNumber;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getfUnitCost() {
        return fUnitCost;
    }

    public void setfUnitCost(BigDecimal fUnitCost) {
        this.fUnitCost = fUnitCost;
    }

    public String getfCurrencyCode() {
        return fCurrencyCode;
    }

    public void setfCurrencyCode(String fCurrencyCode) {
        this.fCurrencyCode = fCurrencyCode;
    }

    public BigDecimal getfExchangeRate() {
        return fExchangeRate;
    }

    public void setfExchangeRate(BigDecimal fExchangeRate) {
        this.fExchangeRate = fExchangeRate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
