package com.engseen.erp.service.dto;

import java.io.Serializable;

import com.engseen.erp.constant.enumeration.PurchaseRequisitionApprovalItemStatus;

import lombok.Data;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseRequestApprovalItem} entity.
 */
@Data
public class PurchaseRequestApprovalItemDto extends PurchaseRequestItemDto implements Serializable {

    private Long requestApprovalId;
    
    private Double itemCost;

    private PurchaseRequisitionApprovalItemStatus status;
    
    private Double balance;
    
}
