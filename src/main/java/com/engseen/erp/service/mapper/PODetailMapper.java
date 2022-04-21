package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.PODetail;
import com.engseen.erp.service.dto.PODetailDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PODetailMapper extends EntityMapper<PODetailDTO, PODetail> {
}
