package com.engseen.erp.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * A DTO for the {@link com.engseen.erp.domain.Inventory} entity.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ComponentStockDto extends ComponentDto implements Serializable {

    private Double sequence;

    private Integer stockBalance;
}
