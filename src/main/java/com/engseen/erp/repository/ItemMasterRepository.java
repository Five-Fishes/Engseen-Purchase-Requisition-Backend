package com.engseen.erp.repository;

import com.engseen.erp.domain.ItemMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, Integer> {
    Optional<ItemMaster> findByItemIsLike(String item);

    List<ItemMaster> findAllByItemContaining(String item);

    List<ItemMaster> findAllByItemContainingOrItemDescriptionContaining(String item, String itemDescription);

    Page<ItemMaster> findAllByItemContaining(Pageable pageable, String item);

	ItemMaster findOneByItem(String item);

    @Query(value = "EXEC ItemMasterUpdate :ID, :Item, :ItemDescription, :UnitOfMeasure, :VariableOverheadCost, :TotalCost, :RolledVariableOverheadCost, :TotalRolledCost, :Modified, :ModifiedBy, :Accessed, :AccessedBy"
        , nativeQuery = true)
    ItemMaster updateItemMaster(@Param("ID") Integer ID, 
        @Param("Item") String Item, @Param("ItemDescription") String ItemDescription, @Param("UnitOfMeasure") String UnitOfMeasure,
        @Param("VariableOverheadCost") BigDecimal VariableOverheadCost, @Param("TotalCost") BigDecimal TotalCost, @Param("RolledVariableOverheadCost") BigDecimal RolledVariableOverheadCost, @Param("TotalRolledCost") BigDecimal TotalRolledCost, 
        @Param("Modified") Date Modified, @Param("ModifiedBy") String ModifiedBy, @Param("Accessed") Date Accessed, @Param("AccessedBy") String AccessedBy
    );
}
