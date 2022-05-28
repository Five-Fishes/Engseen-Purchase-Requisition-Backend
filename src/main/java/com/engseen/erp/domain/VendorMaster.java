package com.engseen.erp.domain;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@ToString
@Table(name = "VendorMasterViewLegacy", schema = "dbo")
public class VendorMaster {

    @Id
    @Column(name = "ID")
    private int id;
    
    @Column(name = "VendorID")
    private String vendorID;
    
    @Column(name = "VendorName")
    private String vendorName;
    
    @Column(name = "Contact")
    private String contact;
    
    @Column(name = "Phone")
    private String phone;
    
    @Column(name = "FaxNumber")
    private String faxNumber;
    
    @Column(name = "Approval")
    private Character approval;

    @Column(name = "`Print`")
    private Character print;

    @Column(name = "VendorRevision")
    private String vendorRevision;

    @Column(name = "VendorStatus")
    private Character vendorStatus;

    @Column(name = "Address1")
    private String address1;

    @Column(name = "Address2")
    private String address2;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "ZipCode")
    private String zipCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "AccountingContactName")
    private String accountingContactName;

    @Column(name = "AccountingContactPhone")
    private String accountingContactPhone;

    @Column(name = "Payee")
    private String payee;

    @Column(name = "PayeeAddress1")
    private String payeeAddress1;

    @Column(name = "PayeeAddress2")
    private String payeeAddress2;

    @Column(name = "PayeeCity")
    private String payeeCity;

    @Column(name = "PayeeState")
    private String payeeState;

    @Column(name = "PayeeZipCode")
    private String payeeZipCode;

    @Column(name = "PayeeCountry")
    private String payeeCountry;

    @Column(name = "BankName")
    private String bankName;

    @Column(name = "BankAccount")
    private String bankAccount;

    @Column(name = "StandardTerms")
    private Character standardTerms;

    @Column(name = "Cash1Percent")
    private BigDecimal cash1Percent;

    @Column(name = "Cash1Days")
    private int cash1Days;

    @Column(name = "Cash2Percent")
    private BigDecimal cash2Percent;

    @Column(name = "Cash2Days")
    private int cash2Days;

    @Column(name = "NetDays")
    private int netDays;

    @Column(name = "DueDay")
    private int dueDay;

    @Column(name = "CutoffDay")
    private int cutoffDay;

    @Column(name = "MonthsDelay")
    private int monthsDelay;

    @Column(name = "CurrencyCode")
    private String currencyCode;

    @Column(name = "ControllingCurrency")
    private Character controllingCurrency;

    @Column(name = "Remark1")
    private String remark1;

    @Column(name = "Remark2")
    private String remark2;

    @Column(name = "Remark3")
    private String remark3;

    @Column(name = "RegionCode")
    private String regionCode;

    @Column(name = "OIorBF")
    private Character oIorBF;

    @Column(name = "GSTNo")
    private String gstNo;

    @Column(name = "Created")
    private Date created;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "Modified")
    private Date modified;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    @Column(name = "Accessed")
    private Date accessed;

    @Column(name = "AccessedBy")
    private String accessedBy;

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

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public Character getApproval() {
        return approval;
    }

    public void setApproval(Character approval) {
        this.approval = approval;
    }

    public Character getPrint() {
        return print;
    }

    public void setPrint(Character print) {
        this.print = print;
    }

    public String getVendorRevision() {
        return vendorRevision;
    }

    public void setVendorRevision(String vendorRevision) {
        this.vendorRevision = vendorRevision;
    }

    public Character getVendorStatus() {
        return vendorStatus;
    }

    public void setVendorStatus(Character vendorStatus) {
        this.vendorStatus = vendorStatus;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAccountingContactName() {
        return accountingContactName;
    }

    public void setAccountingContactName(String accountingContactName) {
        this.accountingContactName = accountingContactName;
    }

    public String getAccountingContactPhone() {
        return accountingContactPhone;
    }

    public void setAccountingContactPhone(String accountingContactPhone) {
        this.accountingContactPhone = accountingContactPhone;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getPayeeAddress1() {
        return payeeAddress1;
    }

    public void setPayeeAddress1(String payeeAddress1) {
        this.payeeAddress1 = payeeAddress1;
    }

    public String getPayeeAddress2() {
        return payeeAddress2;
    }

    public void setPayeeAddress2(String payeeAddress2) {
        this.payeeAddress2 = payeeAddress2;
    }

    public String getPayeeCity() {
        return payeeCity;
    }

    public void setPayeeCity(String payeeCity) {
        this.payeeCity = payeeCity;
    }

    public String getPayeeState() {
        return payeeState;
    }

    public void setPayeeState(String payeeState) {
        this.payeeState = payeeState;
    }

    public String getPayeeZipCode() {
        return payeeZipCode;
    }

    public void setPayeeZipCode(String payeeZipCode) {
        this.payeeZipCode = payeeZipCode;
    }

    public String getPayeeCountry() {
        return payeeCountry;
    }

    public void setPayeeCountry(String payeeCountry) {
        this.payeeCountry = payeeCountry;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Character getStandardTerms() {
        return standardTerms;
    }

    public void setStandardTerms(Character standardTerms) {
        this.standardTerms = standardTerms;
    }

    public BigDecimal getCash1Percent() {
        return cash1Percent;
    }

    public void setCash1Percent(BigDecimal cash1Percent) {
        this.cash1Percent = cash1Percent;
    }

    public int getCash1Days() {
        return cash1Days;
    }

    public void setCash1Days(int cash1Days) {
        this.cash1Days = cash1Days;
    }

    public BigDecimal getCash2Percent() {
        return cash2Percent;
    }

    public void setCash2Percent(BigDecimal cash2Percent) {
        this.cash2Percent = cash2Percent;
    }

    public int getCash2Days() {
        return cash2Days;
    }

    public void setCash2Days(int cash2Days) {
        this.cash2Days = cash2Days;
    }

    public int getNetDays() {
        return netDays;
    }

    public void setNetDays(int netDays) {
        this.netDays = netDays;
    }

    public int getDueDay() {
        return dueDay;
    }

    public void setDueDay(int dueDay) {
        this.dueDay = dueDay;
    }

    public int getCutoffDay() {
        return cutoffDay;
    }

    public void setCutoffDay(int cutoffDay) {
        this.cutoffDay = cutoffDay;
    }

    public int getMonthsDelay() {
        return monthsDelay;
    }

    public void setMonthsDelay(int monthsDelay) {
        this.monthsDelay = monthsDelay;
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

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Character getoIorBF() {
        return oIorBF;
    }

    public void setoIorBF(Character oIorBF) {
        this.oIorBF = oIorBF;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
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

    public Date getAccessed() {
        return accessed;
    }

    public void setAccessed(Date accessed) {
        this.accessed = accessed;
    }

    public String getAccessedBy() {
        return accessedBy;
    }

    public void setAccessedBy(String accessedBy) {
        this.accessedBy = accessedBy;
    }
}
