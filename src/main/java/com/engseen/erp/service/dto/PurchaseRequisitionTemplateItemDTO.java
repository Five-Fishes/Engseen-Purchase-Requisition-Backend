package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * A DTO for the {@link com.engseen.erp.domain.PurchaseRequisitionTemplateItem} entity.
 */
@Data
public class PurchaseRequisitionTemplateItemDTO implements Serializable {

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
