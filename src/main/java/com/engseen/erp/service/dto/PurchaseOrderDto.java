package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseOrder} entity.
 */
@Data
public class PurchaseOrderDto implements Serializable {

    private Long id;

    private Long purchaseRequisitionApprovalId;

    private String email;

    private String vendorId;

    private String vendorName;

    private Date revisionDate;

    private String poNumber;
    
    private List<PurchaseOrderItemDto> purchaseOrderItems;

    private Boolean emailed;

    private Boolean downloaded;
}
