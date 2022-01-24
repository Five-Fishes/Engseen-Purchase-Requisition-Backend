package com.engseen.erp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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

        /* Map to entity */
        PurchaseRequisitionApproval purchaseRequisitionApproval = purchaseRequisitionApprovalMapper.toEntity(purchaseRequestApprovalDto);
        List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItemList = purchaseRequisitionApprovalItemMapper.toEntity(purchaseRequestApprovalDto.getPurchaseRequisitionApprovalItems());

        /*
        - Delete missing items
        - Save purchaseRequisitionApproval
        - Save purchaseRequisitionApprovalItem
         */
        deletePurchaseRequisitionApprovalItemsIfMissing(purchaseRequestApprovalId, purchaseRequisitionApprovalItemList);
        PurchaseRequisitionApproval updatedPurchaseRequisitionApproval = savePurchaseRequisitionApproval(purchaseRequestApprovalId, purchaseRequisitionApproval);
        List<PurchaseRequisitionApprovalItem> updatedPurchaseRequisitionApprovalItemList = savePurchaseRequisitionApprovalItems(updatedPurchaseRequisitionApproval, purchaseRequisitionApprovalItemList);

        PurchaseRequestApprovalDto mappedPurchaseRequestApprovalDto =  purchaseRequisitionApprovalMapper.toDto(updatedPurchaseRequisitionApproval);
        mappedPurchaseRequestApprovalDto.setPurchaseRequisitionApprovalItems(
                purchaseRequisitionApprovalItemMapper.toDto(updatedPurchaseRequisitionApprovalItemList)
        );

        return mappedPurchaseRequestApprovalDto;
    }

    private PurchaseRequisitionApproval savePurchaseRequisitionApproval(Long purchaseRequestApprovalId, PurchaseRequisitionApproval purchaseRequisitionApproval) {
        purchaseRequisitionApproval.setId(purchaseRequestApprovalId);
        return purchaseRequisitionApprovalRepository.saveAndFlush(purchaseRequisitionApproval);
    }

    private List<PurchaseRequisitionApprovalItem> savePurchaseRequisitionApprovalItems(PurchaseRequisitionApproval purchaseRequisitionApproval, List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItemList) {
        purchaseRequisitionApprovalItemList.forEach(purchaseRequisitionApprovalItem -> purchaseRequisitionApprovalItem.setPurchaseRequisitionApproval(purchaseRequisitionApproval));
        return purchaseRequisitionApprovalItemRepository.saveAll(purchaseRequisitionApprovalItemList);
    }

    private void deletePurchaseRequisitionApprovalItemsIfMissing(Long purchaseRequisitionApprovalId, List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItemList) {
        List<PurchaseRequisitionApprovalItem> existingPurchaseRequisitionApprovalItemList = purchaseRequisitionApprovalItemRepository.findAllByPurchaseRequisitionApproval_Id(Pageable.unpaged(), purchaseRequisitionApprovalId).toList();
        List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItemsToBeDeleted = existingPurchaseRequisitionApprovalItemList
                .stream()
                .filter( purchaseRequisitionApprovalItem -> purchaseRequisitionApprovalItemList
                        .stream()
                        .noneMatch(purchaseRequisitionApprovalItem1 -> purchaseRequisitionApprovalItem1.getId() == purchaseRequisitionApprovalItem.getId()))
                .collect(Collectors.toList());

        purchaseRequisitionApprovalItemRepository.deleteAllById(
                purchaseRequisitionApprovalItemsToBeDeleted
                        .stream()
                        .map(PurchaseRequisitionApprovalItem::getId)
                        .collect(Collectors.toList())
        );
        purchaseRequisitionApprovalItemRepository.flush();
    }

}
