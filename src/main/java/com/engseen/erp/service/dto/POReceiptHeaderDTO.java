package com.engseen.erp.service.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * A general DTO for the PO Receipt Header
 */
@Data
public class POReceiptHeaderDTO {

    private Integer id;
    private String grnNo;
    private Instant grnDate;
    private Character status;
    private String vendorID;
    private BigDecimal exchangeRate;
    private String transportVia;
    private String freightBillNumber;
    private String packingListNumber;
    private String grnReference;
    private BigDecimal discountAmount;
    private String remark;
    private Character grnType;
    private BigDecimal invoiceAmount;
    private Character hold;
    private Character paid;
    private Character posted;
    private Instant created;
    private String createdBy;
    private Instant modified;
    private String modifiedBy;
    private Instant accessed;
    private String accessedBy;
    private Instant customFormDate;
    private BigDecimal cifValue;
    private String customFormNo;

    private List<POReceiptDTO> poReceiptDtoList;

    private String doNumber;
    private String invoiceNumber;

    private Instant startGrnDate;    
    private Instant endGrnDate;

}
