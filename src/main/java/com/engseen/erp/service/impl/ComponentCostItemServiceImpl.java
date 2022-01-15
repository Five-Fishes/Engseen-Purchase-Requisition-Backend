package com.engseen.erp.service.impl;

import com.engseen.erp.service.ComponentItemCostService;
import com.engseen.erp.service.dto.ComponentDto;
import com.engseen.erp.service.dto.ComponentItemCostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service Implementation for managing {@link ComponentCostItem}.
 */
@Service
@Transactional
public class ComponentCostItemServiceImpl implements ComponentItemCostService {
    private final Logger log = LoggerFactory.getLogger(ComponentServiceImpl.class);

    @Override
    @Transactional
    public List<ComponentItemCostDto> findAll(Pageable pageable, List<ComponentDto> components) {
        log.debug("Request to findAll ComponentItemCost by ComponentDto List");

        // TODO Auto-generated method stub
        return null;
    }
}
