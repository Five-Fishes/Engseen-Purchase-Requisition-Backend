package com.engseen.erp.service.dto;

import lombok.Data;

/**
 * A general DTO for the Inventory Pack {@link com.engseen.erp.domain.InventoryPack}
 */
@Data
public class InventoryPackDTO {
    
    private Integer id;

    private String item;

    private String storeNo;

    private String storeBin;

    private Integer pack;
}
