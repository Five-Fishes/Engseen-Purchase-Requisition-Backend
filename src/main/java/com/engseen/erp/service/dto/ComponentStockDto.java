package com.engseen.erp.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.engseen.erp.entity.ComponentStock} entity.
 */
@Data
public class   ComponentStockDto extends ComponentDto implements Serializable {

    private Double sequence;

    private Integer stockBalance;
}
