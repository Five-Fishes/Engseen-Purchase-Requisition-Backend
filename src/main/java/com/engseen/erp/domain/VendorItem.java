package com.engseen.erp.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "VendorItem")
public class VendorItem {
    
    @Id
    @Column(name = "ID")
    private int ID;

    @Column(name = "VendorID")
    private String VendorID;

    @Column(name = "Item")
    private String Item;

    @Column(name = "VendorItem")
    private String VendorItem;

    @Column(name = "VIDescription")
    private String VIDescription;

    @Column(name = "VIConversion")
    private BigDecimal VIConversion;

    @Column(name = "VIUnitOfMeasure")
    private String VIUnitOfMeasure;

    @Column(name = "VIUnitPrice")
    private BigDecimal VIUnitPrice;

    @Column(name = "EffectiveDate")
    private Date EffectiveDate;

    @Column(name = "RevisionNo")
    private String RevisionNo;

    @Column(name = "Created")
    private Date Created;

    @Column(name = "CreatedBy")
    private String CreatedBy;

    @Column(name = "Modified")
    private Date Modified;

    @Column(name = "ModifiedBy")
    private String ModifiedBy;

}
