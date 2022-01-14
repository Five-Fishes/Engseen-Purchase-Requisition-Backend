package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.PurchaseRequisitionApproval;
import com.engseen.erp.service.dto.PurchaseRequestApprovalDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseRequisitionApprovalMapper extends EntityMapper<PurchaseRequestApprovalDto, PurchaseRequisitionApproval> {
}
