package com.engseen.erp.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@ToString
@Table(name = "PurchaseRequisitionTemplate")
public class PurchaseRequisitionTemplate implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "TemplateName")
    private String templateName;

    @OneToMany(mappedBy = "purchaseRequisitionTemplate", cascade = CascadeType.ALL)
    private List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItems;

    @Column(name = "remarks")
    private String remarks;
}
