package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.service.dto.ItemMasterDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMasterMapper extends EntityMapper<ItemMasterDTO, ItemMaster> {
}
