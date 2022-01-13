package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequisitionTemplateRepository extends JpaRepository<PurchaseRequisitionTemplate, Long> {
}
