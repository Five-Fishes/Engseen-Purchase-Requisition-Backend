package com.engseen.erp.service.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class FavouriteVendorDTO {
    private Long id;
    private String vendorId;
    private LocalDateTime createdDate;
    private String createdBy;
}
