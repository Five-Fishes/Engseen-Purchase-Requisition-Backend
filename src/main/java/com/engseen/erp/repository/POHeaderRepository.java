package com.engseen.erp.repository;

import com.engseen.erp.domain.POHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface POHeaderRepository extends JpaRepository<POHeader, Integer> {
}