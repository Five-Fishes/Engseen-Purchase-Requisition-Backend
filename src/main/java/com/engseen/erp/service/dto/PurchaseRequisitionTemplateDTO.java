package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * A DTO for the {@link com.engseen.erp.domain.PurchaseRequisitionTemplate} entity.
 */
@Data
public class PurchaseRequisitionTemplateDTO implements Serializable {

    private Long id;

    private String templateName;

    private List<PurchaseRequisitionTemplateItemDTO> templateItems;
    
}
