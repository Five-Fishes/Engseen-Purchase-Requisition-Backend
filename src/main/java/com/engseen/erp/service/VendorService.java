package com.engseen.erp.service;

import com.engseen.erp.service.dto.ComponentDto;
import com.engseen.erp.service.dto.ComponentVendorDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VendorService {
    /**
     * Get all ComponentCostItem
     * @param pageable the pagination information
     * @param components the Component Object to look for
     * @return the list of ComponentItemCost
     */
    List<ComponentVendorDto> findAll(Pageable pageable, List<ComponentDto> components );
}
