package com.engseen.erp.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.engseen.erp.domain.VendorItem} entity.
 */
@Data
public class ComponentItemCostDTO implements Serializable {
    private Long id;

    private String componentCode;

    private String vendorId;

    private Integer packagingSize;

    private Double itemCost;
}
