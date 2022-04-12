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

@Getter
@Setter
@ToString
@Entity
@Table(name = "CounterTableViewLegacy", schema = "dbo")
public class CounterTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CounterCode", columnDefinition = "nvarchar", nullable = false, length = 20)
    private String counterCode;

    @Column(name = "CounterMask", columnDefinition = "nvarchar", length = 20)
    private String counterMask;

    @Column(name = "DefaultCounter", columnDefinition = "nvarchar", length = 20)
    private String defaultCounter;

    @Column(name = "LastCounter", nullable = false)
    private Integer lastCounter;

    @Column(name = "FileName", length = 10)
    private String fileName;

}
