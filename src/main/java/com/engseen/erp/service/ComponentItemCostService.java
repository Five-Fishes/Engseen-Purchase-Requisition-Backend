package com.engseen.erp.service;

import com.engseen.erp.service.dto.ComponentDTO;
import org.springframework.data.domain.Pageable;
import java.util.List;

import com.engseen.erp.service.dto.ComponentItemCostDTO;

/**
 * Service Interface for managing {@link com.engseen.erp.domain.VendorItem}.
 */
public interface ComponentItemCostService {

    /**
     * Get all ComponentCostItem
     * @param pageable the pagination information
     * @param components the Component Object to look for
     * @return the list of ComponentItemCost
     */
    List<ComponentItemCostDTO> findAll(Pageable pageable, List<ComponentDTO> components );

}
