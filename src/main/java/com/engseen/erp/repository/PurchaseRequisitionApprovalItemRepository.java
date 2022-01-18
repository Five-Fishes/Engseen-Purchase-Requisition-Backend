package com.engseen.erp.repository;

import com.engseen.erp.constant.enumeration.PurchaseRequisitionApprovalItemStatus;
import com.engseen.erp.domain.PurchaseRequisitionApprovalItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRequisitionApprovalItemRepository extends JpaRepository<PurchaseRequisitionApprovalItem, Long> {
    Page<PurchaseRequisitionApprovalItem> findAllByPurchaseRequisitionApproval_Id(Pageable pageable, long purchaseRequisitionApprovalId);
    Page<PurchaseRequisitionApprovalItem> findAllByPurchaseRequisitionApproval_IdAndStatus(Pageable pageable, long purchaseRequisitionApprovalId, PurchaseRequisitionApprovalItemStatus purchaseRequisitionApprovalItemStatus);
}
