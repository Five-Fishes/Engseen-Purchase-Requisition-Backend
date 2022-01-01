package com.engseen.erp.service.dto;

import java.util.Date;

import lombok.Data;

/**
 * A DTO for the {@link com.thirdcc.webapp.entity.PurchaseRequestSubmissionItem} entity.
 */
@Data
public class PurchaseRequestSubmissionItemDto {

    private Long id;

    private Long requestSubmissionId;

    private String componentCode;

    private String componentName;

    private String vendorId;

    private String vendorName;

    private Double stockBalance;

    private Double packagingSize;

    private Double noOfPacks;

    private Double quantity;
    
    private Date deliveryDate;

}
