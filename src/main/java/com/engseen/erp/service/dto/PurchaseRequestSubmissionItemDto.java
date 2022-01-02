package com.engseen.erp.service.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseRequestSubmissionItem} entity.
 */
@Data
public class PurchaseRequestSubmissionItemDto extends PurchaseRequestItemDto implements Serializable {

    private Long id;

    private Long requestSubmissionId;

    private Double stockBalance;

}