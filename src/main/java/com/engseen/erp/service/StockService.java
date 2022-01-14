package com.engseen.erp.service;

import com.engseen.erp.service.dto.ComponentDto;
import com.engseen.erp.service.dto.ComponentStockDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StockService {
    /**
     * Get all ComponentCostItem
     * @param pageable the pagination information
     * @param components the Component Object to look for
     * @return the list of ComponentItemCost
     */
    List<ComponentStockDto> findAll(Pageable pageable, List<ComponentDto> components );
}

