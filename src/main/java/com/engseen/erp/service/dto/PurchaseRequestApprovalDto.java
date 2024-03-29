package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * A DTO for the {@link com.engseen.erp.domain.PurchaseRequisitionApproval} entity.
 */
@Data
public class PurchaseRequestApprovalDto implements Serializable {

    private Long id;

    private String remarks;

    private List<PurchaseRequestApprovalItemDto> purchaseRequisitionApprovalItems;
    
    private Date createdDate;
}
