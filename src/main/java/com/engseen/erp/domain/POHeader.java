package com.engseen.erp.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "POHeaderViewLegacy")
public class POHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "PONumber", nullable = false, length = 30)
    private String pONumber;

    @Column(name = "VendorID", nullable = false, length = 12)
    private String vendorID;

    @Column(name = "Buyer", nullable = false, length = 8)
    private String buyer;

    @Column(name = "Contact", length = 38)
    private String contact;

    @Column(name = "Phone", length = 30)
    private String phone;

    @Column(name = "OurContact", length = 30)
    private String ourContact;

    @Column(name = "OrderStatus", nullable = false)
    private Character orderStatus;

    @Column(name = "OriginalPODate", nullable = false)
    private Instant originalPODate;

    @Column(name = "PORevisionDate", nullable = false)
    private Instant pORevisionDate;

    @Column(name = "POReference", length = 20)
    private String pOReference;

    @Column(name = "PORevision", length = 2)
    private String pORevision;

    @Column(name = "LocationID")
    private Integer locationID;

    @Column(name = "ShipTo", length = 60)
    private String shipTo;

    @Column(name = "Address1", length = 60)
    private String address1;

    @Column(name = "Address2", length = 60)
    private String address2;

    @Column(name = "City", length = 30)
    private String city;

    @Column(name = "State", length = 20)
    private String state;

    @Column(name = "ZipCode", length = 24)
    private String zipCode;

    @Column(name = "Country", length = 30)
    private String country;

    @Column(name = "ShipVia", length = 40)
    private String shipVia;

    @Column(name = "FOBPoint", length = 40)
    private String fOBPoint;

    @Column(name = "StandardTerms", nullable = false)
    private Character standardTerms;

    @Column(name = "Cash1Percent", nullable = false, precision = 18)
    private BigDecimal cash1Percent;

    @Column(name = "Cash1Days", nullable = false)
    private Integer cash1Days;

    @Column(name = "Cash2Percent", nullable = false, precision = 18)
    private BigDecimal cash2Percent;

    @Column(name = "Cash2Days", nullable = false)
    private Integer cash2Days;

    @Column(name = "NetDays", nullable = false)
    private Integer netDays;

    @Column(name = "DueDay", nullable = false)
    private Integer dueDay;

    @Column(name = "CutoffDay", nullable = false)
    private Integer cutoffDay;

    @Column(name = "MonthsDelay", nullable = false)
    private Integer monthsDelay;

    @Column(name = "BlanketOrder", nullable = false)
    private Character blanketOrder;

    @Column(name = "PrintPO", nullable = false)
    private Character printPO;

    @Column(name = "Contract", length = 42)
    private String contract;

    @Column(name = "ControllingCurrency", nullable = false)
    private Character controllingCurrency;

    @Column(name = "CurrencyCode", nullable = false, length = 10)
    private String currencyCode;

    @Column(name = "ExchangeRate", nullable = false, precision = 18)
    private BigDecimal exchangeRate;

    @Column(name = "Remark", length = 480)
    private String remark;

    @Column(name = "Less1", length = 50)
    private String less1;

    @Column(name = "Less1Amount", precision = 18)
    private BigDecimal less1Amount;

    @Column(name = "Less2", length = 50)
    private String less2;

    @Column(name = "Less2Amount", precision = 18)
    private BigDecimal less2Amount;

    @Column(name = "OrderTotal", nullable = false, precision = 18)
    private BigDecimal orderTotal;

    @Column(name = "NoOfLines")
    private Integer noOfLines;

    @Column(name = "PrintPONo")
    private Integer printPONo;

    @Column(name = "CounterID")
    private Integer counterID;

    @Column(name = "POType")
    private Character pOType;

    @Column(name = "ApprovalStatus")
    private Character approvalStatus;

    @Column(name = "CurrentApprover", length = 8)
    private String currentApprover;

    @Column(name = "Imported")
    private Character imported;

    @Column(name = "GST")
    private Integer gst;

    @Column(name = "PurchaseRequestApprovalId")
    private Long purchaseRequestApprovalId;

    @Column(name = "Emailed", nullable = false)
    private boolean emailed;

    @Column(name = "Downloaded", nullable = false)
    private boolean downloaded;

    @Column(name = "Created")
    private Instant created;

    @Column(name = "CreatedBy", length = 8)
    private String createdBy;

    @Column(name = "Modified")
    private Instant modified;

    @Column(name = "ModifiedBy", length = 8)
    private String modifiedBy;

    @Column(name = "Accessed")
    private Instant accessed;

    @Column(name = "AccessedBy", length = 8)
    private String accessedBy;

    public String getAccessedBy() {
        return accessedBy;
    }

    public void setAccessedBy(String accessedBy) {
        this.accessedBy = accessedBy;
    }

    public Instant getAccessed() {
        return accessed;
    }

    public void setAccessed(Instant accessed) {
        this.accessed = accessed;
    }

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

    public Long getPurchaseRequestApprovalId() {
        return purchaseRequestApprovalId;
    }

    public void setPurchaseRequestApprovalId(Long purchaseRequestApprovalId) {
        this.purchaseRequestApprovalId = purchaseRequestApprovalId;
    }

    public boolean getEmailed() {
        return emailed;
    }

    public void setEmailed(boolean emailed) {
        this.emailed = emailed;
    }

    public boolean getDownloaded() {
        return downloaded;
    }

    public void setDownloaded(boolean downloaded) {
        this.downloaded = downloaded;
    }

    public Integer getGst() {
        return gst;
    }

    public void setGst(Integer gst) {
        this.gst = gst;
    }

    public Character getImported() {
        return imported;
    }

    public void setImported(Character imported) {
        this.imported = imported;
    }

    public String getCurrentApprover() {
        return currentApprover;
    }

    public void setCurrentApprover(String currentApprover) {
        this.currentApprover = currentApprover;
    }

    public Character getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Character approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Character getPOType() {
        return pOType;
    }

    public void setPOType(Character pOType) {
        this.pOType = pOType;
    }

    public Integer getCounterID() {
        return counterID;
    }

    public void setCounterID(Integer counterID) {
        this.counterID = counterID;
    }

    public Integer getPrintPONo() {
        return printPONo;
    }

    public void setPrintPONo(Integer printPONo) {
        this.printPONo = printPONo;
    }

    public Integer getNoOfLines() {
        return noOfLines;
    }

    public void setNoOfLines(Integer noOfLines) {
        this.noOfLines = noOfLines;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    public BigDecimal getLess2Amount() {
        return less2Amount;
    }

    public void setLess2Amount(BigDecimal less2Amount) {
        this.less2Amount = less2Amount;
    }

    public String getLess2() {
        return less2;
    }

    public void setLess2(String less2) {
        this.less2 = less2;
    }

    public BigDecimal getLess1Amount() {
        return less1Amount;
    }

    public void setLess1Amount(BigDecimal less1Amount) {
        this.less1Amount = less1Amount;
    }

    public String getLess1() {
        return less1;
    }

    public void setLess1(String less1) {
        this.less1 = less1;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Character getControllingCurrency() {
        return controllingCurrency;
    }

    public void setControllingCurrency(Character controllingCurrency) {
        this.controllingCurrency = controllingCurrency;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Character getPrintPO() {
        return printPO;
    }

    public void setPrintPO(Character printPO) {
        this.printPO = printPO;
    }

    public Character getBlanketOrder() {
        return blanketOrder;
    }

    public void setBlanketOrder(Character blanketOrder) {
        this.blanketOrder = blanketOrder;
    }

    public Integer getMonthsDelay() {
        return monthsDelay;
    }

    public void setMonthsDelay(Integer monthsDelay) {
        this.monthsDelay = monthsDelay;
    }

    public Integer getCutoffDay() {
        return cutoffDay;
    }

    public void setCutoffDay(Integer cutoffDay) {
        this.cutoffDay = cutoffDay;
    }

    public Integer getDueDay() {
        return dueDay;
    }

    public void setDueDay(Integer dueDay) {
        this.dueDay = dueDay;
    }

    public Integer getNetDays() {
        return netDays;
    }

    public void setNetDays(Integer netDays) {
        this.netDays = netDays;
    }

    public Integer getCash2Days() {
        return cash2Days;
    }

    public void setCash2Days(Integer cash2Days) {
        this.cash2Days = cash2Days;
    }

    public BigDecimal getCash2Percent() {
        return cash2Percent;
    }

    public void setCash2Percent(BigDecimal cash2Percent) {
        this.cash2Percent = cash2Percent;
    }

    public Integer getCash1Days() {
        return cash1Days;
    }

    public void setCash1Days(Integer cash1Days) {
        this.cash1Days = cash1Days;
    }

    public BigDecimal getCash1Percent() {
        return cash1Percent;
    }

    public void setCash1Percent(BigDecimal cash1Percent) {
        this.cash1Percent = cash1Percent;
    }

    public Character getStandardTerms() {
        return standardTerms;
    }

    public void setStandardTerms(Character standardTerms) {
        this.standardTerms = standardTerms;
    }

    public String getFOBPoint() {
        return fOBPoint;
    }

    public void setFOBPoint(String fOBPoint) {
        this.fOBPoint = fOBPoint;
    }

    public String getShipVia() {
        return shipVia;
    }

    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getShipTo() {
        return shipTo;
    }

    public void setShipTo(String shipTo) {
        this.shipTo = shipTo;
    }

    public Integer getLocationID() {
        return locationID;
    }

    public void setLocationID(Integer locationID) {
        this.locationID = locationID;
    }

    public String getPORevision() {
        return pORevision;
    }

    public void setPORevision(String pORevision) {
        this.pORevision = pORevision;
    }

    public String getPOReference() {
        return pOReference;
    }

    public void setPOReference(String pOReference) {
        this.pOReference = pOReference;
    }

    public Instant getPORevisionDate() {
        return pORevisionDate;
    }

    public void setPORevisionDate(Instant pORevisionDate) {
        this.pORevisionDate = pORevisionDate;
    }

    public Instant getOriginalPODate() {
        return originalPODate;
    }

    public void setOriginalPODate(Instant originalPODate) {
        this.originalPODate = originalPODate;
    }

    public Character getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Character orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOurContact() {
        return ourContact;
    }

    public void setOurContact(String ourContact) {
        this.ourContact = ourContact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
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