package com.engseen.erp.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import com.engseen.erp.constant.enumeration.POReceiptStatus;
import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.domain.PODetail;
import com.engseen.erp.domain.POHeader;
import com.engseen.erp.exception.BadRequestException;
import com.engseen.erp.repository.PODetailRepository;
import com.engseen.erp.repository.POHeaderRepository;
import com.engseen.erp.service.*;
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
    private final PODetailService poDetailService;
    private final VendorService vendorService;
    private final ItemMasterService itemMasterService;
    private final PurchaseOrderReceiptService purchaseOrderReceiptService;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseOrderItemDto> findAllOutstandingPurchaseOrderItemByVendorId(Pageable pageable, String vendorId) {
        log.debug("Request to findAll Outstanding Purchase Order Item by Vendor Id: {}", vendorId);
        Page<PODetail> poDetailPage;
        if (StringUtils.isBlank(vendorId)) {
            poDetailPage = poDetailRepository.findAllOutstandingItem(pageable);
        } else {
            List<String> poNumberList = poHeaderRepository.findAllByVendorID(pageable, vendorId)
                    .map(POHeader::getPoNumber)
                    .getContent();
            log.debug("{} total number of PO for VendorId: {}", poNumberList.size(), vendorId);
            log.debug("PO Number List: {}", poNumberList);
            poDetailPage = poDetailRepository.findAllOutstandingItemInPoNumberList(pageable, poNumberList);
        }
        /* Compute Vendor Details */
        Map<String, VendorMasterDTO> vendorTemporaryCache = getVendorsRelatedToPO(poDetailPage.getContent());

        return poDetailPage
                .map(poDetail -> constructPurchaseOrderItemDto(poDetail, vendorTemporaryCache))
                .getContent();
    }

    private Map<String, VendorMasterDTO> getVendorsRelatedToPO(List<PODetail> poDetailList) {
        Map<String, VendorMasterDTO> vendorTemporaryCache = new HashMap<>();

        poDetailList.forEach(poDetail -> vendorTemporaryCache.computeIfAbsent(poDetail.getPoNumber(), pn -> {
            POHeader poHeader = poHeaderRepository.findByPoNumber(pn).get(0);
            return vendorService.findOneByVendorId(poHeader.getVendorID());
        }));

        return vendorTemporaryCache;
    }

    private PurchaseOrderItemDto constructPurchaseOrderItemDto(PODetail poDetail, Map<String, VendorMasterDTO> vendorTemporaryCache) {
        log.debug("Request to constructPurchaseOrderItemDto");
        log.debug("PO Detail: {}", poDetail);
        PurchaseOrderItemDto purchaseOrderItemDto = new PurchaseOrderItemDto();
        purchaseOrderItemDto.setId(Long.valueOf(poDetail.getId()));
        purchaseOrderItemDto.setPoNumber(poDetail.getPoNumber());
        purchaseOrderItemDto.setRemarks(poDetail.getRemark());
        purchaseOrderItemDto.setDeliveryDate(Date.from(poDetail.getEtaDate()));

        purchaseOrderItemDto.setOrderQuantityPack(poDetail.getOrderQuantity());
        purchaseOrderItemDto.setOrderQuantity(poDetail.getOrderQuantity().multiply(Objects.nonNull(poDetail.getVIConversion()) ? poDetail.getVIConversion() : BigDecimal.ONE));

        purchaseOrderItemDto.setReceivedQuantityPack(BigDecimal.valueOf(Optional.ofNullable(poDetail.getPackReceived()).orElse(0)));
        purchaseOrderItemDto.setReceivedQuantity(poDetail.getQuantityReceived());

        BigDecimal outstandingQuantity = poDetail.getOrderQuantity().subtract(poDetail.getQuantityReceived());
        BigDecimal outstandingQuantityPack = BigDecimal.valueOf(Optional.ofNullable(poDetail.getPack()).orElse(0)).subtract(BigDecimal.valueOf(Optional.ofNullable(poDetail.getPackReceived()).orElse(0)));

        purchaseOrderItemDto.setOpenQuantityPack(outstandingQuantity);
        purchaseOrderItemDto.setOpenQuantity(outstandingQuantity);

        // Set the receiving quantity and unit to default automatically for easier UX
        purchaseOrderItemDto.setReceivingQuantityPack(outstandingQuantityPack);
        purchaseOrderItemDto.setReceivingQuantity(outstandingQuantity);

        purchaseOrderItemDto.setStatus(POReceiptStatus.PENDING.name());
        purchaseOrderItemDto.setComponentCode(getComponentCodeFromItem(poDetail.getItem()));
        purchaseOrderItemDto.setComponentName(getComponentNameFromItem(poDetail.getItem()));
        purchaseOrderItemDto.setItemCost(Optional.ofNullable(poDetail.getVIUnitPrice()).orElse(BigDecimal.ZERO).doubleValue());

        mapVendorInfo(purchaseOrderItemDto, vendorTemporaryCache);
        return purchaseOrderItemDto;
    }

    private String getComponentNameFromItem(String item) {
        /*
        Check for Item field
        - New style: itemCode - itemName
        - Old style: itemCode
         */
        if (item.contains("-")) {
            return item.split("-")[1].trim();
        }

        ItemMaster itemMaster = itemMasterService.findOneByItem(item);
        return Objects.nonNull(itemMaster) ? itemMaster.getItemDescription() : "Item with code " + item + "not found in DB";
    }

    private String getComponentCodeFromItem(String item) {
        /*
        Check for Item field
        - New style: itemCode - itemName
        - Old style: itemCode
         */
        if (item.contains("-")) {
            return item.split("-")[0].trim();
        }

        return item;
    }

    private void mapVendorInfo(PurchaseOrderItemDto purchaseOrderItemDto, Map<String, VendorMasterDTO> vendorTemporaryCache) {
        VendorMasterDTO vendorMasterDTO = vendorTemporaryCache.get(purchaseOrderItemDto.getPoNumber());

        /*
        Special Handling for null vendorMasterDTO
        - We encountered case where the VendorID in poHeader does not exist in VendorMaster
        - This will use the ID provided in purchaseOrderItemDto but assign vendor name with error message
         */
        if (Objects.isNull(vendorMasterDTO)) {
            purchaseOrderItemDto.setVendorId(purchaseOrderItemDto.getVendorId());
            purchaseOrderItemDto.setVendorName("This vendor does not exist in DB, please check");
        } else {
            purchaseOrderItemDto.setVendorId(vendorMasterDTO.getVendorID());
            purchaseOrderItemDto.setVendorName(vendorMasterDTO.getVendorName());
        }
    }

    @Override
    public List<PurchaseOrderItemDto> findAllReceivedPurchaseOrderItemByGrnNo(Pageable pageable, String grnNo) {
        log.debug("Request to findAll ReceivedPurchaseOrderItem ByGrnNo: {}", grnNo);
        return purchaseOrderReceiptService.findAllByGrnNo(pageable, grnNo)
                .parallelStream()
                .map(this::convertToPurchaseOrderItemDto)
                .collect(Collectors.toList());
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
            BigDecimal outstandingQuantity = purchaseOrderItemDto.getOrderQuantityPack().subtract(poReceiptDto.getQuantityReceived());
            purchaseOrderItemDto.setOpenQuantityPack(outstandingQuantity);
        }
        purchaseOrderItemDto.setItemCost(poReceiptDto.getUnitCost().doubleValue());
        purchaseOrderItemDto.setReceivedQuantityPack(BigDecimal.valueOf(Optional.ofNullable(poReceiptDto.getPackReceived()).orElse(0)));
        purchaseOrderItemDto.setReceivedQuantity(Optional.ofNullable(poReceiptDto.getQuantityReceived()).orElse(BigDecimal.ZERO));
        purchaseOrderItemDto.setReceivingQuantityPack(BigDecimal.ZERO);
        purchaseOrderItemDto.setReceivingQuantity(BigDecimal.ZERO);
        purchaseOrderItemDto.setStatus(POReceiptStatus.RECEIVED.name());
        return purchaseOrderItemDto;
    }

    @Override
    public PODetail updatePODetailForPOReceipt(POReceiptDTO poReceiptDto) {
        log.info("Request to updatePODetailForPOReceipt");
        log.debug("PO Receipt DTO: {}", poReceiptDto);
        PODetail poDetail = poDetailRepository.findById(poReceiptDto.getPid())
                .orElseThrow(() -> new BadRequestException("PO Detail not found with ID: " + poReceiptDto.getPid()));
        BigDecimal totalReceivedQuantity = poDetail.getQuantityReceived().add(poReceiptDto.getReceivingQuantity());
        if (totalReceivedQuantity.compareTo(poDetail.getOrderQuantity()) > 0) {
            throw new BadRequestException("Received Quantity cannot be more than Order Quantity");
        }
        poDetail.setQuantityReceived(totalReceivedQuantity);
        BigDecimal totalQuantityOnHand = poDetail.getQuantityOnHand().add(poReceiptDto.getReceivingQuantity());
        poDetail.setQuantityOnHand(totalQuantityOnHand);
        int totalReceivedQuantityPack = Optional.ofNullable(poDetail.getPackReceived()).orElse(0);
        totalReceivedQuantityPack += poReceiptDto.getReceivingQuantityPack().intValue();
        poDetail.setPackReceived(totalReceivedQuantityPack);
        poDetail.setDateLastReceipt(Instant.now());
        return poDetailService.update(poDetail);
    }

}
