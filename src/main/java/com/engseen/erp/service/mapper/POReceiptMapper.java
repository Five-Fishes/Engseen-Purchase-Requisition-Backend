package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.POReceipt;
import com.engseen.erp.service.dto.POReceiptDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface POReceiptMapper extends EntityMapper<POReceiptDTO, POReceipt> {
}
