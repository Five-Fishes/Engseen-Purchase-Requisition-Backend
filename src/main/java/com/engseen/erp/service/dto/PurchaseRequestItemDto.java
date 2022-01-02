package com.engseen.erp.service.dto;

import java.util.Date;

import lombok.Data;

/**
 * A general DTO for the Purchase Request Item
 */
@Data
public abstract class PurchaseRequestItemDto {
    
    private String componentCode;

    private String componentName;

    private String vendorId;

    private String vendorName;

    private Double packagingSize;

    private Double noOfPacks;

    private Double quantity;
    
    private Date deliveryDate;
    
}
