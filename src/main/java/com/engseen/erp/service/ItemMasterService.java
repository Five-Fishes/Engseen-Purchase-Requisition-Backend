package com.engseen.erp.service;

import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.service.dto.ItemMasterDTO;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ItemMasterService {
    List<ItemMasterDTO> findAll(Pageable pageable, String item);

    ItemMaster checkAndUpdateUnitPrice(String componentCode, BigDecimal unitCost);
    
    ItemMaster updateItemMaster(ItemMaster itemMaster);
}
