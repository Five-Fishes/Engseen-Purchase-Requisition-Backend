package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.POReceiptHeader;
import com.engseen.erp.service.dto.POReceiptHeaderDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface POReceiptHeaderMapper extends EntityMapper<POReceiptHeaderDTO, POReceiptHeader> {
    
    @Mappings({
        @Mapping(target = "poReceiptDtoList", ignore = true),
        @Mapping(target = "doNumber", ignore = true),
        @Mapping(target = "invoiceNumber", ignore = true),
        @Mapping(target = "startGrnDate", ignore = true),
        @Mapping(target = "endGrnDate", ignore = true)
    })
    @Override
    POReceiptHeaderDTO toDto(POReceiptHeader entity);
}
