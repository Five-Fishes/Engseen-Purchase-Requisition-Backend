package com.engseen.erp.repository;

import com.engseen.erp.domain.VendorItem;
import com.engseen.erp.domain.VendorMaster;

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

    Page<VendorItem> findAllByViConversionIs(Pageable pageable, BigDecimal viConversion);

    Page<VendorItem> findAllByVendorIDContaining(Pageable pageable, String item);

    Page<VendorItem> findAllByVendorIDContainingOrViConversionIs(Pageable pageable, String item, BigDecimal viConversion);

    Page<VendorItem> findAllByItemContainingOrViConversionIs(Pageable pageable, String item, BigDecimal viConversion);

    Page<VendorItem> findAllByItemContainingOrVendorIDContaining(Pageable pageable, String item, String vendorId);

    Page<VendorItem> findAllByIdIn(Pageable pageable, List<Integer> idList);

    Page<VendorItem> findAllByItemContainingOrVendorIDContainingOrViConversionIs(Pageable pageable, String item, String vendorId, BigDecimal viConversion);

	Optional<VendorItem> findOneByVendorIDAndItem(String vendorId, String item);
}
