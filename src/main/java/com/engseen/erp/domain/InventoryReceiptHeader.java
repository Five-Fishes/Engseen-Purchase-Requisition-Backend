package com.engseen.erp.domain;

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
@Table(name = "InventoryReceiptHeaderViewLegacy", schema = "dbo")
public class InventoryReceiptHeader {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "IRNNo", nullable = false, length = 20)
    private String irnNo;

    @Column(name = "IRNDate", nullable = false)
    private Instant irnDate;

    @Column(name = "CustomerID", length = 12)
    private String CustomerID;

    @Column(name = "DONumber", length = 30)
    private String doNumber;

    @Column(name = "Remark", length = 400)
    private String remark;

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

}
