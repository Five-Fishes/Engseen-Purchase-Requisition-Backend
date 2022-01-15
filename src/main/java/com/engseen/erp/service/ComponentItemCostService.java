package com.engseen.erp.service;

import com.engseen.erp.service.dto.ComponentDto;
import org.springframework.data.domain.Pageable;
import java.util.List;

import com.engseen.erp.service.dto.ComponentItemCostDto;

/**
 * Service Interface for managing {@link com.engseen.erp.entity.ComponentItemCost}.
 */
public interface ComponentItemCostService {

    /**
     * Get all ComponentCostItem
     * @param pageable the pagination information
     * @param components the Component Object to look for
     * @return the list of ComponentItemCost
     */
    List<ComponentItemCostDto> findAll(Pageable pageable, List<ComponentDto> components );

}
