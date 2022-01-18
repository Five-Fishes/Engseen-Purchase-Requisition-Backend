package com.engseen.erp.service.impl;

import com.engseen.erp.domain.ItemMaster;
import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.domain.VendorMaster;
import com.engseen.erp.repository.ItemMasterRepository;
import com.engseen.erp.repository.VendorItemRepository;
import com.engseen.erp.repository.VendorMasterRepository;
import com.engseen.erp.service.ComponentService;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.mapper.VendorItemMapper;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        List<VendorItem> vendorItemList;
        if (Strings.isNotBlank(component)) {
            vendorItemList = vendorItemRepository.findByItemIsLike(pageable, component).toList();
        } else {
             vendorItemList = vendorItemRepository.findAll(pageable).toList();
        }

        return vendorItemList
                .parallelStream()
                .map(vendorItemMapper::vendorItemToComponentDTO)
                .peek(componentDTO -> {
                    Optional<ItemMaster> itemMasterOptional = itemMasterRepository.findByItemIsLike(componentDTO.getComponentName());
                    Optional<VendorMaster> vendorMasterOptional = vendorMasterRepository.findByVendorID(componentDTO.getVendorId());

                    itemMasterOptional.ifPresent(itemMaster -> componentDTO.setComponentCode(Integer.toString(itemMaster.getId())));
                    vendorMasterOptional.ifPresent(vendorMaster -> componentDTO.setVendorName(vendorMaster.getVendorName()));
                })
                .collect(Collectors.toList());
    }
}
