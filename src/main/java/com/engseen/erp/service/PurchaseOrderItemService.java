package com.engseen.erp.service;

import java.util.List;

import com.engseen.erp.service.dto.PurchaseOrderItemDto;

import org.springframework.data.domain.Pageable;

public interface PurchaseOrderItemService {

	List<PurchaseOrderItemDto> findAllOutstandingPurchaseOrderItem(Pageable pageable);

	List<PurchaseOrderItemDto> findAllOutstandingPurchaseOrderItemByVendorId(Pageable pageable, String vendorId);

}
