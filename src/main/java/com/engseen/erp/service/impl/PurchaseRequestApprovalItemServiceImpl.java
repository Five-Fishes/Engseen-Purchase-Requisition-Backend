package com.engseen.erp.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.engseen.erp.constant.enumeration.PurchaseRequisitionApprovalItemStatus;
import com.engseen.erp.domain.PurchaseRequisitionApproval;
import com.engseen.erp.domain.PurchaseRequisitionApprovalItem;
import com.engseen.erp.repository.PurchaseRequisitionApprovalItemRepository;
import com.engseen.erp.repository.PurchaseRequisitionApprovalRepository;
import com.engseen.erp.repository.VendorItemRepository;
import com.engseen.erp.service.PurchaseRequestApprovalItemService;
import com.engseen.erp.service.dto.PurchaseRequestApprovalItemDto;

import com.engseen.erp.service.mapper.PurchaseRequisitionApprovalItemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.PurchaseRequisitionApprovalItem}.
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PurchaseRequestApprovalItemServiceImpl implements PurchaseRequestApprovalItemService {

    private final PurchaseRequisitionApprovalItemRepository purchaseRequisitionApprovalItemRepository;
    private final PurchaseRequisitionApprovalRepository purchaseRequisitionApprovalRepository;
    private final PurchaseRequisitionApprovalItemMapper purchaseRequisitionApprovalItemMapper;
    private final VendorItemRepository vendorItemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequestApprovalItemDto> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable) {
        log.debug("Request to findAll Purchase Request Approval Item");

        List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItemList = purchaseRequisitionApprovalItemRepository.findAllByPurchaseRequisitionApproval_Id(pageable, purchaseRequestApprovalId).toList();

        return purchaseRequisitionApprovalItemMapper.toDto(purchaseRequisitionApprovalItemList);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PurchaseRequestApprovalItemDto> findAllByPurchaseRequestApprovalIdAndStatus(Long purchaseRequestApprovalId, PurchaseRequisitionApprovalItemStatus status, Pageable pageable) {
        log.debug("Request to findAll Purchase Request Approval Item");
        log.debug("PurchaseRequestApprovalId: {}, status: {}", purchaseRequestApprovalId, status);

        List<PurchaseRequisitionApprovalItem> purchaseRequisitionApprovalItemList = purchaseRequisitionApprovalItemRepository.findAllByPurchaseRequisitionApproval_IdAndStatus(pageable, purchaseRequestApprovalId, status).toList();

        return purchaseRequisitionApprovalItemMapper.toDto(purchaseRequisitionApprovalItemList);
    }

    @Override
    public PurchaseRequestApprovalItemDto add(PurchaseRequestApprovalItemDto purchaseRequestApprovalItemDto) {
        log.debug("Request to add Purchase Request Approval Item");

        Optional<PurchaseRequisitionApproval> purchaseRequisitionApprovalOptional = purchaseRequisitionApprovalRepository.findById(purchaseRequestApprovalItemDto.getRequestApprovalId());

        if (purchaseRequisitionApprovalOptional.isPresent()) {
            PurchaseRequisitionApprovalItem purchaseRequisitionApprovalItem = purchaseRequisitionApprovalItemMapper.toEntity(purchaseRequestApprovalItemDto);
            purchaseRequisitionApprovalItem.setPurchaseRequisitionApproval(purchaseRequisitionApprovalOptional.get());

            /*
            Find vendor item and prefill unit price as item cost
             */
            vendorItemRepository.findOneByVendorIDAndItem(
                    purchaseRequestApprovalItemDto.getVendorId(),
                    purchaseRequestApprovalItemDto.getComponentCode()
            ).ifPresentOrElse(
                    vendorItem -> purchaseRequisitionApprovalItem.setItemCost(vendorItem.getViUnitPrice()),
                    () -> purchaseRequisitionApprovalItem.setItemCost(BigDecimal.ZERO)
            );

            PurchaseRequisitionApprovalItem savedPurchaseRequisitionApprovalItem = purchaseRequisitionApprovalItemRepository.save(purchaseRequisitionApprovalItem);
            return purchaseRequisitionApprovalItemMapper.toDto(savedPurchaseRequisitionApprovalItem);
        }

        return null;
    }

    @Override
    public PurchaseRequestApprovalItemDto update(Long purchaseRequestApprovalItemId, PurchaseRequestApprovalItemDto purchaseRequestApprovalItemDto) {
        log.debug("Request to update Purchase Request Approval Item");

        Optional<PurchaseRequisitionApproval> purchaseRequisitionApprovalOptional = purchaseRequisitionApprovalRepository.findById(purchaseRequestApprovalItemDto.getRequestApprovalId());

        PurchaseRequisitionApprovalItem savedPurchaseRequisitionApprovalItem;
        PurchaseRequisitionApprovalItem purchaseRequisitionApprovalItem = purchaseRequisitionApprovalItemMapper.toEntity(purchaseRequestApprovalItemDto);

        if (purchaseRequisitionApprovalOptional.isPresent()) {
            purchaseRequisitionApprovalItem.setId(purchaseRequestApprovalItemId);
            purchaseRequisitionApprovalItem.setPurchaseRequisitionApproval(purchaseRequisitionApprovalOptional.get());
        }

        savedPurchaseRequisitionApprovalItem = purchaseRequisitionApprovalItemRepository.save(purchaseRequisitionApprovalItem);

        return purchaseRequisitionApprovalItemMapper.toDto(savedPurchaseRequisitionApprovalItem);

    }

    @Override
    public void delete(Long purchaseRequestApprovalItemId) {
        log.debug("Request to delete Purchase Request Approval Item");

        if (purchaseRequisitionApprovalItemRepository.existsById(purchaseRequestApprovalItemId)) {
            purchaseRequisitionApprovalItemRepository.deleteById(purchaseRequestApprovalItemId);
        }

    }

}
