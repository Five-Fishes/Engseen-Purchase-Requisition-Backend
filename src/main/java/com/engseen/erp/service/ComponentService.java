package com.engseen.erp.service;

import com.engseen.erp.service.dto.ComponentDto;
import com.engseen.erp.service.dto.ComponentItemCostDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service Interface for managing {@link com.engseen.erp.entity.Component}.
 */
public interface ComponentService {

    /**
     * Get all Component by search filters
     * @param component the component name
     * @param vendor the vendor name
     * @param packingSize the packing size
     * @param pageable the pagination information
     * @return the list of entities
     */
    List<ComponentDto> findAllByFilters(String component, String vendor, Integer packingSize,Pageable pageable);

}
