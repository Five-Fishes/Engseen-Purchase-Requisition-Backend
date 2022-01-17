package com.engseen.erp.service;

import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentStockDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockService {
    /**
     * Get all ComponentCostItem
     * @param pageable the pagination information
     * @param components the Component Object to look for
     * @return the list of ComponentItemCost
     */
    List<ComponentStockDTO> findAll(Pageable pageable, List<ComponentDTO> components );
}

