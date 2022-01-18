package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.domain.PurchaseRequisitionApproval;
import com.engseen.erp.domain.PurchaseRequisitionApprovalItem;
import com.engseen.erp.repository.PurchaseRequisitionApprovalItemRepository;
import com.engseen.erp.repository.PurchaseRequisitionApprovalRepository;
import com.engseen.erp.service.PurchaseRequestApprovalService;
import com.engseen.erp.service.dto.PurchaseRequestApprovalDto;

import com.engseen.erp.service.mapper.PurchaseRequisitionApprovalItemMapper;
import com.engseen.erp.service.mapper.PurchaseRequisitionApprovalMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.PurchaseRequisitionApproval}.
 */
@Service
@Transactional
@RequiredArgsConstructor
public class PurchaseRequestApprovalServiceImpl implements PurchaseRequestApprovalService {

    private final Logger log = LoggerFactory.getLogger(PurchaseRequestApprovalServiceImpl.class);

    private final PurchaseRequisitionApprovalRepository purchaseRequisitionApprovalRepository;
    private final PurchaseRequisitionApprovalItemRepository purchaseRequisitionApprovalItemRepository;
    private final PurchaseRequisitionApprovalMapper purchaseRequisitionApprovalMapper;
    private final PurchaseRequisitionApprovalItemMapper purchaseRequisitionApprovalItemMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequestApprovalDto> findAll(Pageable pageable) {
        log.debug("Request to findAll Purchase Request Approval");
        List<PurchaseRequisitionApproval> purchaseRequisitionApprovalItemList = purchaseRequisitionApprovalRepository
                .findAll(pageable)
                .toList();

        return purchaseRequisitionApprovalMapper.toDto(purchaseRequisitionApprovalItemList);
    }

    @Override
    public PurchaseRequestApprovalDto update(Long purchaseRequestApprovalId, PurchaseRequestApprovalDto purchaseRequestApprovalDto) {
        log.debug("Request to update Purchase Request Approval");
        PurchaseRequisitionApproval purchaseRequisitionApproval = purchaseRequisitionApprovalMapper.toEntity(purchaseRequestApprovalDto);
        purchaseRequisitionApproval.setId(purchaseRequestApprovalId);

        List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItemList = purchaseRequisitionApprovalItemMapper.toEntity(purchaseRequestApprovalDto.getPurchaseRequisitionApprovalItems());
        purchaseRequisitionApprovalItemList.forEach(purchaseRequisitionApprovalItem -> purchaseRequisitionApprovalItem.setPurchaseRequisitionApproval(purchaseRequisitionApproval));
        List<PurchaseRequisitionApprovalItem> updatedPurchaseRequisitionApprovalItemList = purchaseRequisitionApprovalItemRepository.saveAll(purchaseRequisitionApprovalItemList);

        PurchaseRequisitionApproval updatedPurchaseRequisitionApproval = purchaseRequisitionApprovalRepository.save(purchaseRequisitionApproval);

        PurchaseRequestApprovalDto mappedPurchaseRequestApprovalDto =  purchaseRequisitionApprovalMapper.toDto(updatedPurchaseRequisitionApproval);
        mappedPurchaseRequestApprovalDto.setPurchaseRequisitionApprovalItems(
                purchaseRequisitionApprovalItemMapper.toDto(updatedPurchaseRequisitionApprovalItemList)
        );

        return mappedPurchaseRequestApprovalDto;
    }

}
