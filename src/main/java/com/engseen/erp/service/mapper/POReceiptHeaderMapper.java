package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.POReceiptHeader;
import com.engseen.erp.service.dto.POReceiptHeaderDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface POReceiptHeaderMapper extends EntityMapper<POReceiptHeaderDTO, POReceiptHeader> {
    
}
