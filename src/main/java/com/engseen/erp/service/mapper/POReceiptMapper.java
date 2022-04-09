package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.POReceipt;
import com.engseen.erp.service.dto.POReceiptDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface POReceiptMapper extends EntityMapper<POReceiptDTO, POReceipt> {

    @Mappings({
        @Mapping(target = "componentCode", ignore = true),
        @Mapping(target = "receivingQuantity", ignore = true),
        @Mapping(target = "receivingQuantityPack", ignore = true)
    })
    @Override
    POReceiptDTO toDto(POReceipt entity);
}
