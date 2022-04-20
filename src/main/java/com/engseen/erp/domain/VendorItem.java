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
@Table(name = "VendorItemViewLegacy", schema = "dbo")
public class VendorItem {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "VendorID")
    private String vendorID;

    @Column(name = "Item")
    private String item;

    @Column(name = "VendorItem")
    private String vendorItem;

    @Column(name = "VIDescription")
    private String viDescription;

    @Column(name = "VIConversion")
    private BigDecimal viConversion;

    @Column(name = "VIUnitOfMeasure")
    private String viUnitOfMeasure;

    @Column(name = "VIUnitPrice")
    private BigDecimal viUnitPrice;

    @Column(name = "EffectiveDate")
    private Date effectiveDate;

    @Column(name = "RevisionNo")
    private String revisionNo;

    @Column(name = "Created")
    private Date created;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "Modified")
    private Date modified;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getVendorItem() {
        return vendorItem;
    }

    public void setVendorItem(String vendorItem) {
        this.vendorItem = vendorItem;
    }

    public String getViDescription() {
        return viDescription;
    }

    public void setViDescription(String vIDescription) {
        this.viDescription = vIDescription;
    }

    public BigDecimal getViConversion() {
        return viConversion;
    }

    public void setViConversion(BigDecimal vIConversion) {
        this.viConversion = vIConversion;
    }

    public String getViUnitOfMeasure() {
        return viUnitOfMeasure;
    }

    public void setViUnitOfMeasure(String vIUnitOfMeasure) {
        this.viUnitOfMeasure = vIUnitOfMeasure;
    }

    public BigDecimal getViUnitPrice() {
        return viUnitPrice;
    }

    public void setViUnitPrice(BigDecimal vIUnitPrice) {
        this.viUnitPrice = vIUnitPrice;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getRevisionNo() {
        return revisionNo;
    }

    public void setRevisionNo(String revisionNo) {
        this.revisionNo = revisionNo;
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

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
