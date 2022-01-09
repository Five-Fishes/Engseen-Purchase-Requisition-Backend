package com.engseen.erp.service.impl;

import com.engseen.erp.service.ComponentService;
import com.engseen.erp.service.dto.ComponentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComponentServiceImpl implements ComponentService {
    private final Logger log = LoggerFactory.getLogger(ComponentServiceImpl.class);

    @Override
    @Transactional
    public List<ComponentDto> findAllByFilters(String component, String vendor, Integer packingSize, Pageable pageable) {
        log.debug("Request to findAll Component by component, vendor and packing size");

        // TODO Auto-generated method stub
        return null;
    }
}
