package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseTemplateItem} entity.
 */
@Data
public class PurchaseTemplateItemDto implements Serializable {

    private Long id;

    private String componentCode;

    private String componentName;

    private String vendorId;

    private String vendorName;

    private Integer packagingSize;

    private Integer sequence;

    private Integer quantity;
    
    private Date deliveryDate;

}
