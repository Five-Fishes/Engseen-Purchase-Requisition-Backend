package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequisitionTemplateItemRepository extends JpaRepository<PurchaseRequisitionTemplateItem, Long> {
}
