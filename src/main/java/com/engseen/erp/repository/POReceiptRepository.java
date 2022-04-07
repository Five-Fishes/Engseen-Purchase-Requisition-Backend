package com.engseen.erp.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.engseen.erp.domain.POReceipt;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface POReceiptRepository extends JpaRepository<POReceipt, Integer> {

	Page<POReceipt> findAllByGrnNo(Pageable pageable, String grnNo);

	POReceipt findOneByGrnNoAndPidAndIid(String grnNo, Integer pid, Integer iid);
	
	/*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
	@Query(value = "EXEC POReceiptInsert :GRNNo, :PID, :QuantityReceived, :QuantityReversed, :UnitCost, :OrigUnitCost, :InspectionCode, :IID, :StoreNo, :StoreBin, :InventoryCode, :LotNo, :IRID, :Created, :CreatedBy, :PackReceived, :PackReversed", 
		nativeQuery = true)
    POReceipt insertPOReceipt(@Param("GRNNo") String GRNNo, @Param("PID") Integer PID, @Param("QuantityReceived") BigDecimal QuantityReceived, @Param("QuantityReversed") BigDecimal QuantityReversed, @Param("UnitCost") BigDecimal UnitCost, @Param("OrigUnitCost") BigDecimal OrigUnitCost, 
							@Param("InspectionCode") Character InspectionCode, @Param("IID") Integer IID, @Param("StoreNo") String StoreNo, @Param("StoreBin") String StoreBin, @Param("InventoryCode") Character InventoryCode, @Param("LotNo") String LotNo, 
							@Param("IRID") Integer IRID, @Param("Created") Timestamp Created, @Param("CreatedBy") String CreatedBy, @Param("PackReceived") Integer PackReceived, @Param("PackReversed") Integer PackReversed
	);
	
	/*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
	@Query(value = "EXEC POReceiptUpdate :ID, :GRNNo, :PID, :QuantityReceived, :QuantityReversed, :UnitCost, :OrigUnitCost, :InspectionCode, :IID, :StoreNo, :StoreBin, :InventoryCode, :LotNo, :IRID, :Created, :CreatedBy, :PackReceived, :PackReversed",  
		nativeQuery = true)
    POReceipt updatePOReceipt(@Param("ID") Integer ID, 
							@Param("GRNNo") String GRNNo, @Param("PID") Integer PID, @Param("QuantityReceived") BigDecimal QuantityReceived, @Param("QuantityReversed") BigDecimal QuantityReversed, @Param("UnitCost") BigDecimal UnitCost, @Param("OrigUnitCost") BigDecimal OrigUnitCost, 
							@Param("InspectionCode") Character InspectionCode, @Param("IID") Integer IID, @Param("StoreNo") String StoreNo, @Param("StoreBin") String StoreBin, @Param("InventoryCode") Character InventoryCode, @Param("LotNo") String LotNo, 
							@Param("IRID") Integer IRID, @Param("Created") Timestamp Created, @Param("CreatedBy") String CreatedBy, @Param("PackReceived") Integer PackReceived, @Param("PackReversed") Integer PackReversed
	);

	@Query(value = "EXEC POReceiptDelete :ID", nativeQuery = true)
    void deletePOReceipt(@Param("ID") Integer ID);

}
