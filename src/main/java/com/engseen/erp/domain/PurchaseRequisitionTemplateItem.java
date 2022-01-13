package com.engseen.erp.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PurchaseRequisitionTemplateItem")
public class PurchaseRequisitionTemplateItem {

    @Id
    @Column(name = "Id")
    private long id;

    @ManyToOne()
    @JoinColumn(name = "PurchaseRequisitionTemplate_id")
    private PurchaseRequisitionTemplate purchaseRequisitionTemplate;
}
