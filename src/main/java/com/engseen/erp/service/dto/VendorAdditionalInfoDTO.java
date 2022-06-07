package com.engseen.erp.service.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VendorAdditionalInfoDTO {

    String vendorId;
    boolean isFavourite;
    String email;
}
