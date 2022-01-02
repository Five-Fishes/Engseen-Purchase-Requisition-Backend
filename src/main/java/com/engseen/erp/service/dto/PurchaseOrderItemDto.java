package com.engseen.erp.service.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseOrderItem} entity.
 */
@Data
public class PurchaseOrderItemDto extends PurchaseRequestItemDto implements Serializable {

    private Long id;

    private Long purchaseOrderId;

    private Double itemCost;

    private String uom;
    
}
