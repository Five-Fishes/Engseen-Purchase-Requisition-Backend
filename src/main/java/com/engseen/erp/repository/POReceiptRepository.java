package com.engseen.erp.repository;

import com.engseen.erp.domain.POReceipt;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POReceiptRepository extends JpaRepository<POReceipt, Integer> {

	Page<POReceipt> findAllByGrnNo(Pageable pageable, String grnNo);
    
}
