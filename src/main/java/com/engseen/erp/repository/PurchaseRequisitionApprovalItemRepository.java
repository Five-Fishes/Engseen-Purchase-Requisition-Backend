package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionApprovalItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequisitionApprovalItemRepository extends JpaRepository<PurchaseRequisitionApprovalItem, Long> {
}
