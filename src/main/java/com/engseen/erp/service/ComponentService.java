package com.engseen.erp.service;

import com.engseen.erp.service.dto.ComponentBulkSearchDTO;
import com.engseen.erp.service.dto.ComponentDTO;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service Interface for managing {@link com.engseen.erp.domain.VendorItem}.
 */
public interface ComponentService {

    /**
     * Get all Component by search filters
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    List<ComponentDTO> findAll(Pageable pageable, String component, String vendor, Integer packingSize);

    /**
     * Get all Component by search filters in bulk
     *
     * @return the list of entities
     */
    List<ComponentDTO> bulkFindAll(List<ComponentBulkSearchDTO> componentBulkSearchDTOList);

    /**
     * Get stock balance of component using componentCode
     *
     * @param componentCode Item in db
     * @return stock balance
     */
    BigDecimal getStockBalanceByComponentCode(String componentCode);

    /**
     * Find All components based on component keyword and vendorId
     * 
     * @param pageable
     * @param component
     * @param vendorId
     * @return list of components DTO
     */
	List<ComponentDTO> findAllByComponentAndVendor(Pageable pageable, String component, String vendorId);

    /**
     * Find All components based on component keyword or vendor keyword
     * 
     * @param pageable
     * @param component
     * @param vendor
     * @return list of components DTO
     */
    List<ComponentDTO> findAllByComponentOrVendor(Pageable pageable, String component, String vendor);
}
