package com.engseen.erp.service.impl;

import com.engseen.erp.domain.VendorAdditionalInfo;
import com.engseen.erp.repository.VendorAdditionalInfoRepository;
import com.engseen.erp.service.VendorAdditionalInfoService;
import com.engseen.erp.service.dto.VendorAdditionalInfoDTO;
import com.engseen.erp.service.mapper.VendorAdditionalInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class VendorAdditionalInfoServiceImpl implements VendorAdditionalInfoService {

    private final VendorAdditionalInfoRepository vendorAdditionalInfoRepository;
    private final VendorAdditionalInfoMapper vendorAdditionalInfoMapper;

    @Override
    public VendorAdditionalInfoDTO findByVendorId(String vendorId) {
        Optional<VendorAdditionalInfo> vendorAdditionalInfoOptional = vendorAdditionalInfoRepository.findById(vendorId);
        return vendorAdditionalInfoOptional.map(vendorAdditionalInfoMapper::toDto).orElse(null);
    }
}
