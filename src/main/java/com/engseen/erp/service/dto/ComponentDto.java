package com.engseen.erp.service.dto;

import java.io.Serializable;

/**
 * A DTO for the {@link com.engseen.erp.entity.Component} entity.
 */
public class ComponentDto implements Serializable {
    private Long id;

    private String componentCode;

    private String componentName;

    private String vendorId;

    private String vendorName;

    private Integer packagingSize;
}
