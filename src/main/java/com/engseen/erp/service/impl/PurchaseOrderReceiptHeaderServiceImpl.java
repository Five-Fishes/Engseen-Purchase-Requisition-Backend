package com.engseen.erp.service.impl;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.engseen.erp.constant.AppConstant;
import com.engseen.erp.domain.Inventory;
import com.engseen.erp.domain.POReceipt;
import com.engseen.erp.domain.POReceiptHeader;
import com.engseen.erp.repository.POReceiptHeaderRepository;
import com.engseen.erp.service.CounterTableService;
import com.engseen.erp.service.InventoryService;
import com.engseen.erp.service.POReceiptHeaderService;
import com.engseen.erp.service.POReceiptService;
import com.engseen.erp.service.PurchaseOrderReceiptHeaderService;
import com.engseen.erp.service.PurchaseOrderReceiptService;
import com.engseen.erp.service.VendorService;
import com.engseen.erp.service.dto.POReceiptDTO;
import com.engseen.erp.service.dto.POReceiptHeaderDTO;
import com.engseen.erp.service.dto.VendorMasterDTO;
import com.engseen.erp.service.mapper.POReceiptHeaderMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.POReceiptHeader}.
 */
@Service
@RequiredArgsConstructor
public class PurchaseOrderReceiptHeaderServiceImpl implements PurchaseOrderReceiptHeaderService {
    
    private final Logger log = LoggerFactory.getLogger(PurchaseOrderReceiptHeaderServiceImpl.class);

    private final POReceiptHeaderRepository poReceiptHeaderRepository;
    private final POReceiptHeaderMapper poReceiptHeaderMapper;
    private final POReceiptHeaderService poReceiptHeaderService;
    private final POReceiptService poReceiptService;

    private final PurchaseOrderReceiptService purchaseOrderReceiptService;

    private final InventoryService inventoryService;
    private final CounterTableService counterTableService;
    private final VendorService vendorService;

    @Override
    @Transactional(readOnly = true)
    public List<POReceiptHeaderDTO> findAll(Pageable pageable) {
        log.debug("Request to findAll Purchase Order Receipt Header");
        return poReceiptHeaderRepository.findAll(pageable)
            .map(poReceiptHeaderMapper::toDto)
            .map(this::mapPOReceiptList)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<POReceiptHeaderDTO> findAll(Pageable pageable, Date startDate, Date endDate) {
        log.debug("Request to findAll Purchase Order Receipt Header with date filter");
        log.debug("PO Receipt Header date filter start: {}, end: {}", startDate, endDate);
        return poReceiptHeaderRepository.findAllByCreatedBetween(pageable, startDate.toInstant(), endDate.toInstant())
            .map(poReceiptHeaderMapper::toDto)
            .map(this::mapPOReceiptList)
            .toList();
    }
    
    private POReceiptHeaderDTO mapPOReceiptList(POReceiptHeaderDTO poReceiptHeaderDto) {
        log.debug("Request to mapPOReceiptList");
        List<POReceiptDTO> poReceiptDtoList = purchaseOrderReceiptService.findAllByGrnNo(Pageable.unpaged(), poReceiptHeaderDto.getGrnNo());
        poReceiptHeaderDto.setPoReceiptDtoList(poReceiptDtoList);
        return poReceiptHeaderDto;
    }

    @Override
    public POReceiptHeaderDTO createNewPOReceipt(POReceiptHeaderDTO poReceiptHeaderDto) {
        log.debug("Request to createNewPOReceipt with PO Receipt Header DTO: {}", poReceiptHeaderDto);
        // Insert PO Receipt Header
        POReceiptHeader poReceiptHeader = poReceiptHeaderService.insert(constructPOReceiptHeader(poReceiptHeaderDto));
        poReceiptHeaderDto.getPoReceiptDtoList().forEach(poReceiptDto -> {
            log.debug("PO Receipt DTO: {}", poReceiptDto);
            // Insert Inventory
            Inventory inventory = inventoryService.insert(constructInventory(poReceiptDto, poReceiptHeader));
            // TBC Insert Inventory Receipt
            // Insert PO Receipt
            POReceipt poReceipt = poReceiptService.insert(consctructPOReceipt(poReceiptDto, poReceiptHeader, inventory));
        });
        return poReceiptHeaderMapper.toDto(poReceiptHeader);
    }

    private POReceiptHeader constructPOReceiptHeader(POReceiptHeaderDTO poReceiptHeaderDto) {
        POReceiptHeader poReceiptHeader = poReceiptHeaderMapper.toEntity(poReceiptHeaderDto);
        poReceiptHeader.setStatus(AppConstant.PO_RECEIPT_HEADER_STATUS);
        poReceiptHeader.setCreated(Instant.now());
        poReceiptHeader.setCreatedBy("System");
        return poReceiptHeader;
    }

    private Inventory constructInventory(POReceiptDTO poReceiptDto, POReceiptHeader poReceiptHeader) {
        Inventory inventory = new Inventory();
        inventory.setItem(poReceiptDto.getComponentCode());
        inventory.setReceiptID(poReceiptHeader.getId());
        inventory.setReceiptDate(Date.from(poReceiptHeader.getGrnDate()));
        inventory.setCreated(new Date());
        inventory.setCreatedBy("System");
        return inventory;
    }

    private POReceipt consctructPOReceipt(POReceiptDTO poReceiptDto, POReceiptHeader poReceiptHeader, Inventory inventory) {
        POReceipt poReceipt = new POReceipt();
        poReceipt.setGrnNo(poReceiptHeader.getGrnNo());
        poReceipt.setIid(inventory.getId());
        poReceipt.setPid(poReceiptDto.getPid());
        poReceipt.setQuantityReceived(poReceiptDto.getQuantityReceived());
        poReceipt.setStoreNo(inventory.getStoreNo());
        poReceipt.setStoreBin(inventory.getStoreBin());
        poReceipt.setCreated(Instant.now());
        poReceipt.setCreatedBy("System");
        return poReceipt;
    }

    @Override
    public POReceiptHeaderDTO createPOReceiptHeaderByVendorId(String vendorId) {
        log.info("Request to createPOReceiptHeaderByVendorId");
        log.debug("Vendor Id for new PO Receipt Header", vendorId);
        String counterCode = AppConstant.COUNTER_CODE_GRN;
        Integer nextGrnNo = counterTableService.getNextCounterValue(counterCode);
        String nextGrnNoValue = counterCode + nextGrnNo;
        POReceiptHeader poReceiptHeader = constructPOReceiptHeader(nextGrnNoValue, vendorId);
        log.debug("PO Receipt Header to be insert: {}", poReceiptHeader);
        return poReceiptHeaderMapper.toDto(poReceiptHeaderService.insert(poReceiptHeader));
    }

    private POReceiptHeader constructPOReceiptHeader(String grnNo, String vendorId) {
        log.debug("Perform constructPOReceiptHeader");
        POReceiptHeader poReceiptHeader = new POReceiptHeader();
        poReceiptHeader.setGrnNo(grnNo);
        poReceiptHeader.setGrnDate(Instant.now());
        poReceiptHeader.setStatus(AppConstant.PO_RECEIPT_HEADER_STATUS);
        poReceiptHeader.setVendorID(vendorId);
        VendorMasterDTO vendorMasterDto = vendorService.findOneByVendorId(vendorId);
        if (AppConstant.PO_HEADER_CURRENCY_CODE_RM.equals(vendorMasterDto.getCurrencyCode())) {
            poReceiptHeader.setExchangeRate(AppConstant.PO_HEADER_EXCHANGE_RATE_RM);
        } else {
            poReceiptHeader.setExchangeRate(AppConstant.PO_HEADER_EXCHANGE_RATE_OTHER);
        }
        poReceiptHeader.setDiscountAmount(AppConstant.PO_RECEIPT_HEADER_DISCOUNT_AMOUNT);
        poReceiptHeader.setGrnType(AppConstant.PO_RECEIPT_HEADER_GRN_TYPE);
        poReceiptHeader.setInvoiceAmount(AppConstant.PO_RECEIPT_HEADER_INVOICE_AMOUNT);
        poReceiptHeader.setHold(AppConstant.PO_RECEIPT_HEADER_HOLD);
        poReceiptHeader.setPaid(AppConstant.PO_RECEIPT_HEADER_PAID);
        poReceiptHeader.setCreated(Instant.now());
        poReceiptHeader.setCreatedBy(AppConstant.DEFAULT_AUDIT_BY);
        poReceiptHeader.setModified(Instant.now());
        poReceiptHeader.setModifiedBy(AppConstant.DEFAULT_AUDIT_BY);
        poReceiptHeader.setAccessed(Instant.now());
        return poReceiptHeader;
    }
}
