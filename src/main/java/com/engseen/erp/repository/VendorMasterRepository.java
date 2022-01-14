package com.engseen.erp.repository;

import com.engseen.erp.domain.VendorMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorMasterRepository extends JpaRepository<VendorMaster, Integer> {
}
