package com.engseen.erp.service.impl;

import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.repository.VendorItemRepository;
import com.engseen.erp.service.ComponentItemCostService;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentItemCostDTO;
import com.engseen.erp.service.mapper.VendorItemMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link com.engseen.erp.domain.VendorItem}.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ComponentCostItemServiceImpl implements ComponentItemCostService {

    private final Logger log = LoggerFactory.getLogger(ComponentServiceImpl.class);

    private final VendorItemRepository vendorItemRepository;
    private final VendorItemMapper vendorItemMapper;

    @Override
    public List<ComponentItemCostDTO> findAll(Pageable pageable, List<ComponentDTO> components) {
        log.debug("Request to findAll ComponentItemCost by ComponentDto List");

        List<Integer> vendorItemIdList = components
                .parallelStream()
                .map(ComponentDTO::getId)
                .map(Long::intValue)
                .collect(Collectors.toList());

        List<VendorItem> vendorItemList = vendorItemRepository.findAllByIdIn(pageable, vendorItemIdList).toList();

        return vendorItemList
                .parallelStream()
                .map(vendorItemMapper::vendorItemToComponentItemCostDTO)
                .peek(componentItemCostDTO -> {
                    Optional<ComponentDTO> componentDTOOptional = components
                            .stream()
                            .filter(componentDTO -> componentDTO.getId().equals(componentItemCostDTO.getId()))
                            .findFirst();

                    componentDTOOptional.ifPresent(componentDTO -> componentItemCostDTO.setComponentCode(componentDTO.getComponentCode()));
                }).collect(Collectors.toList());
    }
}
