-- Start POReceiptHeader Store Procedure
-- Insert POReceiptHeader
CREATE PROCEDURE POReceiptHeaderInsert  
    @GRNNo VARCHAR(20), @GRNDate DATETIME, @Status CHAR(1), @VendorID VARCHAR(12),  @ExchangeRate DECIMAL(18, 0), @TransportVia VARCHAR(30),
    @FreightBillNumber VARCHAR(30), @PackingListNumber VARCHAR(30), @GRNReference VARCHAR(12), @DiscountAmount DECIMAL(18, 0), @Remark VARCHAR(480), @GRNType CHAR(1),
    @InvoiceAmount DECIMAL(18, 0), @Hold CHAR(1), @Paid CHAR(1), @Posted CHAR(1), @Created DATETIME, @CreatedBy VARCHAR(8), 
    @Modified DATETIME, @ModifiedBy VARCHAR(8), @Accessed DATETIME, @AccessedBy VARCHAR(8), @CustomFormDate DATETIME, @CIFValue DECIMAL(18, 0),
    @CustomFormNo VARCHAR(20)
AS
BEGIN
    DECLARE @ID INTEGER;
    SET XACT_ABORT ON;
        INSERT INTO [dbo].[POReceiptHeaderViewLegacy]
        (GRNNo, GRNDate, Status, VendorID, ExchangeRate, TransportVia,
    	FreightBillNumber, PackingListNumber, GRNReference, DiscountAmount, Remark, GRNType,
    	InvoiceAmount, [Hold], Paid, Posted, Created, CreatedBy, 
        Modified, ModifiedBy, Accessed, AccessedBy, CustomFormDate, CIFValue,
    	CustomFormNo)
    VALUES
    (@GRNNo, @GRNDate, @Status, @VendorID,  @ExchangeRate, @TransportVia,
    @FreightBillNumber, @PackingListNumber, @GRNReference, @DiscountAmount, @Remark, @GRNType,
    @InvoiceAmount, @Hold, @Paid, @Posted, @Created, @CreatedBy, 
    @Modified, @ModifiedBy, @Accessed, @AccessedBy, @CustomFormDate, @CIFValue,
    @CustomFormNo);           
	SELECT @ID = SCOPE_IDENTITY();
	SELECT * FROM [dbo].[POReceiptHeaderViewLegacy]
	   	WHERE ID = @ID;
	   	SET XACT_ABORT OFF;
END
GO

-- Create POReceiptHeaderUpdate
CREATE PROCEDURE POReceiptHeaderUpdate @ID INTEGER, 
    @GRNNo VARCHAR(20), @GRNDate DATETIME, @Status CHAR(1), @VendorID VARCHAR(12),  @ExchangeRate DECIMAL(18, 0), @TransportVia VARCHAR(30),
    @FreightBillNumber VARCHAR(30), @PackingListNumber VARCHAR(30), @GRNReference VARCHAR(12), @DiscountAmount DECIMAL(18, 0), @Remark VARCHAR(480), @GRNType CHAR(1),
    @InvoiceAmount DECIMAL(18, 0), @Hold CHAR(1), @Paid CHAR(1), @Posted CHAR(1), @Created DATETIME, @CreatedBy VARCHAR(8), 
    @Modified DATETIME, @ModifiedBy VARCHAR(8), @Accessed DATETIME, @AccessedBy VARCHAR(8), @CustomFormDate DATETIME, @CIFValue DECIMAL(18, 0),
    @CustomFormNo VARCHAR(20)
AS
BEGIN
    SET XACT_ABORT ON;
    UPDATE [dbo].[POReceiptHeaderViewLegacy]
    SET GRNNo = @GRNNo, GRNDate = @GRNDate, Status = @Status, VendorID = @VendorID,  ExchangeRate = @ExchangeRate, TransportVia = @TransportVia,
	    FreightBillNumber = @FreightBillNumber, PackingListNumber = @PackingListNumber, GRNReference = @GRNReference, DiscountAmount = @DiscountAmount, Remark = @Remark, GRNType = @GRNType,
	    InvoiceAmount = @InvoiceAmount, [Hold] = @Hold, Paid = @Paid, Posted = @Posted, Created = @Created, CreatedBy = @CreatedBy, 
	    Modified = @Modified, ModifiedBy = @ModifiedBy, Accessed = @Accessed, AccessedBy = @AccessedBy, CustomFormDate = @CustomFormDate, CIFValue = @CIFValue,
	    CustomFormNo = @CustomFormNo
    WHERE ID = @ID;
    SELECT * FROM [dbo].[POReceiptHeaderViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO

-- POReceiptHeader Delete
CREATE PROCEDURE POReceiptHeaderDelete @ID INTEGER
AS
BEGIN
    SET XACT_ABORT ON;
    DELETE FROM [dbo].[POReceiptHeaderViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO


-- End POReceiptHeader Store Procedure

-- Start POReceipt Store Procedure
-- Insert POReceipt
CREATE PROCEDURE POReceiptInsert  
    @GRNNo VARCHAR(20), @PID INTEGER, @QuantityReceived DECIMAL(18, 0), @QuantityReversed DECIMAL(18, 0), @UnitCost DECIMAL(18, 0), @OrigUnitCost DECIMAL(18, 0), 
    @InspectionCode CHAR(1), @IID INTEGER, @StoreNo VARCHAR(4), @StoreBin VARCHAR(12), @InventoryCode CHAR(1), @LotNo VARCHAR(20), 
    @IRID INTEGER, @Created DATETIME, @CreatedBy VARCHAR(8)
AS
BEGIN
    DECLARE @ID INTEGER;
    SET XACT_ABORT ON;
        INSERT INTO [dbo].[POReceiptViewLegacy]
        (GRNNo, PID, QuantityReceived, QuantityReversed, UnitCost, OrigUnitCost, 
    	InspectionCode, IID, StoreNo, StoreBin, InventoryCode, LotNo, 
    	IRID, Created, CreatedBy)
    VALUES
    (@GRNNo, @PID, @QuantityReceived, @QuantityReversed, @UnitCost, @OrigUnitCost, 
    @InspectionCode, @IID, @StoreNo, @StoreBin, @InventoryCode, @LotNo, 
    @IRID, @Created, @CreatedBy);           
	SELECT @ID = SCOPE_IDENTITY();
	SELECT * FROM [dbo].[POReceiptViewLegacy]
	   	WHERE ID = @ID;
	   	SET XACT_ABORT OFF;
END
GO

-- Create POReceiptUpdate
CREATE PROCEDURE POReceiptUpdate @ID INTEGER, 
    @GRNNo VARCHAR(20), @PID INTEGER, @QuantityReceived DECIMAL(18, 0), @QuantityReversed DECIMAL(18, 0), @UnitCost DECIMAL(18, 0), @OrigUnitCost DECIMAL(18, 0), 
    @InspectionCode CHAR(1), @IID INTEGER, @StoreNo VARCHAR(4), @StoreBin VARCHAR(12), @InventoryCode CHAR(1), @LotNo VARCHAR(20), 
    @IRID INTEGER, @Created DATETIME, @CreatedBy VARCHAR(8)
AS
BEGIN
    SET XACT_ABORT ON;
    UPDATE [dbo].[POReceiptViewLegacy]
    SET GRNNo = @GRNNo, PID = @PID, QuantityReceived = @QuantityReceived, QuantityReversed = @QuantityReversed, UnitCost = @UnitCost, OrigUnitCost = @OrigUnitCost, 
    InspectionCode = @InspectionCode, IID = @IID, StoreNo = @StoreNo, StoreBin = @StoreBin, InventoryCode = @InventoryCode, LotNo = @LotNo, 
    IRID = @IRID, Created = @Created, CreatedBy = @CreatedBy
    WHERE ID = @ID;
    SELECT * FROM [dbo].[POReceiptViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO

-- POReceipt Delete
CREATE PROCEDURE POReceiptDelete @ID INTEGER
AS
BEGIN
    SET XACT_ABORT ON;
    DELETE FROM [dbo].[POReceiptViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO


-- End POReceipt Store Procedure
