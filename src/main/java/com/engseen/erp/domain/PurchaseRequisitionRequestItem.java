package com.engseen.erp.domain;

import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@ToString
@Table(name = "PurchaseRequisitionRequestItem", schema = "dbo")
public class PurchaseRequisitionRequestItem implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "PurchaseRequisitionRequestId")
    private PurchaseRequisitionRequest purchaseRequisitionRequest;

    @Column(name = "ComponentCode")
    private String componentCode;

    @Column(name = "ComponentName")
    private String componentName;

    @Column(name = "VendorId")
    private String vendorId;

    @Column(name = "VendorName")
    private String vendorName;

    @Column(name = "StockBalance") // TODO: [LU] remove this field, as this value should be real time from inventory table
    private BigDecimal stockBalance;

    @Column(name = "PackagingSize")
    private BigDecimal packagingSize;

    @Column(name = "NoOfPacks")
    private BigDecimal noOfPacks;

    @Column(name = "Quantity") // TODO: [LU] remove this field, as this value is derived from: packaging size * no of packs
    private BigDecimal quantity;

    @Column(name = "DeliveryDate")
    private Date deliveryDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PurchaseRequisitionRequest getPurchaseRequisitionRequest() {
        return purchaseRequisitionRequest;
    }

    public void setPurchaseRequisitionRequest(PurchaseRequisitionRequest purchaseRequisitionRequest) {
        this.purchaseRequisitionRequest = purchaseRequisitionRequest;
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public BigDecimal getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(BigDecimal stockBalance) {
        this.stockBalance = stockBalance;
    }

    public BigDecimal getPackagingSize() {
        return packagingSize;
    }

    public void setPackagingSize(BigDecimal packagingSize) {
        this.packagingSize = packagingSize;
    }

    public BigDecimal getNoOfPacks() {
        return noOfPacks;
    }

    public void setNoOfPacks(BigDecimal noOfPacks) {
        this.noOfPacks = noOfPacks;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
