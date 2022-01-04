package com.engseen.erp.service.dto;

import java.io.Serializable;

import com.engseen.erp.constant.enumeration.PurchaseRequisitionApprovalItemStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseRequestApprovalItem} entity.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PurchaseRequestApprovalItemDto extends PurchaseRequestItemDto implements Serializable {

    private Long requestApprovalId;
    
    private Double itemCost;

    private PurchaseRequisitionApprovalItemStatus status;
    
    private Double balance;
    
}
