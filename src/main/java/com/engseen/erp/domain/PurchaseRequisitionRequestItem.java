package com.engseen.erp.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@ToString
@Table(name = "PurchaseRequisitionRequestItem")
public class PurchaseRequisitionRequestItem implements Serializable {
    
    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "PurchaseRequisitionRequest_id")
    private PurchaseRequisitionRequest purchaseRequisitionRequest;
    
    @Column(name = "componentCode")
    private String componentCode;

    @Column(name = "componentName")
    private String componentName;

    @Column(name = "vendorId")
    private String vendorId;

    @Column(name = "vendorName")
    private String vendorName;

    @Column(name = "stockBalance")
    private BigDecimal stockBalance;

    @Column(name = "packagingSize")
    private BigDecimal packagingSize;

    @Column(name = "noOfPacks")
    private BigDecimal noOfPacks;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "deliveryDate")
    private Date deliveryDate;

}
