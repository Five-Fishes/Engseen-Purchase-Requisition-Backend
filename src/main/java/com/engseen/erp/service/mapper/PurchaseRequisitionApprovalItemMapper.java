package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.PurchaseRequisitionApprovalItem;
import com.engseen.erp.service.dto.PurchaseRequestApprovalItemDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseRequisitionApprovalItemMapper extends EntityMapper<PurchaseRequestApprovalItemDto, PurchaseRequisitionApprovalItem> {
}
