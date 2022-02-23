package com.engseen.erp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "PODetailViewLegacy", schema = "dbo")
public class PODetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "PONumber", nullable = false, length = 30)
    private String pONumber;

    @Column(name = "LineNumber", nullable = false)
    private Integer lineNumber;

    @Column(name = "Item", nullable = false, length = 30)
    private String item;

    @Column(name = "LineType", nullable = false)
    private Character lineType;

    @Column(name = "LineSelector", nullable = false)
    private Character lineSelector;

    @Column(name = "OrderQuantity", nullable = false, precision = 18)
    private BigDecimal orderQuantity;

    @Column(name = "QuantityReceived", nullable = false, precision = 18)
    private BigDecimal quantityReceived;

    @Column(name = "QuantityInInspection", nullable = false, precision = 18)
    private BigDecimal quantityInInspection;

    @Column(name = "QuantityOnHand", nullable = false, precision = 18)
    private BigDecimal quantityOnHand;

    @Column(name = "QuantityOnHold", nullable = false, precision = 18)
    private BigDecimal quantityOnHold;

    @Column(name = "BlanketQuantity", nullable = false, precision = 18)
    private BigDecimal blanketQuantity;

    @Column(name = "ETADate", nullable = false)
    private Instant eTADate;

    @Column(name = "NeedDate")
    private Instant needDate;

    @Column(name = "DateLastReceipt")
    private Instant dateLastReceipt;

    @Column(name = "LeadTime")
    private Integer leadTime;

    @Column(name = "Discount")
    private Integer discount;

    @Column(name = "LineStatus", nullable = false)
    private Character lineStatus;

    @Column(name = "UnitPrice", nullable = false, precision = 18)
    private BigDecimal unitPrice;

    @Column(name = "ExtendedPrice", nullable = false, precision = 18)
    private BigDecimal extendedPrice;

    @Column(name = "Remark", length = 480)
    private String remark;

    @Column(name = "VendorItem", length = 30)
    private String vendorItem;

    @Column(name = "VIDescription", length = 60)
    private String vIDescription;

    @Column(name = "VIConversion", precision = 18)
    private BigDecimal vIConversion;

    @Column(name = "VIUnitOfMeasure", length = 4)
    private String vIUnitOfMeasure;

    @Column(name = "VIOrderQuantity", precision = 18)
    private BigDecimal vIOrderQuantity;

    @Column(name = "VIUnitPrice", precision = 18)
    private BigDecimal vIUnitPrice;

    @Column(name = "ItemFailure", length = 20)
    private String itemFailure;

    @Column(name = "PrintUOM", length = 4)
    private String printUOM;

    @Column(name = "DepartmentCode", length = 6)
    private String departmentCode;

    @Column(name = "SegmentCode", length = 6)
    private String segmentCode;

    @Column(name = "Created")
    private Instant created;

    @Column(name = "CreatedBy", length = 8)
    private String createdBy;

    @Column(name = "Modified")
    private Instant modified;

    @Column(name = "ModifiedBy", length = 8)
    private String modifiedBy;

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getPrintUOM() {
        return printUOM;
    }

    public void setPrintUOM(String printUOM) {
        this.printUOM = printUOM;
    }

    public String getItemFailure() {
        return itemFailure;
    }

    public void setItemFailure(String itemFailure) {
        this.itemFailure = itemFailure;
    }

    public BigDecimal getVIUnitPrice() {
        return vIUnitPrice;
    }

    public void setVIUnitPrice(BigDecimal vIUnitPrice) {
        this.vIUnitPrice = vIUnitPrice;
    }

    public BigDecimal getVIOrderQuantity() {
        return vIOrderQuantity;
    }

    public void setVIOrderQuantity(BigDecimal vIOrderQuantity) {
        this.vIOrderQuantity = vIOrderQuantity;
    }

    public String getVIUnitOfMeasure() {
        return vIUnitOfMeasure;
    }

    public void setVIUnitOfMeasure(String vIUnitOfMeasure) {
        this.vIUnitOfMeasure = vIUnitOfMeasure;
    }

    public BigDecimal getVIConversion() {
        return vIConversion;
    }

    public void setVIConversion(BigDecimal vIConversion) {
        this.vIConversion = vIConversion;
    }

    public String getVIDescription() {
        return vIDescription;
    }

    public void setVIDescription(String vIDescription) {
        this.vIDescription = vIDescription;
    }

    public String getVendorItem() {
        return vendorItem;
    }

    public void setVendorItem(String vendorItem) {
        this.vendorItem = vendorItem;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(BigDecimal extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Character getLineStatus() {
        return lineStatus;
    }

    public void setLineStatus(Character lineStatus) {
        this.lineStatus = lineStatus;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Integer leadTime) {
        this.leadTime = leadTime;
    }

    public Instant getDateLastReceipt() {
        return dateLastReceipt;
    }

    public void setDateLastReceipt(Instant dateLastReceipt) {
        this.dateLastReceipt = dateLastReceipt;
    }

    public Instant getNeedDate() {
        return needDate;
    }

    public void setNeedDate(Instant needDate) {
        this.needDate = needDate;
    }

    public Instant getETADate() {
        return eTADate;
    }

    public void setETADate(Instant eTADate) {
        this.eTADate = eTADate;
    }

    public BigDecimal getBlanketQuantity() {
        return blanketQuantity;
    }

    public void setBlanketQuantity(BigDecimal blanketQuantity) {
        this.blanketQuantity = blanketQuantity;
    }

    public BigDecimal getQuantityOnHold() {
        return quantityOnHold;
    }

    public void setQuantityOnHold(BigDecimal quantityOnHold) {
        this.quantityOnHold = quantityOnHold;
    }

    public BigDecimal getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(BigDecimal quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public BigDecimal getQuantityInInspection() {
        return quantityInInspection;
    }

    public void setQuantityInInspection(BigDecimal quantityInInspection) {
        this.quantityInInspection = quantityInInspection;
    }

    public BigDecimal getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(BigDecimal quantityReceived) {
        this.quantityReceived = quantityReceived;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Character getLineSelector() {
        return lineSelector;
    }

    public void setLineSelector(Character lineSelector) {
        this.lineSelector = lineSelector;
    }

    public Character getLineType() {
        return lineType;
    }

    public void setLineType(Character lineType) {
        this.lineType = lineType;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getPONumber() {
        return pONumber;
    }

    public void setPONumber(String pONumber) {
        this.pONumber = pONumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}