package com.engseen.erp.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.repository.VendorItemRepository;
import com.engseen.erp.repository.VendorMasterRepository;
import com.engseen.erp.service.VendorService;
import com.engseen.erp.service.dto.ComponentDTO;
import com.engseen.erp.service.dto.ComponentVendorDTO;
import com.engseen.erp.service.dto.VendorMasterDTO;
import com.engseen.erp.service.mapper.VendorMasterMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * Service Implementation for managing {@link com.engseen.erp.domain.VendorMaster}.
 */
@Service
public class VendorServiceImpl implements VendorService {

    private final Logger log = LoggerFactory.getLogger(ComponentServiceImpl.class);

    private final VendorMasterMapper vendorMasterMapper;
    private final VendorMasterRepository vendorMasterRepository;
    private final VendorItemRepository vendorItemRepository;

    @Autowired
    public VendorServiceImpl(VendorMasterMapper vendorMasterMapper, VendorMasterRepository vendorMasterRepository, VendorItemRepository vendorItemRepository) {
        this.vendorMasterMapper = vendorMasterMapper;
        this.vendorMasterRepository = vendorMasterRepository;
        this.vendorItemRepository = vendorItemRepository;
    }

    @Override
    @Transactional
    public List<ComponentVendorDTO> findAll(Pageable pageable, List<ComponentDTO> components) {
        log.debug("Request to findAll Component by component, vendor and packing size");

        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<VendorMasterDTO> findAll(Pageable pageable, String vendorId) {

        /*
        check null for vendorId, use empty string to search if it is null
         */
        vendorId = Objects.isNull(vendorId) ? "" : vendorId;
        if (Objects.isNull(pageable)) {
            return vendorMasterRepository
                    .findAllByVendorIDContaining(vendorId)
                    .parallelStream()
                    .map(vendorMasterMapper::toDto)
                    .collect(Collectors.toList());
        } else {
            return vendorMasterRepository
                    .findAllByVendorIDContaining(pageable, vendorId)
                    .toList()
                    .parallelStream()
                    .map(vendorMasterMapper::toDto)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public VendorMasterDTO findOneByVendorId(String vendorId) {
        log.debug("Request to findOne Vendor By VendorId: {}", vendorId);
        return vendorMasterRepository.findByVendorID(vendorId)
            .map(vendorMasterMapper::toDto)
            .orElse(null);
    }

    @Override
    public VendorItem findOneVendorItemByVendorAndItem(String vendorId, String item) {
        log.debug("Request to findOne VendorItem Vendor By VendorId {} and item {}", vendorId, item);
        return vendorItemRepository.findOneByVendorIDAndItem(vendorId, item)
            .orElse(null);
    }
    
}
