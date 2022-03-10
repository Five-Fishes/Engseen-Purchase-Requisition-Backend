package com.engseen.erp.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.engseen.erp.domain.PODetail;
import com.engseen.erp.domain.POHeader;
import com.engseen.erp.repository.PODetailRepository;
import com.engseen.erp.repository.POHeaderRepository;
import com.engseen.erp.service.PurchaseOrderItemService;
import com.engseen.erp.service.VendorService;
import com.engseen.erp.service.dto.PurchaseOrderItemDto;
import com.engseen.erp.service.dto.VendorMasterDTO;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.PODetail}.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService {

    private final PODetailRepository poDetailRepository;
    private final POHeaderRepository poHeaderRepository;
    private final VendorService vendorService;

    private Map<String, VendorMasterDTO> vendorTemporaryCache = new HashMap<>();

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderItemDto> findAllOutstandingPurchaseOrderItem(Pageable pageable) {
        log.debug("Request to findAll Outstanding Purchase Order Item");
        return poDetailRepository.findAllOutstandingItem(pageable)
            .map(this::constructPurchaseOrderItemDto)
            .getContent();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderItemDto> findAllOutstandingPurchaseOrderItemByVendorId(Pageable pageable, String vendorId) {
        log.debug("Request to findAll Outstanding Purchase Order Item by Vendor Id: {}", vendorId);
        List<String> poNumberList = poHeaderRepository.findAllByVendorID(Pageable.unpaged(), vendorId)
            .map(POHeader::getPoNumber)
            .getContent();
        log.debug("{} total number of PO for VendorId: {}", poNumberList.size(), vendorId);
        log.debug("PO Number List: {}", poNumberList);
        return poDetailRepository.findAllOutstandingItemInPoNumberList(pageable, poNumberList)
            .map(this::constructPurchaseOrderItemDto)
            .getContent();
    }

    private PurchaseOrderItemDto constructPurchaseOrderItemDto(PODetail poDetail) {
        log.debug("Request to constructPurchaseOrderItemDto");
        log.debug("PO Detail: {}", poDetail);
        // TODO: complete construct of PO Item Dto
        PurchaseOrderItemDto purchaseOrderItemDto = new PurchaseOrderItemDto();
        purchaseOrderItemDto.setId(Long.valueOf(poDetail.getId()));
        purchaseOrderItemDto.setPoNumber(poDetail.getPoNumber());
        purchaseOrderItemDto.setRemarks(poDetail.getRemark());
        purchaseOrderItemDto.setDeliveryDate(Date.from(poDetail.getEtaDate()));
        purchaseOrderItemDto.setOrderQuantityPack(poDetail.getOrderQuantity());
        // purchaseOrderItemDto.setOrderQuantity(poDetail.getOrderQuantity());
        purchaseOrderItemDto.setReceivedQuantityPack(poDetail.getQuantityReceived());
        // purchaseOrderItemDto.setReceivedQuantity(poDetail.getQuantityReceived());
        BigDecimal oustandingQuantity = poDetail.getOrderQuantity().subtract(poDetail.getQuantityReceived());
        purchaseOrderItemDto.setOpenQuantityPack(oustandingQuantity);
        // purchaseOrderItemDto.setOpenQuantityPack(oustandingQuantity);
        purchaseOrderItemDto.setReceivingQuantityPack(oustandingQuantity);
        // purchaseOrderItemDto.setReceivingQuantity(oustandingQuantity);
        // TODO: TBC Issued Quantity
        // purchaseOrderItemDto.setUom(poDetail.getVIUnitOfMeasure());
        // purchaseOrderItemDto.setUomPack(poDetail.getVIUnitOfMeasure());
        String[] itemStrings = poDetail.getItem().split(" - ");
        purchaseOrderItemDto.setComponentCode(itemStrings[0]);
        if (itemStrings.length > 1) {
            purchaseOrderItemDto.setComponentName(itemStrings[1]);
        }
        mapVendorInfo(purchaseOrderItemDto, poDetail.getPoNumber());
        return purchaseOrderItemDto;
    }

    private void mapVendorInfo(PurchaseOrderItemDto purchaseOrderItemDto, String poNumber) {
        VendorMasterDTO vendorMasterDTO = vendorTemporaryCache.get(poNumber);
        if (vendorMasterDTO == null) {
            POHeader poHeader = poHeaderRepository.findOneByPoNumber(poNumber);
            vendorMasterDTO = vendorService.findOneByVendorId(poHeader.getVendorID());
            vendorTemporaryCache.put(poNumber, vendorMasterDTO);
        }
        purchaseOrderItemDto.setVendorId(vendorMasterDTO.getVendorID());
        purchaseOrderItemDto.setVendorName(vendorMasterDTO.getVendorName());
    }
    
}
