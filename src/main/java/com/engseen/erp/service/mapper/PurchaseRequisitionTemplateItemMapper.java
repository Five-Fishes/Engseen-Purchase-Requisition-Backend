package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import com.engseen.erp.service.dto.PurchaseRequisitionTemplateItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseRequisitionTemplateItemMapper extends EntityMapper<PurchaseRequisitionTemplateItemDTO, PurchaseRequisitionTemplateItem> {

    @Mappings(
            {
                    @Mapping(target = "templateId", source = "entity.purchaseRequisitionTemplate.id"),
                    @Mapping(target = "quantity", ignore = true),
                    @Mapping(target = "deliveryDate", ignore = true)
            }
    )
    @Override
    PurchaseRequisitionTemplateItemDTO toDto(PurchaseRequisitionTemplateItem entity);
}
