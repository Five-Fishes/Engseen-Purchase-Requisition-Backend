package com.engseen.erp.repository;

import com.engseen.erp.domain.ItemMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, Integer> {
    Optional<ItemMaster> findByItemIsLike(String item);

    List<ItemMaster> findAllByItemContaining(String item);

    Page<ItemMaster> findAllByItemContaining(Pageable pageable, String item);
}
