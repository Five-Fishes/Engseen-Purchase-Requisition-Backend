package com.engseen.erp.service.impl;

import com.engseen.erp.domain.Inventory;
import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.domain.VendorMaster;
import com.engseen.erp.repository.InventoryRepository;
import com.engseen.erp.repository.VendorItemRepository;
import com.engseen.erp.repository.VendorMasterRepository;
import com.engseen.erp.service.ComponentService;
import com.engseen.erp.service.dto.ComponentBulkSearchDTO;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.mapper.VendorItemMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.ItemMaster}.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComponentServiceImpl implements ComponentService {

    private final Logger log = LoggerFactory.getLogger(ComponentServiceImpl.class);
    private final VendorItemRepository vendorItemRepository;
    private final VendorMasterRepository vendorMasterRepository;
    private final VendorItemMapper vendorItemMapper;
    private final InventoryRepository inventoryRepository;

    @Override
    public List<ComponentDTO> findAll(Pageable pageable, String component, String vendor, Integer packingSize) {
        // TODO: [LU] Refactor to remove packingSize from request query param as it is a frontend value, now keeping at backend to reduce changes from frontend side
        log.debug("Request to findAll Component by component, vendor and packing size");

        List<VendorItem> vendorItemList;
        if (Objects.isNull(pageable)) {
            if (component == null) {
                if (vendor == null) {
                    vendorItemList = vendorItemRepository.findAll();
                } else {
                    vendorItemList = vendorItemRepository.findAllByVendorIDContaining(vendor);
                }
            } else {
                if (vendor == null) {
                    vendorItemList = vendorItemRepository.findAllByItemContaining(component);
                } else {
                    vendorItemList = vendorItemRepository.findAllByItemContainingOrVendorIDContainingOrderByItemAscVendorIDAsc(component, vendor);
                }
            }
        } else {
            if (component == null) {
                if (vendor == null) {
                    vendorItemList = vendorItemRepository.findAll(pageable).toList();
                } else {
                    vendorItemList = vendorItemRepository.findAllByVendorIDContaining(pageable, vendor).toList();
                }
            } else {
                if (vendor == null) {
                    vendorItemList = vendorItemRepository.findAllByItemContaining(pageable, component).toList();
                } else {
                    vendorItemList = vendorItemRepository.findAllByItemContainingOrVendorIDContainingOrderByItemAscVendorIDAsc(pageable, component, vendor).toList();
                }
            }
        }


        return vendorItemList
                .parallelStream()
                .map(vendorItemMapper::vendorItemToComponentDTO)
                .peek(componentDTO -> {
                    Optional<VendorMaster> vendorMasterOptional = vendorMasterRepository.findByVendorID(componentDTO.getVendorId());
                    vendorMasterOptional.ifPresent(vendorMaster -> componentDTO.setVendorName(vendorMaster.getVendorName()));
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ComponentDTO> bulkFindAll(List<ComponentBulkSearchDTO> componentBulkSearchDTOList) {
        List<ComponentDTO> componentDTOList = new ArrayList<>();
        componentBulkSearchDTOList.forEach(item -> {
            ComponentDTO firstFoundItem = findAll(Pageable.ofSize(1), item.getComponentCode(), item.getVendorId(), item.getPackagingSize().intValue()).get(0);
            componentDTOList.add(firstFoundItem);
        });
        return componentDTOList;
    }

    @Override
    public BigDecimal getStockBalanceByComponentCode(String componentCode) {
        List<Inventory> inventoryList = inventoryRepository.findAllByItem(componentCode);
        return inventoryList
                .stream()
                .map(Inventory::getQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
