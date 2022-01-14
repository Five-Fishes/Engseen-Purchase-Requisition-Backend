package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import com.engseen.erp.service.dto.PurchaseRequisitionTemplateItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseRequisitionTemplateItemMapper extends EntityMapper<PurchaseRequisitionTemplateItemDTO, PurchaseRequisitionTemplateItem> {
}
