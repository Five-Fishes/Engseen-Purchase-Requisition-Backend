package com.engseen.erp.service.dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.Data;

/**
 * A general DTO for the Inventory Receipt {@link com.engseen.erp.domain.InventoryReceipt}
 */
@Data
public class InventoryReceiptDTO {
    
    private Integer id;

    private String irnNo;

    private String item;

    private String storeNo;

    private String storeBin;

    private BigDecimal receiptQuantity;

    private BigDecimal weight;

    private Integer iid;

    private Instant created;

    private String createdBy;
}
