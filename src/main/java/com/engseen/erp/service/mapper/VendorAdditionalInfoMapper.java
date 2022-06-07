package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.VendorAdditionalInfo;
import com.engseen.erp.service.dto.VendorAdditionalInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendorAdditionalInfoMapper extends EntityMapper<VendorAdditionalInfoDTO, VendorAdditionalInfo>{
}
