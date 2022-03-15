package com.engseen.erp.repository;

import java.time.Instant;

import com.engseen.erp.domain.POReceiptHeader;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POReceiptHeaderRepository extends JpaRepository<POReceiptHeader, Integer> {

	Page<POReceiptHeader> findAllByCreatedBetween(Pageable pageable, Instant startDate, Instant endDate);
    
}
