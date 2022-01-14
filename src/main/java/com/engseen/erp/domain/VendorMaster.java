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
@Table(name = "VendorMaster")
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
    private char approval;
    
    @Column(name = "Print")
    private char print;
    
    @Column(name = "VendorRevision")
    private String vendorRevision;
    
    @Column(name = "VendorStatus")
    private char vendorStatus;
    
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
    private char standardTerms;
    
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
    private char controllingCurrency;
    
    @Column(name = "Remark1")
    private String remark1;
    
    @Column(name = "Remark2")
    private String remark2;
    
    @Column(name = "Remark3")
    private String remark3;
    
    @Column(name = "RegionCode")
    private String regionCode;
    
    @Column(name = "OIorBF")
    private char oIorBF;
    
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
    
}
