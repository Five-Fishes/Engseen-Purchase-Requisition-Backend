package com.engseen.erp.repository;

import com.engseen.erp.domain.POHeader;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POHeaderRepository extends JpaRepository<POHeader, Integer> {

    Page<POHeader> findAllByPurchaseRequestApprovalId(Long purchaseRequestApprovalId, Pageable pageable);
    
}