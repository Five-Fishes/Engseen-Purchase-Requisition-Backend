package com.engseen.erp.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "PurchaseRequisitionTemplate")
public class PurchaseRequisitionTemplate implements Serializable {

    @Id
    @Column(name = "Id")
    private long id;

    @Column(name = "TemplateName")
    private String templateName;

    @OneToMany(mappedBy = "purchaseRequisitionTemplate")
    private List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItems;

    @Column(name = "remarks")
    private String remarks;
}
