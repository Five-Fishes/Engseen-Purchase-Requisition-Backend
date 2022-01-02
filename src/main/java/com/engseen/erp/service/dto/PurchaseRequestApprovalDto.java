package com.engseen.erp.service.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseRequestApproval} entity.
 */
@Data
public class PurchaseRequestApprovalDto {

    private Long id;

    private Long templateId;

    private String remarks;

    private List<PurchaseRequestApprovalItemDto> purchaseRequisitionApprovalItems;
    
    private Date createdDate;
}
