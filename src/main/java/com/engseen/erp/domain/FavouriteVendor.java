package com.engseen.erp.domain;

import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;

@Entity
@ToString
@Table(name = "FavouriteVendor")
public class FavouriteVendor {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "VendorId", nullable = false, length = 12)
    private String vendorId;

    @Column(name = "CreatedDate")
    private Instant createdDate;

    @Column(name = "CreatedBy", length = 10)
    private String createdBy;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}