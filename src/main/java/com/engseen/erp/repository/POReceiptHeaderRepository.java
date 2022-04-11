package com.engseen.erp.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import com.engseen.erp.domain.POReceiptHeader;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface POReceiptHeaderRepository extends JpaRepository<POReceiptHeader, Integer> {

	Page<POReceiptHeader> findAllByCreatedBetween(Pageable pageable, Instant startDate, Instant endDate);
	
	POReceiptHeader findOneByGrnNo(String grnNo);
	
	/*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
	@Query(value = "EXEC POReceiptHeaderInsert :GRNNo, :GRNDate, :Status, :VendorID, :ExchangeRate, :TransportVia, :FreightBillNumber, :PackingListNumber, :GRNReference, :DiscountAmount, :Remark, :GRNType, :InvoiceAmount, :Hold, :Paid, :Posted, :Created, :CreatedBy, :Modified, :ModifiedBy, :Accessed, :AccessedBy, :CustomFormDate, :CIFValue, :CustomFormNo", 
		nativeQuery = true)
    POReceiptHeader insertPOReceiptHeader(@Param("GRNNo") String GRNNo, @Param("GRNDate") Timestamp GRNDate, @Param("Status") Character Status, @Param("VendorID") String VendorID, @Param("ExchangeRate") BigDecimal ExchangeRate, @Param("TransportVia") String TransportVia, 
							@Param("FreightBillNumber")String FreightBillNumber, @Param("PackingListNumber") String PackingListNumber, @Param("GRNReference") String GRNReference, @Param("DiscountAmount") BigDecimal DiscountAmount, @Param("Remark") String Remark, @Param("GRNType") Character GRNType,
							@Param("InvoiceAmount") BigDecimal InvoiceAmount, @Param("Hold") Character Hold, @Param("Paid") Character Paid, @Param("Posted") Character Posted, @Param("Created") Timestamp Created, @Param("CreatedBy") String CreatedBy, 
							@Param("Modified") Timestamp Modified, @Param("ModifiedBy") String ModifiedBy, @Param("Accessed") Timestamp Accessed, @Param("AccessedBy") String AccessedBy,  @Param("CustomFormDate") Timestamp CustomFormDate, @Param("CIFValue") BigDecimal CIFValue,
							@Param("CustomFormNo") String CustomFormNo
	);
	
	/*
    UnusedReturnValue warning is suppressed because return value works in SQL Server 2019, NOT in SQL Server 2005
     */
    @SuppressWarnings("UnusedReturnValue")
	@Query(value = "EXEC POReceiptHeaderUpdate :ID, :GRNNo, :GRNDate, :Status, :VendorID, :ExchangeRate, :TransportVia, :FreightBillNumber, :PackingListNumber, :GRNReference, :DiscountAmount, :Remark, :GRNType, :InvoiceAmount, :Hold, :Paid, :Posted, :Created, :CreatedBy, :Modified, :ModifiedBy, :Accessed, :AccessedBy, :CustomFormDate, :CIFValue, :CustomFormNo",  
		nativeQuery = true)
    POReceiptHeader updatePOReceiptHeader(@Param("ID") Integer ID, 
							@Param("GRNNo") String GRNNo, @Param("GRNDate") Timestamp GRNDate, @Param("Status") Character Status, @Param("VendorID") String VendorID, @Param("ExchangeRate") BigDecimal ExchangeRate, @Param("TransportVia") String TransportVia, 
							@Param("FreightBillNumber")String FreightBillNumber, @Param("PackingListNumber") String PackingListNumber, @Param("GRNReference") String GRNReference, @Param("DiscountAmount") BigDecimal DiscountAmount, @Param("Remark") String Remark, @Param("GRNType") Character GRNType,
							@Param("InvoiceAmount") BigDecimal InvoiceAmount, @Param("Hold") Character Hold, @Param("Paid") Character Paid, @Param("Posted") Character Posted, @Param("Created") Timestamp Created, @Param("CreatedBy") String CreatedBy, 
							@Param("Modified") Timestamp Modified, @Param("ModifiedBy") String ModifiedBy, @Param("Accessed") Timestamp Accessed, @Param("AccessedBy") String AccessedBy,  @Param("CustomFormDate") Timestamp CustomFormDate, @Param("CIFValue") BigDecimal CIFValue,
							@Param("CustomFormNo") String CustomFormNo
	);

	@Query(value = "EXEC POReceiptHeaderDelete :ID", nativeQuery = true)
    void deletePOReceiptHeader(@Param("ID") Integer ID);

	@Query(value = "SELECT porh FROM POReceiptHeader porh " + 
		"WHERE (:grnNo is NULL OR porh.grnNo LIKE %:grnNo%) " + 
		"AND (:vendorID is NULL OR porh.vendorID LIKE %:vendorID%) " + 
		"AND (:doNumber is NULL OR porh.packingListNumber LIKE %:doNumber%) " + 
		"AND (:startGrnDate is NULL OR porh.grnDate >= :startGrnDate) " + 
		"AND (:endGrnDate is NULL OR porh.grnDate <= :endGrnDate)")
	List<POReceiptHeader> search(@Param("grnNo") String grnNo, @Param("vendorID") String vendorID, @Param("doNumber") String doNumber, 
		@Param("startGrnDate") Instant startGrnDate, @Param("endGrnDate") Instant endGrnDate, Pageable pageable);
	
}
