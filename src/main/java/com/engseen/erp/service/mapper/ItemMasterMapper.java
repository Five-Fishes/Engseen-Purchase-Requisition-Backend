package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ItemMasterDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ItemMasterMapper extends EntityMapper<ItemMasterDTO, ItemMaster> {

    @Mappings({
        @Mapping(target = "id", source = "source.id"),
        @Mapping(target = "componentCode", source = "source.item"),
        @Mapping(target = "componentName", source = "source.itemDescription"),
        @Mapping(target = "vendorId", source = "source.vendorID"),
        @Mapping(target = "vendorName", source = "source.vendorName")
    })
    ComponentDTO itemMasterToComponentDTO(ItemMaster source);
}
