package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.VendorMaster;
import com.engseen.erp.service.dto.VendorMasterDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendorMasterMapper extends EntityMapper<VendorMasterDTO, VendorMaster> {
    
}
