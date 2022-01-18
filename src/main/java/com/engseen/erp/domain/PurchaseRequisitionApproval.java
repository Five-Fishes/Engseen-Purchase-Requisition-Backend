package com.engseen.erp.domain;

import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@Table(name = "PurchaseRequisitionApproval", schema = "dbo")
public class PurchaseRequisitionApproval implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @OneToMany(mappedBy = "purchaseRequisitionApproval")
    @ToString.Exclude
    private List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItems;

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

    public List<PurchaseRequisitionApprovalItem> getPurchaseRequisitionApprovalItems() {
        return purchaseRequisitionApprovalItems;
    }

    public void setPurchaseRequisitionApprovalItems(List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItems) {
        this.purchaseRequisitionApprovalItems = purchaseRequisitionApprovalItems;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
