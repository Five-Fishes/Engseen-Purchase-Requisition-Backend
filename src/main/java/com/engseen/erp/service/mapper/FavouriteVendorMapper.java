package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.FavouriteVendor;
import com.engseen.erp.service.dto.FavouriteVendorDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FavouriteVendorMapper extends EntityMapper<FavouriteVendorDTO, FavouriteVendor> {
}
