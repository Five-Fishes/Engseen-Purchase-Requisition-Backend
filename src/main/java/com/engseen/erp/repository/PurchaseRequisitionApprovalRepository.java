package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionApproval;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequisitionApprovalRepository extends JpaRepository<PurchaseRequisitionApproval, Long> {
}
