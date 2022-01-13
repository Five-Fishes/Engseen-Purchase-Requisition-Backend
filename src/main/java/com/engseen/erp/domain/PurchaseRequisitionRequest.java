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
@Table(name = "PurchaseRequisitionRequest")
public class PurchaseRequisitionRequest implements Serializable {

    @Id
    @Column(name = "Id")
    private long id;

    @Column(name = "CreatedDate")
    private Date createdDate;

    @Column(name = "TemplateId")
    private long templateId;

    @OneToMany(mappedBy = "purchaseRequisitionRequest")
    private List<PurchaseRequisitionRequestItem> purchaseRequisitionRequestItems;

    @Column(name = "Remarks")
    private String remarks;

}
