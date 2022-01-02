package com.engseen.erp.service.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseOrderItem} entity.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PurchaseOrderItemDto extends PurchaseRequestItemDto implements Serializable {

    private Long id;

    private Long purchaseOrderId;

    private Double itemCost;

    private String uom;
    
}
