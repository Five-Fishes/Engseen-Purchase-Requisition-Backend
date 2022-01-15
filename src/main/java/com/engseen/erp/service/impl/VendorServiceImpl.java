package com.engseen.erp.service.impl;

import com.engseen.erp.service.VendorService;
import com.engseen.erp.service.dto.ComponentDto;
import com.engseen.erp.service.dto.ComponentVendorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Service Implementation for managing {@link Vendor}.
 */
@Service
@Transactional
public class VendorServiceImpl implements VendorService {
    private final Logger log = LoggerFactory.getLogger(ComponentServiceImpl.class);

    @Override
    @Transactional
    public List<ComponentVendorDto> findAll(Pageable pageable, List<ComponentDto> components) {
        log.debug("Request to findAll Component by component, vendor and packing size");

        // TODO Auto-generated method stub
        return null;
    }
}
