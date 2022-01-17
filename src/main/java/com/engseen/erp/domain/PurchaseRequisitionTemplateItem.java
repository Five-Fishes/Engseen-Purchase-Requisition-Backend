package com.engseen.erp.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@ToString
@Table(name = "PurchaseRequisitionTemplateItem")
public class PurchaseRequisitionTemplateItem implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "PurchaseRequisitionTemplate_id")
    private PurchaseRequisitionTemplate purchaseRequisitionTemplate;

    @Column(name = "Sequence")
    private int sequence;

    @Column(name = "ComponentCode")
    private String componentCode;

    @Column(name = "ComponentName")
    private String componentName;

    @Column(name = "VendorId")
    private String vendorId;

    @Column(name = "VendorName")
    private String vendorName;

    @Column(name = "PackagingSize")
    private BigDecimal packagingSize;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PurchaseRequisitionTemplate getPurchaseRequisitionTemplate() {
        return purchaseRequisitionTemplate;
    }

    public void setPurchaseRequisitionTemplate(PurchaseRequisitionTemplate purchaseRequisitionTemplate) {
        this.purchaseRequisitionTemplate = purchaseRequisitionTemplate;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
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

    public BigDecimal getPackagingSize() {
        return packagingSize;
    }

    public void setPackagingSize(BigDecimal packagingSize) {
        this.packagingSize = packagingSize;
    }
}
