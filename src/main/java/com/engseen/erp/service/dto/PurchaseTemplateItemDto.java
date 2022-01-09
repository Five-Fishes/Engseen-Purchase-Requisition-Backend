package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * A DTO for the {@link com.engseen.erp.entity.PurchaseTemplateItem} entity.
 */
@Data
public class PurchaseTemplateItemDto implements Serializable {

    private Long id;

    private Long templateId;

    private String componentCode;

    private String componentName;

    private String vendorId;

    private String vendorName;

    private Double packagingSize;

    private Double sequence;

    private Double quantity;
    
    private Date deliveryDate;

}
