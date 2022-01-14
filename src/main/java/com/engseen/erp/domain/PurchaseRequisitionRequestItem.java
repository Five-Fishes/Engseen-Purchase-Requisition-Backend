package com.engseen.erp.domain;

import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@ToString
@Table(name = "PurchaseRequisitionRequestItem")
public class PurchaseRequisitionRequestItem implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "PurchaseRequisitionRequest_id")
    private PurchaseRequisitionRequest purchaseRequisitionRequest;

    @Column(name = "componentCode")
    private String componentCode;

    @Column(name = "componentName")
    private String componentName;

    @Column(name = "vendorId")
    private String vendorId;

    @Column(name = "vendorName")
    private String vendorName;

    @Column(name = "stockBalance")
    private BigDecimal stockBalance;

    @Column(name = "packagingSize")
    private BigDecimal packagingSize;

    @Column(name = "noOfPacks")
    private BigDecimal noOfPacks;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "deliveryDate")
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
