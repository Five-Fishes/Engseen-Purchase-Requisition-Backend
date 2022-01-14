package com.engseen.erp.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@ToString
@Table(name = "PurchaseRequisitionTemplateItem")
public class PurchaseRequisitionTemplateItem {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "PurchaseRequisitionTemplate_id")
    private PurchaseRequisitionTemplate purchaseRequisitionTemplate;

    @Column(name = "Sequence")
    private int sequence;

    @Column(name = "ComponentCode")
    private String componentCode;

    @Column(name = "ComponentName")
    private String componentName;

    @Column(name = "VendorId")
    private String vendorId;

    @Column(name = "VendorName")
    private String vendorName;

    @Column(name = "PackagingSize")
    private BigDecimal packagingSize;

}
