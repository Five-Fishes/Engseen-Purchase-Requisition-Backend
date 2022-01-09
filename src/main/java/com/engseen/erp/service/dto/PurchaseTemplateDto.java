package com.engseen.erp.service.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * A DTO for the {@link com.engseen.erp.entity.PurchaseTemplate} entity.
 */
@Data
public class PurchaseTemplateDto implements Serializable {

    private Long id;

    private String templateName;

    private List<PurchaseTemplateItemDto> templateItems;
    
}
