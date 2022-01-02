package com.engseen.erp.service.dto;

import lombok.Data;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseRequestSubmissionItem} entity.
 */
@Data
public class PurchaseRequestSubmissionItemDto extends PurchaseRequestItemDto {

    private Long id;

    private Long requestSubmissionId;

    private Double stockBalance;

}
