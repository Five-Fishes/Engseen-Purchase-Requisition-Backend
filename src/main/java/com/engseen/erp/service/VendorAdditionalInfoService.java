package com.engseen.erp.service;

import com.engseen.erp.service.dto.VendorAdditionalInfoDTO;

public interface VendorAdditionalInfoService {
    VendorAdditionalInfoDTO findByVendorId(String vendorId);
}
