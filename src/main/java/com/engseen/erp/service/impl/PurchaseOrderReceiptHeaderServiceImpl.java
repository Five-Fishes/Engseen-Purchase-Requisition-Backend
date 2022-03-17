package com.engseen.erp.service.impl;

import java.util.Date;
import java.util.List;

import com.engseen.erp.repository.POReceiptHeaderRepository;
import com.engseen.erp.service.PurchaseOrderReceiptHeaderService;
import com.engseen.erp.service.PurchaseOrderReceiptService;
import com.engseen.erp.service.dto.POReceiptDTO;
import com.engseen.erp.service.dto.POReceiptHeaderDTO;
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

    private final PurchaseOrderReceiptService purchaseOrderReceiptService;

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
}
