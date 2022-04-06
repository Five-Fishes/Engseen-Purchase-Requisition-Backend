package com.engseen.erp.repository;

import com.engseen.erp.domain.ItemCostBook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCostBookRepository extends JpaRepository<ItemCostBook, Integer> {
    
    /*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
    @Query(value = "EXEC ItemCostBookInsert :Item, :Updated, :CreatedBy", 
        nativeQuery = true)
    ItemCostBook insertItemCostBook(@Param("Item") String Item, @Param("Updated") Character Updated, @Param("CreatedBy") String CreatedBy);

    /*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
    @Query(value = "EXEC ItemCostBookUpdate :ID, :Item, :Updated, :CreatedBy", 
        nativeQuery = true)
    ItemCostBook updateItemCostBook(@Param("ID") Integer ID,
        @Param("Item") String Item, @Param("Updated") Character Updated, @Param("CreatedBy") String CreatedBy
    );

    @Query(value = "EXEC ItemCostBookDelete :ID", nativeQuery = true)
    void deleteItemCostBook(@Param("ID") Integer ID);
}
