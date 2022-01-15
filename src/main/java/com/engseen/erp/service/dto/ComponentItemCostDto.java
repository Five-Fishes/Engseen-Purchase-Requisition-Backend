package com.engseen.erp.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.engseen.erp.entity.ComponentItemCost} entity.
 */
public class ComponentItemCostDto implements Serializable {
    private Long id;

    private String componentCode;

    private String vendorId;

    private Integer packagingSize;

    private Double itemCost;
}
