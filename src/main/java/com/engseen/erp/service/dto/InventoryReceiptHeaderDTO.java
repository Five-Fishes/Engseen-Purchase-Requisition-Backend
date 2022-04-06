package com.engseen.erp.service.dto;

import java.time.Instant;

import lombok.Data;

/**
 * A general DTO for the Inventory Receipt Header {@link com.engseen.erp.domain.InventoryReceiptHeader}
 * 
 * Unused at POR phase
 */
@Deprecated
@Data
public class InventoryReceiptHeaderDTO {
    
    private Integer id;

    private String irnNo;

    private Instant irnDate;

    private String CustomerID;

    private String doNumber;

    private String remark;

    private Instant created;

    private String createdBy;

    private Instant modified;

    private String modifiedBy;

    private Instant accessed;

    private String accessedBy;
}
