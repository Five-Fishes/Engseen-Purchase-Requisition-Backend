package com.engseen.erp.service.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A DTO for the {@link com.engseen.erp.domain.PurchaseRequisitionRequestItem} entity.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseRequisitionRequestItemDTO extends PurchaseRequestItemDto implements Serializable {

    private Long id;

    private Long requestSubmissionId;

    private Double stockBalance;

}
