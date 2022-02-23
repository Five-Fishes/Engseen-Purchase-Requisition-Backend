package com.engseen.erp.service;

import com.engseen.erp.service.dto.ComponentBulkSearchDTO;
import com.engseen.erp.service.dto.ComponentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service Interface for managing {@link com.engseen.erp.domain.VendorItem}.
 */
public interface ComponentService {

    /**
     * Get all Component by search filters
     * @param pageable the pagination information
     * @return the list of entities
     */
    List<ComponentDTO> findAll(Pageable pageable, String component, String vendor, Integer packingSize);

    /**
     * Get all Component by search filters in bulk
     * @return the list of entities
     */
    List<ComponentDTO> bulkFindAll(List<ComponentBulkSearchDTO> componentBulkSearchDTOList);

}
