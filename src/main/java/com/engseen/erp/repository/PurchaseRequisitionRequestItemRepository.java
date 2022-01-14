package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionRequestItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequisitionRequestItemRepository extends JpaRepository<PurchaseRequisitionRequestItem, Long> {
}