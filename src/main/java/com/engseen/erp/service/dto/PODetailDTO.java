package com.engseen.erp.service.dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.Data;

/**
 * A general DTO for the PO Detail
 */
@Data
public class PODetailDTO {
    
    private Integer id;

    private String poNumber;

    private Integer lineNumber;

    private String item;

    private Character lineType;

    private Character lineSelector;

    private BigDecimal orderQuantity;

    private BigDecimal quantityReceived;

    private BigDecimal quantityInInspection;

    private BigDecimal quantityOnHand;

    private BigDecimal quantityOnHold;

    private BigDecimal blanketQuantity;

    private Instant etaDate;

    private Instant needDate;

    private Instant dateLastReceipt;

    private Integer leadTime;

    private Integer discount;
    
    private Character lineStatus;
    
    private BigDecimal unitPrice;
    
    private BigDecimal extendedPrice;
    
    private String remark;
    
    private String vendorItem;
    
    private String vIDescription;
    
    private BigDecimal vIConversion;
    
    private String vIUnitOfMeasure;
    
    private BigDecimal vIOrderQuantity;
    
    private BigDecimal vIUnitPrice;
    
    private String itemFailure;
    
    private String printUOM;
    
    private String departmentCode;
    
    private String segmentCode;
    
    private Instant created;
    
    private String createdBy;
    
    private Instant modified;
    
    private String modifiedBy;
    
    private Integer packReceived;

    private Integer pack;

    private String itemDescription;
}
