package com.engseen.erp.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString
@Table(name = "PurchaseRequisitionApproval")
public class PurchaseRequisitionApproval implements Serializable {

    @Id
    @Column(name = "Id")
    private long id;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @OneToMany(mappedBy = "PurchaseRequisitionApprovalItems")
    private List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItems;

    @Column(name = "Remarks")
    private String remarks;

}
