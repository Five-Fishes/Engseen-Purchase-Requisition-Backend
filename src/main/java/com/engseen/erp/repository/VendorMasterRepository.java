package com.engseen.erp.repository;

import com.engseen.erp.domain.VendorMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorMasterRepository extends JpaRepository<VendorMaster, Integer> {
    Optional<VendorMaster> findByVendorID(String vendorId);
}
