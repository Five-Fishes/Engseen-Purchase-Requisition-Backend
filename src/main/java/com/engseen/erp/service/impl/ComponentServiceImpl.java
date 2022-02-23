package com.engseen.erp.service.impl;

import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.domain.VendorMaster;
import com.engseen.erp.repository.ItemMasterRepository;
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
    private final ItemMasterRepository itemMasterRepository;
    private final VendorItemMapper vendorItemMapper;

    @Override
    public List<ComponentDTO> findAll(Pageable pageable, String component, String vendor, Integer packingSize) {
        log.debug("Request to findAll Component by component, vendor and packing size");

        /*
        Search rules:
        +-----------+--------+-------------+-------------------------------------------------------------+
        | component | vendor | packingSize | queryMethod                                                 |
        +-----------+--------+-------------+-------------------------------------------------------------+
        | null      | null   | null        | findAll                                                     |
        +-----------+--------+-------------+-------------------------------------------------------------+
        | null      | null   | !null       | findAllByViConversionIs                                     |
        +-----------+--------+-------------+-------------------------------------------------------------+
        | null      | !null  | null        | findAllByVendorIDContaining                                 |
        +-----------+--------+-------------+-------------------------------------------------------------+
        | null      | !null  | !null       | findAllByVendorIDContainingOrViConversionIs                 |
        +-----------+--------+-------------+-------------------------------------------------------------+
        | !null     | null   | null        | findAllByItemContaining                                     |
        +-----------+--------+-------------+-------------------------------------------------------------+
        | !null     | null   | !null       | findAllByItemContainingOrViConversionIs                     |
        +-----------+--------+-------------+-------------------------------------------------------------+
        | !null     | !null  | null        | findAllByItemContainingOrVendorIDContaining                 |
        +-----------+--------+-------------+-------------------------------------------------------------+
        | !null     | !null  | !null       | findAllByItemContainingOrVendorIDContainingOrViConversionIs |
        +-----------+--------+-------------+-------------------------------------------------------------+
         */

        List<VendorItem> vendorItemList;
        if (component == null) {
            if (vendor == null) {
                if (packingSize == null) {
                    vendorItemList = vendorItemRepository.findAll(pageable).toList();
                } else {
                    vendorItemList = vendorItemRepository.findAllByViConversionIs(pageable, BigDecimal.valueOf(packingSize)).toList();
                }
            } else {
                if (packingSize == null) {
                    vendorItemList = vendorItemRepository.findAllByVendorIDContaining(pageable, vendor).toList();
                } else {
                    vendorItemList = vendorItemRepository.findAllByVendorIDContainingOrViConversionIs(pageable, vendor, BigDecimal.valueOf(packingSize)).toList();
                }
            }
        } else {
            if (vendor == null) {
                if (packingSize == null) {
                    vendorItemList = vendorItemRepository.findAllByItemContaining(pageable, component).toList();
                } else {
                    vendorItemList = vendorItemRepository.findAllByItemContainingOrViConversionIs(pageable, component, BigDecimal.valueOf(packingSize)).toList();
                }
            } else {
                if (packingSize == null) {
                    vendorItemList = vendorItemRepository.findAllByItemContainingOrVendorIDContaining(pageable, component, vendor).toList();
                } else {
                    vendorItemList = vendorItemRepository.findAllByItemContainingOrVendorIDContainingOrViConversionIs(pageable, component, vendor, BigDecimal.valueOf(packingSize)).toList();
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
}
