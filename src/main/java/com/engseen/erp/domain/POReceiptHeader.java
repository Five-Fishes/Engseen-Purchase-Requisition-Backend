package com.engseen.erp.domain;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "POReceiptHeaderViewLegacy", schema = "dbo")
public class POReceiptHeader {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "GRNNo", nullable = false, length = 20)
    private String grnNo;

    @Column(name = "GRNDate", nullable = false)
    private Instant grnDate;

    @Column(name = "Status", nullable = false)
    private Character status;

    @Column(name = "VendorID", nullable = false, length = 12)
    private String vendorID;

    @Column(name = "ExchangeRate")
    private BigDecimal exchangeRate;

    @Column(name = "TransportVia", length = 30)
    private String transportVia;

    @Column(name = "FreightBillNumber", length = 8)
    private String freightBillNumber;

    @Column(name = "PackingListNumber", length = 30)
    private String packingListNumber;

    @Column(name = "GRNReference", length = 12)
    private String grnReference;

    @Column(name = "DiscountAmount")
    private BigDecimal discountAmount;

    @Column(name = "Remark", length = 400)
    private String remark;

    @Column(name = "GRNType")
    private Character grnType;

    @Column(name = "InvoiceAmount")
    private BigDecimal invoiceAmount;

    @Column(name = "Hold")
    private Character hold;

    @Column(name = "Paid")
    private Character paid;

    @Column(name = "Posted")
    private Character posted;

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

    @Column(name = "CustomFormDate")
    private Instant customFormDate;

    @Column(name = "CIFValue")
    private BigDecimal cifValue;

    @Column(name = "CustomFormNo", length = 20)
    private String customFormNo;

}
