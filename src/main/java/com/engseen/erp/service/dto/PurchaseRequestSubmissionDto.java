package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * A DTO for the {@link com.engseen.erp.entity.PurchaseRequestSubmission} entity.
 */
@Data
public class PurchaseRequestSubmissionDto implements Serializable {

    private Long id;

    private Long templateId;

    private String remarks;

    private List<PurchaseRequestSubmissionItemDto> purchaseRequisitionRequestItems;
    
    private Date createdDate;
    
}
