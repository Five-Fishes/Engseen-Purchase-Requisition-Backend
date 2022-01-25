package com.engseen.erp.repository;

import com.engseen.erp.domain.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMasterRepository extends JpaRepository<UserMaster, Integer> {
    Optional<UserMaster> findOneByUserID(String userId);
}