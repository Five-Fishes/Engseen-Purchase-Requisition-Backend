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
@Table(name = "ItemCostBookViewLegacy", schema = "dbo")
public class ItemCostBook {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Item", length = 30)
    private String item;

    @Column(name = "Updated")
    private Character updated;

    @Column(name = "CreatedBy", length = 8)
    private String createdBy;
}
