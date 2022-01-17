package com.engseen.erp.repository;

import com.engseen.erp.domain.VendorItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorItemRepository extends JpaRepository<VendorItem, Integer> {
    Page<VendorItem> findByItemIsLike(Pageable pageable, String item);
    Page<VendorItem> findAllByIdIn(Pageable pageable, List<Integer> idList);
}
