package com.engseen.erp.repository;

import com.engseen.erp.domain.VendorAdditionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorAdditionalInfoRepository extends JpaRepository<VendorAdditionalInfo, String> {
}
