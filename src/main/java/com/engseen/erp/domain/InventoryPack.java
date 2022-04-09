package com.engseen.erp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "InventoryPackViewLegacy", schema = "dbo")
public class InventoryPack {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Item", nullable = false, length = 30)
    private String item;

    @Column(name = "StoreNo", nullable = false, length = 4)
    private String storeNo;

    @Column(name = "StoreBin", nullable = false, length = 12)
    private String storeBin;

    @Column(name = "Pack")
    private Integer pack;

}
