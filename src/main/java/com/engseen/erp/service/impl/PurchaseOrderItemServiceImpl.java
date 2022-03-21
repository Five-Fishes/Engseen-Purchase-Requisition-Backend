package com.engseen.erp.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.engseen.erp.constant.enumeration.POReceiptStatus;
import com.engseen.erp.domain.PODetail;
import com.engseen.erp.domain.POHeader;
import com.engseen.erp.repository.PODetailRepository;
import com.engseen.erp.repository.POHeaderRepository;
import com.engseen.erp.service.PurchaseOrderItemService;
import com.engseen.erp.service.PurchaseOrderReceiptService;
import com.engseen.erp.service.VendorService;
import com.engseen.erp.service.dto.POReceiptDTO;
import com.engseen.erp.service.dto.PurchaseOrderItemDto;
import com.engseen.erp.service.dto.VendorMasterDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.micrometer.core.instrument.util.StringUtils;
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
    private final PurchaseOrderReceiptService purchaseOrderReceiptService;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderItemDto> findAllOutstandingPurchaseOrderItemByVendorId(Pageable pageable, String vendorId) {
        log.debug("Request to findAll Outstanding Purchase Order Item by Vendor Id: {}", vendorId);
        Map<String, VendorMasterDTO> vendorTemporaryCache = new HashMap<>();
        Page<PODetail> poDetailPage;
        if (StringUtils.isBlank(vendorId)) {
            poDetailPage = poDetailRepository.findAllOutstandingItem(pageable);
        } else {
            List<String> poNumberList = poHeaderRepository.findAllByVendorID(Pageable.unpaged(), vendorId)
                .map(POHeader::getPoNumber)
                .getContent();
            log.debug("{} total number of PO for VendorId: {}", poNumberList.size(), vendorId);
            log.debug("PO Number List: {}", poNumberList);
            poDetailPage = poDetailRepository.findAllOutstandingItemInPoNumberList(pageable, poNumberList);
        }
        return poDetailPage.map(poDetail -> constructPurchaseOrderItemDto(poDetail, vendorTemporaryCache))
            .getContent();
    }

    private PurchaseOrderItemDto constructPurchaseOrderItemDto(PODetail poDetail, Map<String, VendorMasterDTO> vendorTemporaryCache) {
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
        purchaseOrderItemDto.setStatus(POReceiptStatus.PENDING.name());
        // purchaseOrderItemDto.setUom(poDetail.getVIUnitOfMeasure());
        // purchaseOrderItemDto.setUomPack(poDetail.getVIUnitOfMeasure());
        String[] itemStrings = poDetail.getItem().split(" - ");
        purchaseOrderItemDto.setComponentCode(itemStrings[0]);
        if (itemStrings.length > 1) {
            purchaseOrderItemDto.setComponentName(itemStrings[1]);
        }
        mapVendorInfo(purchaseOrderItemDto, poDetail.getPoNumber(), vendorTemporaryCache);
        return purchaseOrderItemDto;
    }

    private void mapVendorInfo(PurchaseOrderItemDto purchaseOrderItemDto, String poNumber, Map<String, VendorMasterDTO> vendorTemporaryCache) {
        VendorMasterDTO vendorMasterDTO = vendorTemporaryCache.get(poNumber);
        if (vendorMasterDTO == null) {
            POHeader poHeader = poHeaderRepository.findOneByPoNumber(poNumber);
            vendorMasterDTO = vendorService.findOneByVendorId(poHeader.getVendorID());
            vendorTemporaryCache.put(poNumber, vendorMasterDTO);
        }
        purchaseOrderItemDto.setVendorId(vendorMasterDTO.getVendorID());
        purchaseOrderItemDto.setVendorName(vendorMasterDTO.getVendorName());
    }

    @Override
    public List<PurchaseOrderItemDto> findAllReceivedPurchaseOrderItemByGrnNo(Pageable pageable, String grnNo) {
        log.debug("Request to findAll ReceivedPurchaseOrderItem ByGrnNo: {}", grnNo);
        List<PurchaseOrderItemDto> purchaseOrderItemDtoList = purchaseOrderReceiptService.findAllByGrnNo(pageable, grnNo)
            .parallelStream()
            .map(this::convertToPurchaseOrderItemDto)
            .collect(Collectors.toList());
        return purchaseOrderItemDtoList;
    }

    private PurchaseOrderItemDto convertToPurchaseOrderItemDto(POReceiptDTO poReceiptDto) {
        log.debug("Request to convertToPurchaseOrderItemDto");
        log.debug("PO Receipt DTO: {}", poReceiptDto);
        PurchaseOrderItemDto purchaseOrderItemDto = new PurchaseOrderItemDto();
        Map<String, VendorMasterDTO> vendorTemporaryCache = new HashMap<>();
        Optional<PODetail> poDetail = poDetailRepository.findById(poReceiptDto.getPid());
        if (poDetail.isPresent()) {
            log.debug("PO Detail: {}", poDetail.get());
            purchaseOrderItemDto = constructPurchaseOrderItemDto(poDetail.get(), vendorTemporaryCache);
            log.debug("Constructed Purchase Order Item Dto: {}", purchaseOrderItemDto);
            BigDecimal oustandingQuantity = purchaseOrderItemDto.getOrderQuantityPack().subtract(poReceiptDto.getQuantityReceived());
            purchaseOrderItemDto.setOpenQuantityPack(oustandingQuantity);
            // purchaseOrderItemDto.setOpenQuantityPack(oustandingQuantity);
        }
        purchaseOrderItemDto.setItemCost(poReceiptDto.getUnitCost().doubleValue());
        purchaseOrderItemDto.setReceivedQuantityPack(poReceiptDto.getQuantityReceived());
        // purchaseOrderItemDto.setReceivedQuantity(poReceiptDto.getQuantityReceived());
        purchaseOrderItemDto.setReceivingQuantityPack(BigDecimal.ZERO);
        purchaseOrderItemDto.setReceivingQuantity(BigDecimal.ZERO);
        purchaseOrderItemDto.setStatus(POReceiptStatus.RECEIVED.name());
        return purchaseOrderItemDto;
    }
    
}
