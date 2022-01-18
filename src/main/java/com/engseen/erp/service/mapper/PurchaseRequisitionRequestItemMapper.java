package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.PurchaseRequisitionRequestItem;
import com.engseen.erp.service.dto.PurchaseRequisitionRequestItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseRequisitionRequestItemMapper extends EntityMapper<PurchaseRequisitionRequestItemDTO, PurchaseRequisitionRequestItem> {

    @Mapping(target = "requestSubmissionId", source = "entity.purchaseRequisitionRequest.id")
    @Override
    PurchaseRequisitionRequestItemDTO toDto(PurchaseRequisitionRequestItem entity);
}
