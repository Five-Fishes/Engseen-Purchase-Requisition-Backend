package com.engseen.erp.service;

import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentVendorDTO;
import com.engseen.erp.service.dto.VendorMasterDTO;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VendorService {
    /**
     * Get all ComponentCostItem
     * @param pageable the pagination information
     * @param components the Component Object to look for
     * @return the list of ComponentItemCost
     */
    List<ComponentVendorDTO> findAll(Pageable pageable, List<ComponentDTO> components );

    /**
     * Get Vendor based on vendorId
     * @param vendorId the vendorId of Vendor to retrieve
     * @return the vendorMasterDTO
     */
    VendorMasterDTO findOneByVendorId(String vendorId);
}
