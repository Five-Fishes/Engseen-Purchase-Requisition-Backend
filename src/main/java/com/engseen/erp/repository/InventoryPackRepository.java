package com.engseen.erp.repository;

import com.engseen.erp.domain.InventoryPack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryPackRepository extends JpaRepository<InventoryPack, Integer> {
    
    InventoryPack findOneByItemAndStoreNoAndStoreBin(String item, String storeNo, String storeBin);
    
    /*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
    @Query(value = "EXEC InventoryPackInsert :Item, :StoreNo, :StoreBin, :Pack", 
        nativeQuery = true)
    InventoryPack insertInventoryPack(@Param("Item") String Item, @Param("StoreNo") String StoreNo, @Param("StoreBin") String StoreBin, @Param("Pack") Integer Pack);

    /*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
    @Query(value = "EXEC InventoryPackUpdate :ID, :Item, :StoreNo, :StoreBin, :Pack", 
        nativeQuery = true)
    InventoryPack updateInventoryPack(@Param("ID") Integer ID,
                            @Param("Item") String Item, @Param("StoreNo") String StoreNo, @Param("StoreBin") String StoreBin, @Param("Pack") Integer Pack
    );

    @Query(value = "EXEC InventoryPackDelete :ID", nativeQuery = true)
    void deleteInventoryPack(@Param("ID") Integer ID);

}
