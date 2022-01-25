package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentItemCostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface VendorItemMapper {

    @Mappings({
            @Mapping(target = "id", source = "source.id"),
            @Mapping(target = "componentCode", ignore = true), // Need to retrieve from ItemMaster
            @Mapping(target = "componentName", source = "source.item"),
            @Mapping(target = "vendorId", source = "source.vendorID"),
            @Mapping(target = "vendorName", ignore = true), // Need to retrieve from VendorMaster
            @Mapping(target = "packagingSize", source = "source.viConversion")
    })
    ComponentDTO vendorItemToComponentDTO(VendorItem source);

    @Mappings({
            @Mapping(target = "id", source = "source.id"),
            @Mapping(target = "componentCode", ignore = true), // Need to retrieve from ItemMaster
            @Mapping(target = "vendorId", source = "source.vendorID"),
            @Mapping(target = "packagingSize", source = "source.viConversion"),
            @Mapping(target = "itemCost", source = "source.vIUnitPrice")
    })
    ComponentItemCostDTO vendorItemToComponentItemCostDTO(VendorItem source);
}