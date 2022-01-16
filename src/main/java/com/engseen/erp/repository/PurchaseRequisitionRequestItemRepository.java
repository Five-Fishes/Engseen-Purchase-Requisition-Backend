package com.engseen.erp.repository;

import com.engseen.erp.domain.PurchaseRequisitionRequestItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequisitionRequestItemRepository extends JpaRepository<PurchaseRequisitionRequestItem, Long> {

    Page<PurchaseRequisitionRequestItem> findAllByPurchaseRequisitionRequest_Id(Pageable pageable, long purchaseRequisitionRequest_Id);

    void deleteAllByPurchaseRequisitionRequest_Id(long purchaseRequisitionRequest_Id);
}
