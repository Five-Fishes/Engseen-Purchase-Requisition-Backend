package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.InventoryPack;
import com.engseen.erp.service.dto.InventoryPackDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryPackMapper extends EntityMapper<InventoryPackDTO, InventoryPack>  {
    
}
