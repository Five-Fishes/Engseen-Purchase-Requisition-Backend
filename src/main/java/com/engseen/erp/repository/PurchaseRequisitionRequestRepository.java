package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequisitionRequestRepository extends JpaRepository<PurchaseRequisitionRequest, Long> {
}
