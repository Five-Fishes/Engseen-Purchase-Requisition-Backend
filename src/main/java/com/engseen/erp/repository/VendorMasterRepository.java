package com.engseen.erp.repository;

import com.engseen.erp.domain.VendorMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorMasterRepository extends JpaRepository<VendorMaster, Integer> {
    Optional<VendorMaster> findByVendorID(String vendorId);

    List<VendorMaster> findAllByVendorIDContaining(String vendorID);

    Page<VendorMaster> findAllByVendorIDContaining(Pageable pageable, String vendorID);
}
