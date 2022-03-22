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
@Table(name = "InventoryReceiptViewLegacy", schema = "dbo")
public class InventoryReceipt {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "IRNNo", nullable = false, length = 20)
    private String irnNo;

    @Column(name = "Item", nullable = false, length = 30)
    private String item;

    @Column(name = "StoreNo", nullable = false, length = 4)
    private String storeNo;

    @Column(name = "StoreBin", nullable = false, length = 12)
    private String storeBin;

    @Column(name = "ReceiptQuantity", nullable = false)
    private BigDecimal receiptQuantity;

    @Column(name = "Weight", nullable = false)
    private BigDecimal weight;

    @Column(name = "IID", nullable = false)
    private Integer iid;

    @Column(name = "Created")
    private Instant created;

    @Column(name = "CreatedBy", length = 8)
    private String createdBy;
}
