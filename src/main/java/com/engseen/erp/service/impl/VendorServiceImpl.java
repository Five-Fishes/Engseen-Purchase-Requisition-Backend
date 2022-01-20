package com.engseen.erp.service.impl;

import java.util.List;

import com.engseen.erp.repository.VendorMasterRepository;
import com.engseen.erp.service.VendorService;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentVendorDTO;
import com.engseen.erp.service.dto.VendorMasterDTO;
import com.engseen.erp.service.mapper.VendorMasterMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
/**
 * Service Implementation for managing {@link com.engseen.erp.domain.VendorMaster}.
 */
@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final Logger log = LoggerFactory.getLogger(ComponentServiceImpl.class);

    private VendorMasterMapper vendorMasterMapper;
    private VendorMasterRepository vendorMasterRepository;

    @Override
    @Transactional
    public List<ComponentVendorDTO> findAll(Pageable pageable, List<ComponentDTO> components) {
        log.debug("Request to findAll Component by component, vendor and packing size");

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public VendorMasterDTO findOneByVendorId(String vendorId) {
        log.debug("Request to findOne Vendor By VendorId: {}", vendorId);
        return vendorMasterRepository.findByVendorID(vendorId)
            .map(vendorMasterMapper::toDto)
            .orElse(null);
    }
    
}
