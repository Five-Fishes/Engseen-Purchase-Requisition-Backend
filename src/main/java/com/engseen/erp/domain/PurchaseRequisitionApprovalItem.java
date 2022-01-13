package com.engseen.erp.domain;

import com.engseen.erp.constant.enumeration.PurchaseRequisitionApprovalItemStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@ToString
@EqualsAndHashCode(callSuper = true)
@Table(name = "PurchaseRequisitionApprovalItem")
public class PurchaseRequisitionApprovalItem extends PurchaseRequisitionRequestItem implements Serializable {

    @Column(name = "ItemCost")
    private BigDecimal itemCost;

    @Enumerated
    @Column(name = "Status")
    private PurchaseRequisitionApprovalItemStatus status;

    @Column(name = "Balance")
    private BigDecimal balance;
}
