package com.engseen.erp.service.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class FavouriteVendorDTO {
    private Long id;
    private String vendorId;
    private Instant createdDate;
    private String createdBy;
}
