package com.engseen.erp.repository;

import com.engseen.erp.domain.ItemMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, Integer> {
    Optional<ItemMaster> findByItemIsLike(String componentCode);
}
