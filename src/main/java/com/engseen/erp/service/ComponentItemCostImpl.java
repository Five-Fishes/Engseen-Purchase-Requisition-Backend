package com.engseen.erp.service;

import org.springframework.data.domain.Pageable;
import java.util.List;

import com.engseen.erp.service.dto.ComponentItemCostDto;

public interface ComponentItemCostImpl {

    /**
     * Get all ComponentCostItem
     * @param pageable the pagination information
     * @return the list of ComponentItemCost
     */
    List<ComponentItemCostDto> findAll(Pageable pageable);

}
