package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.PurchaseRequisitionTemplate;
import com.engseen.erp.service.dto.PurchaseRequisitionTemplateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseRequisitionTemplateMapper extends EntityMapper<PurchaseRequisitionTemplateDTO, PurchaseRequisitionTemplate> {
}
