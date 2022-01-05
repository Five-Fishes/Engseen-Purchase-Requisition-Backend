package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * A DTO for the {@link com.engseen.erp.entity.PurchaseOrder} entity.
 */
@Data
public class PurchaseOrderRequestApprovalDto implements Serializable {

    private Long purchaseRequisitionApprovalId;

    private List<PurchaseOrderDto> purchaseOrderDtoList;

}
