package com.engseen.erp.repository;

import com.engseen.erp.domain.VendorItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorItemRepository extends JpaRepository<VendorItem, Integer> {
}
