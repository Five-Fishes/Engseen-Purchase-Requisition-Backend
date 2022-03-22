package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.repository.POReceiptRepository;
import com.engseen.erp.service.PurchaseOrderReceiptService;
import com.engseen.erp.service.dto.POReceiptDTO;
import com.engseen.erp.service.mapper.POReceiptMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.POReceipt}.
 */
@Service
@RequiredArgsConstructor
public class PurchaseOrderReceiptServiceImpl implements PurchaseOrderReceiptService {
    
    private final Logger log = LoggerFactory.getLogger(PurchaseOrderReceiptServiceImpl.class);

    private final POReceiptRepository poReceiptRepository;
    private final POReceiptMapper poReceiptMapper;

    @Override
    public List<POReceiptDTO> findAllByGrnNo(Pageable pageable, String grnNo) {
        log.debug("Request to findAll Purchase Order Receipt by GRNNo: {}", grnNo);
        return poReceiptRepository.findAllByGrnNo(pageable, grnNo)
            .map(poReceiptMapper::toDto)
            .toList();
    }
}
