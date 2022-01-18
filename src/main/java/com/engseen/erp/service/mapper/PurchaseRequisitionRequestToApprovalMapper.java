package com.engseen.erp.service.mapper;

import com.engseen.erp.domain.PurchaseRequisitionApproval;
import com.engseen.erp.domain.PurchaseRequisitionApprovalItem;
import com.engseen.erp.domain.PurchaseRequisitionRequest;
import com.engseen.erp.domain.PurchaseRequisitionRequestItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseRequisitionRequestToApprovalMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchaseRequisitionApprovalItems", ignore = true)
    PurchaseRequisitionApproval toApproval(PurchaseRequisitionRequest purchaseRequisitionRequest);

    @Mapping(target = "purchaseRequisitionApproval", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "itemCost", ignore = true)
    @Mapping(target = "balance", ignore = true)
    List<PurchaseRequisitionApprovalItem> toApprovalItem(List<PurchaseRequisitionRequestItem> purchaseRequisitionRequestItem);
}
