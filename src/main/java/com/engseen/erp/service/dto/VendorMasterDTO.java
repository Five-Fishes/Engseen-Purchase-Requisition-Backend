package com.engseen.erp.service.dto;

import lombok.Data;

/**
 * A DTO for the {@link com.engseen.erp.domain.VendorMaster} entity.
 */
@Data
public class VendorMasterDTO {

    private String vendorID;

    private String vendorName;

    private String contact;
    
    private String phone;
    
    private String faxNumber;
    
    private String address1;
    
    private String address2;
    
    private String city;

    private String state;
    
    private String zipCode;

    private String country;
    
    private String currencyCode;
    
    private char controllingCurrency;

}
