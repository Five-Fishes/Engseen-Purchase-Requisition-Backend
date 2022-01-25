package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PurchaseRequisitionRequestRepository extends JpaRepository<PurchaseRequisitionRequest, Long> {
    Page<PurchaseRequisitionRequest> findAllByCreatedDateBetween(Pageable pageable, Date startDate, Date endDate);
}
