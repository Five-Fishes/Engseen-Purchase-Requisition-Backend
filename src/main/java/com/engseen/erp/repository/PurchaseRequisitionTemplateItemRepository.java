package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionTemplateItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequisitionTemplateItemRepository extends JpaRepository<PurchaseRequisitionTemplateItem, Long> {

    Page<PurchaseRequisitionTemplateItem> findAllByPurchaseRequisitionTemplate_Id(Pageable pageable, long purchaseRequisitionTemplateId);

    void deleteAllByPurchaseRequisitionTemplate_Id(long purchaseRequisitionTemplateId);
}
