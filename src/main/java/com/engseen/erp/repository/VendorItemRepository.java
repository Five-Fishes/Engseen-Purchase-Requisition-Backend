package com.engseen.erp.repository;

import com.engseen.erp.domain.VendorItem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface VendorItemRepository extends JpaRepository<VendorItem, Integer> {
    Page<VendorItem> findAllByItemContaining(Pageable pageable, String item);

    List<VendorItem> findAllByItemContaining(String item);

    Page<VendorItem> findAllByVendorIDContaining(Pageable pageable, String item);

    List<VendorItem> findAllByVendorIDContaining(String item);

    Page<VendorItem> findAllByItemContainingOrVendorIDContainingOrderByItemAscVendorIDAsc(Pageable pageable, String item, String vendorId);

    List<VendorItem> findAllByItemContainingOrVendorIDContainingOrderByItemAscVendorIDAsc(String item, String vendorId);

    Page<VendorItem> findAllByIdIn(Pageable pageable, List<Integer> idList);

	Optional<VendorItem> findOneByVendorIDAndItem(String vendorId, String item);
}
