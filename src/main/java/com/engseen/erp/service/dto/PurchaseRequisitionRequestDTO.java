package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * A DTO for the {@link com.engseen.erp.domain.PurchaseRequisitionRequest} entity.
 */
@Data
public class PurchaseRequisitionRequestDTO implements Serializable {

    private Long id;

    private Long templateId;

    private String remarks;

    private List<PurchaseRequisitionRequestItemDTO> purchaseRequisitionRequestItems;

    private Date createdDate;

}
