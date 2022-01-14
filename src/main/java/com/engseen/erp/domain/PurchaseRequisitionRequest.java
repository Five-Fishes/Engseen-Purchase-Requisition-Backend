package com.engseen.erp.domain;

import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@Table(name = "PurchaseRequisitionRequest")
public class PurchaseRequisitionRequest implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @Column(name = "TemplateId")
    private long templateId;

    @OneToMany(mappedBy = "purchaseRequisitionRequest")
    @ToString.Exclude
    private List<PurchaseRequisitionRequestItem> purchaseRequisitionRequestItems;

    @Column(name = "Remarks")
    private String remarks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(long templateId) {
        this.templateId = templateId;
    }

    public List<PurchaseRequisitionRequestItem> getPurchaseRequisitionRequestItems() {
        return purchaseRequisitionRequestItems;
    }

    public void setPurchaseRequisitionRequestItems(List<PurchaseRequisitionRequestItem> purchaseRequisitionRequestItems) {
        this.purchaseRequisitionRequestItems = purchaseRequisitionRequestItems;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
