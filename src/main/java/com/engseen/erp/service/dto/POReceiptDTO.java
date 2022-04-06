package com.engseen.erp.service.dto;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.Data;

/**
 * A general DTO for the PO Receipt
 */
@Data
public class POReceiptDTO {

    private Integer id;
    private String grnNo;
    private Integer pid;
    private BigDecimal quantityReceived;
    private BigDecimal quantityReversed;
    private BigDecimal unitCost;
    private BigDecimal origUnitCost;
    private Character inspectionCode;
    private Integer iid;
    private String storeNo;
    private String storeBin;
    private Character inventoryCode;
    private String lotNo;
    private Integer irid;
    private Instant created;
    private String createdBy;

    private String componentCode;
    private BigDecimal receivingQuantity;
    private BigDecimal receivingQuantityPack;

}
