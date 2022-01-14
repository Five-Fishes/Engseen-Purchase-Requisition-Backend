package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.PurchaseRequisitionRequest;
import com.engseen.erp.service.dto.PurchaseRequisitionRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseRequisitionRequestMapper extends EntityMapper<PurchaseRequisitionRequestDTO, PurchaseRequisitionRequest> {
}
