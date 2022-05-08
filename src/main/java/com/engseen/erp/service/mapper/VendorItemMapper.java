package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentItemCostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface VendorItemMapper {

    // TODO: [LU] Please enhance the mapper, differentiate: Id, ComponentCode, ComponentName Correctly (While creating template should use ComponentName as it is the FK for other tables)
    @Mappings({
            @Mapping(target = "id", source = "source.id"),
            @Mapping(target = "componentCode", source = "source.item"),
            @Mapping(target = "componentName", source = "source.viDescription"),
            @Mapping(target = "vendorId", source = "source.vendorID"),
            @Mapping(target = "vendorName", ignore = true), // Need to retrieve from VendorMaster
            @Mapping(target = "packagingSize", ignore = true)
    })
    ComponentDTO vendorItemToComponentDTO(VendorItem source);

    @Mappings({
            @Mapping(target = "id", source = "source.id"),
            @Mapping(target = "componentCode", ignore = true), // Need to retrieve from ItemMaster
            @Mapping(target = "vendorId", source = "source.vendorID"),
            @Mapping(target = "packagingSize", ignore = true),
            @Mapping(target = "itemCost", source = "source.viUnitPrice")
    })
    ComponentItemCostDTO vendorItemToComponentItemCostDTO(VendorItem source);
}