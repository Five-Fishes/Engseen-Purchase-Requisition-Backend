package com.engseen.erp.service.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseRequestSubmission} entity.
 */
@Data
public class PurchaseRequestSubmissionDto {

    private Long id;

    private Long templateId;

    private String remarks;

    private List<PurchaseRequestSubmissionItemDto> purchaseRequisitionRequestItems;
    
    private Date createdDate;
    
}
