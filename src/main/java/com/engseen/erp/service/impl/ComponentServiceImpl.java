package com.engseen.erp.service.impl;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.engseen.erp.domain.Inventory;
import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.domain.VendorMaster;
import com.engseen.erp.repository.InventoryRepository;
import com.engseen.erp.repository.ItemMasterRepository;
import com.engseen.erp.repository.VendorItemRepository;
import com.engseen.erp.repository.VendorMasterRepository;
import com.engseen.erp.service.ComponentService;
import com.engseen.erp.service.dto.ComponentBulkSearchDTO;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.mapper.ItemMasterMapper;
import com.engseen.erp.service.mapper.VendorItemMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

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
    private final ItemMasterRepository itemMasterRepository;
    private final ItemMasterMapper itemMasterMapper;

    @Override
    public List<ComponentDTO> findAll(Pageable pageable, String component, String vendor, Integer packingSize) {
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
                .stream()// Use stream(avoid parallel stream) because result sequence should be sorted
                .map(vendorItemMapper::vendorItemToComponentDTO)
                .peek(this::assignVendorName)
                .peek(this::assignComponentName)
                .peek(componentDTO -> assignPackingSize(componentDTO, packingSize))
                .collect(Collectors.toList());
    }

    private void assignVendorName(ComponentDTO componentDTO) {
        Optional<VendorMaster> vendorMasterOptional = vendorMasterRepository.findByVendorID(componentDTO.getVendorId());
        vendorMasterOptional.ifPresentOrElse(
                vendorMaster -> componentDTO.setVendorName(vendorMaster.getVendorName()),
                () -> componentDTO.setVendorName("")
        );
    }

    private void assignComponentName(ComponentDTO componentDTO) {
        ItemMaster itemMaster = itemMasterRepository.findOneByItem(componentDTO.getComponentCode());
        if (itemMaster != null && itemMaster.getItemDescription() != null) {
            componentDTO.setComponentName(itemMaster.getItemDescription());
        } else {
            componentDTO.setComponentName("");
        }
    }

    private void assignPackingSize(ComponentDTO componentDTO, Integer packingSize) {
        if (Objects.nonNull(packingSize)) {
            componentDTO.setPackagingSize(BigDecimal.valueOf(packingSize));
        }
    }

    @Override
    public List<ComponentDTO> bulkFindAll(List<ComponentBulkSearchDTO> componentBulkSearchDTOList) {
        /*
        Search Vendor Item for each Element
         */
        List<ComponentDTO> componentSearchResult = componentBulkSearchDTOList
                .stream()// Use stream because sequence is important in next block of code
                .map(componentBulkSearchDTO -> vendorItemRepository
                        .findOneByVendorIDAndItem(componentBulkSearchDTO.getVendorId(), componentBulkSearchDTO.getComponentCode())
                        .orElse(null))
                .map(vendorItemMapper::vendorItemToComponentDTO)
                .collect(Collectors.toList());

        /*
        Map packagingSize to the output list by index
         */
        for (int i = 0; i < componentSearchResult.size(); i++) {
            BigDecimal packagingSize = componentBulkSearchDTOList.get(i).getPackagingSize();
            ComponentDTO componentDTO = componentSearchResult.get(i);
            if (Objects.nonNull(componentDTO)) {
                componentSearchResult.get(i).setPackagingSize(packagingSize);
            }
        }

        /*
        Filter out null result
         */
        return componentSearchResult
                .parallelStream() // Bulk search result sequence is not important, hence using parallel stream
                .filter(Objects::nonNull)
                .peek(this::assignVendorName)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getStockBalanceByComponentCode(String componentCode) {
        return inventoryRepository
                .findAllByItem(componentCode)
                .stream()
                .map(Inventory::getQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<ComponentDTO> findAllByComponentAndVendor(Pageable pageable, String component, String vendorId) {
        log.debug("Request to findAllBy Component: {} And VendorId: {}", component, vendorId);
        return itemMasterRepository.findAllByItemContainingOrItemDescriptionContaining(component, component)
            .stream()
            .map(itemMasterMapper::itemMasterToComponentDTO)
            .filter(itemMaster -> {
                Optional<VendorItem> vendorItemOptional = vendorItemRepository.findOneByVendorIDAndItem(vendorId, itemMaster.getComponentCode());
                if (vendorItemOptional.isPresent()) {
                    itemMaster.setVendorId(vendorItemOptional.get().getVendorID());
                }
                return vendorItemOptional.isPresent();
            })
            .collect(Collectors.toList());
    }

    @Override
    public List<ComponentDTO> findAllByComponentOrVendor(Pageable pageable, String component, String vendor) {
        log.debug("Request to findAllBy Component: {} Or Vendor: {}", component, vendor);
        Set<ComponentDTO> componentDtoList = new HashSet<>();
        if (component != null && component.trim() != "") {
            log.debug("Start search on based on Component");
            itemMasterRepository.findAllByItemContainingOrItemDescriptionContaining(component, component)
                .stream()
                .forEach(itemMaster -> {
                    vendorItemRepository.findAllByItemContaining(pageable, itemMaster.getItem())
                        .map(vendorItemMapper::vendorItemToComponentDTO)
                        .map(componentDTO -> {
                            assignVendorName(componentDTO);
                            componentDTO.setComponentName(itemMaster.getItemDescription());
                            return componentDTO;
                        })
                        .forEach(componentDto -> componentDtoList.add(componentDto));
                });
        }
        if (vendor != null && vendor.trim() != "") {
            log.debug("Start search on based on Vendor");
            vendorMasterRepository.findAllByVendorIDContainingOrVendorNameContaining(vendor, vendor)
                .stream()
                .forEach(vendorMaster -> {
                    vendorItemRepository.findAllByVendorIDContaining(pageable, vendorMaster.getVendorID())
                        .map(vendorItemMapper::vendorItemToComponentDTO)
                        .map(componentDTO -> {
                            assignComponentName(componentDTO);
                            componentDTO.setVendorName(vendorMaster.getVendorName());
                            return componentDTO;
                        })
                        .forEach(componentDto -> componentDtoList.add(componentDto));
                });
        }
        log.debug("Total number of Component matched: {}", componentDtoList.size());
        return componentDtoList.stream()
            .collect(Collectors.toList());
    }
}
