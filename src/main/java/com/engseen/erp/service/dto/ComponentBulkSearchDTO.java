package com.engseen.erp.service.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class ComponentBulkSearchDTO {

    private String componentCode;

    private String vendorId;

    private BigDecimal packagingSize;
}
