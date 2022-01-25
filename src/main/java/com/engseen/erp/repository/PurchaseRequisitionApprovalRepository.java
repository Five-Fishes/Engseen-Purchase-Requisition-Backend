package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionApproval;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PurchaseRequisitionApprovalRepository extends JpaRepository<PurchaseRequisitionApproval, Long> {
    Page<PurchaseRequisitionApproval> findAllByCreatedDateBetween(Pageable pageable, Date startDate, Date endDate);
}
