package com.engseen.erp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class VendorAdditionalInfo {

    @Id
    @Column
    String vendorId;

    @Column
    boolean isFavourite;

    @Column
    String email;
}
