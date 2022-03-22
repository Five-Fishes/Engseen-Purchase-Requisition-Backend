package com.engseen.erp.repository;

import com.engseen.erp.domain.FavouriteVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteVendorRepository extends JpaRepository<FavouriteVendor, Long> {
}