package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A DTO for the {@link com.engseen.erp.domain.PODetail} entity.
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class PurchaseOrderItemDto extends PurchaseRequestItemDto implements Serializable {

    private Long id;

    private Long purchaseOrderId;

    private Double itemCost;

    private String uom;

    private String uomPack;
    
    private String poNumber;

    private String remarks;

    private BigDecimal orderQuantity;

    private BigDecimal orderQuantityPack;

    private BigDecimal receivedQuantity;

    private BigDecimal receivedQuantityPack;

    private BigDecimal openQuantity;

    private BigDecimal openQuantityPack;

    private BigDecimal receivingQuantity;

    private BigDecimal receivingQuantityPack;
    
    private String status;

}
