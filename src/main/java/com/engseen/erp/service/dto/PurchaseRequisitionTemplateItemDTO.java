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

    private int sequence;

    /**
     * - Quantity(No. of Packs) current item to be delivered
     * - Optional field
     * - Used while constructing request
     */
    private Double quantity;

    /**
     * - Date current item to be delivered
     * - Optional field
     * - Used while constructing request
     */
    private Date deliveryDate;

}
