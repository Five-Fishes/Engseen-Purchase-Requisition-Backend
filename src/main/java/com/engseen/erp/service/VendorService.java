package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentVendorDTO;
import com.engseen.erp.service.dto.VendorMasterDTO;

import org.springframework.data.domain.Pageable;

public interface VendorService {
    /**
     * Get all ComponentCostItem
     * @param pageable the pagination information
     * @param components the Component Object to look for
     * @return the list of ComponentItemCost
     */
    List<ComponentVendorDTO> findAll(Pageable pageable, List<ComponentDTO> components );

    /**
     * Get all ComponentCostItem
     * @param pageable the pagination information
     * @param vendorId vendorId to perform search
     * @return the list of ComponentItemCost
     */
    List<VendorMasterDTO> findAll(Pageable pageable, String vendorId );

    /**
     * Get Vendor based on vendorId
     * @param vendorId the vendorId of Vendor to retrieve
     * @return the vendorMasterDTO
     */
    VendorMasterDTO findOneByVendorId(String vendorId);

    /**
     * Get VendorItem based on vendorId and Item
     * @param vendorId the vendorId of Vendor Item to retrieve
     * @param item the item of Vendor Item to retrieve
     * @return the VendorItem
     */
    VendorItem findOneVendorItemByVendorAndItem(String vendorId, String item);
}
