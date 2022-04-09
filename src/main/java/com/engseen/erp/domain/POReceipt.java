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
@Table(name = "POReceiptViewLegacy", schema = "dbo")
public class POReceipt {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "GRNNo", nullable = false, length = 20)
    private String grnNo;

    @Column(name = "PID", nullable = false)
    private Integer pid;

    @Column(name = "QuantityReceived", nullable = false)
    private BigDecimal quantityReceived;

    @Column(name = "QuantityReversed")
    private BigDecimal quantityReversed;

    @Column(name = "UnitCost")
    private BigDecimal unitCost;

    @Column(name = "OrigUnitCost")
    private BigDecimal origUnitCost;

    @Column(name = "InspectionCode")
    private Character inspectionCode;

    @Column(name = "IID")
    private Integer iid;

    @Column(name = "StoreNo", length = 4)
    private String storeNo;

    @Column(name = "StoreBin", length = 12)
    private String storeBin;

    @Column(name = "InventoryCode")
    private Character inventoryCode;

    @Column(name = "LotNo", length = 20)
    private String lotNo;

    @Column(name = "IRID")
    private Integer irid;

    @Column(name = "Created")
    private Instant created;

    @Column(name = "CreatedBy", length = 8)
    private String createdBy;

    @Column(name = "PackReceived")
    private Integer packReceived;

    @Column(name = "PackReversed")
    private Integer packReversed;
    
}
