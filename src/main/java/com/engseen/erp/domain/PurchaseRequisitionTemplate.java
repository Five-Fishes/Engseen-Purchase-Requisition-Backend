package com.engseen.erp.domain;

import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Table(name = "PurchaseRequisitionTemplate", schema = "dbo")
public class PurchaseRequisitionTemplate implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TemplateName")
    private String templateName;

    @OneToMany(mappedBy = "purchaseRequisitionTemplate", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItems;

    @Column(name = "Remarks")
    private String remarks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public List<PurchaseRequisitionTemplateItem> getPurchaseRequisitionTemplateItems() {
        return purchaseRequisitionTemplateItems;
    }

    public void setPurchaseRequisitionTemplateItems(List<PurchaseRequisitionTemplateItem> purchaseRequisitionTemplateItems) {
        this.purchaseRequisitionTemplateItems = purchaseRequisitionTemplateItems;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
