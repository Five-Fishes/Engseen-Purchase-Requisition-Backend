package com.engseen.erp.service.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A DTO for the {@link com.engseen.erp.entity.PurchaseRequestSubmissionItem} entity.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PurchaseRequestSubmissionItemDto extends PurchaseRequestItemDto implements Serializable {

    private Long id;

    private Long requestSubmissionId;

    private Double stockBalance;

}
