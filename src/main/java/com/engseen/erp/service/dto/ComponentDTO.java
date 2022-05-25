package com.engseen.erp.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.engseen.erp.domain.VendorItem} entity.
 */
@Data
public class ComponentDTO implements Serializable {
    private Long id;

    private String componentCode;

    private String componentName;

    private String vendorId;

    private String vendorName;

    private BigDecimal packagingSize;

    @Override
    public boolean equals(Object object) {
        if (object instanceof ComponentDTO) {
            return this.id == ((ComponentDTO) object).getId();
        }
        return false;
    }
}
