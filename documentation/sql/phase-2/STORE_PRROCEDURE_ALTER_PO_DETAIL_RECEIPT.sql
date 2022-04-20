-- Start Alter PO Detail Store Procedure
-- Update PODetailInsert SP
ALTER PROCEDURE PODetailInsert
    @PONumber VARCHAR(30), @LineNumber INTEGER, @Item VARCHAR(30), @LineType CHAR(1), @LineSelector CHAR(1), @OrderQuantity DECIMAL(18, 0),
    @QuantityReceived DECIMAL(18, 0), @QuantityInInspection DECIMAL(18, 0), @QuantityOnHand DECIMAL(18, 0), @QuantityOnHold DECIMAL(18, 0), @BlanketQuantity DECIMAL(18, 0), @ETADate DATETIME,
    @NeedDate DATETIME, @DateLastReceipt DATETIME, @LeadTime INTEGER, @Discount INTEGER, @LineStatus CHAR(1), @UnitPrice DECIMAL(18, 0),
    @ExtendedPrice DECIMAL(18, 0), @Remark VARCHAR(480), @VendorItem VARCHAR(30), @VIDescription VARCHAR(60), @VIConversion DECIMAL(18, 0), @VIUnitOfMeasure VARCHAR(4),
    @VIOrderQuantity DECIMAL(18, 0), @VIUnitPrice DECIMAL(18, 0), @ItemFailure VARCHAR(20), @PrintUOM VARCHAR(4), @DepartmentCode VARCHAR(6), @SegmentCode VARCHAR(6),
    @Created DATETIME, @CreatedBy VARCHAR(8), @Modified DATETIME, @ModifiedBy VARCHAR(8), @PackReceived INTEGER, @Pack INTEGER
AS
BEGIN
    SET XACT_ABORT ON;
    DECLARE @ID INTEGER;
    -- noinspection SqlInsertValues

    INSERT INTO [dbo].[PODetailViewLegacy]
    (PONumber, LineNumber, Item, LineType, LineSelector, OrderQuantity,
     QuantityReceived, QuantityInInspection, QuantityOnHand, QuantityOnHold, BlanketQuantity, ETADate,
     NeedDate, DateLastReceipt, LeadTime, Discount, LineStatus, UnitPrice,
     ExtendedPrice, Remark, VendorItem, VIDescription, VIConversion, VIUnitOfMeasure,
     VIOrderQuantity, VIUnitPrice, ItemFailure, PrintUOM, DepartmentCode, SegmentCode,
     Created, CreatedBy, Modified, ModifiedBy, PackReceived, Pack)
    VALUES
    (@PONumber, @LineNumber, @Item, @LineType, @LineSelector, @OrderQuantity,
     @QuantityReceived, @QuantityInInspection, @QuantityOnHand, @QuantityOnHold, @BlanketQuantity, @ETADate,
     @NeedDate, @DateLastReceipt, @LeadTime, @Discount, @LineStatus, @UnitPrice,
     @ExtendedPrice, @Remark, @VendorItem, @VIDescription, @VIConversion, @VIUnitOfMeasure,
     @VIOrderQuantity, @VIUnitPrice, @ItemFailure, @PrintUOM, @DepartmentCode, @SegmentCode,
     @Created, @CreatedBy, @Modified, @ModifiedBy, @PackReceived, @Pack);
    SELECT @ID = SCOPE_IDENTITY();
    SELECT * FROM [dbo].[PODetailViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
go

-- Update PODetailUpdate SP
ALTER PROCEDURE PODetailUpdate @ID INTEGER, 
    @PONumber VARCHAR(30), @LineNumber INTEGER, @Item VARCHAR(30), @LineType CHAR(1), @LineSelector CHAR(1), @OrderQuantity DECIMAL(18, 0),
    @QuantityReceived DECIMAL(18, 0), @QuantityInInspection DECIMAL(18, 0), @QuantityOnHand DECIMAL(18, 0), @QuantityOnHold DECIMAL(18, 0), @BlanketQuantity DECIMAL(18, 0), @ETADate DATETIME,
    @NeedDate DATETIME, @DateLastReceipt DATETIME, @LeadTime INTEGER, @Discount INTEGER, @LineStatus CHAR(1), @UnitPrice DECIMAL(18, 0),
    @ExtendedPrice DECIMAL(18, 0), @Remark VARCHAR(480), @VendorItem VARCHAR(30), @VIDescription VARCHAR(60), @VIConversion DECIMAL(18, 0), @VIUnitOfMeasure VARCHAR(4),
    @VIOrderQuantity DECIMAL(18, 0), @VIUnitPrice DECIMAL(18, 0), @ItemFailure VARCHAR(20), @PrintUOM VARCHAR(4), @DepartmentCode VARCHAR(6), @SegmentCode VARCHAR(6),
    @Created DATETIME, @CreatedBy VARCHAR(8), @Modified DATETIME, @ModifiedBy VARCHAR(8), @PackReceived INTEGER, @Pack INTEGER
AS
BEGIN
    SET XACT_ABORT ON;
    UPDATE [dbo].[PODetailViewLegacy]
    SET PONumber = @PONumber, LineNumber = @LineNumber, Item = @Item, 
        LineType = @LineType, LineSelector = @LineSelector, OrderQuantity = @OrderQuantity, 
        QuantityReceived = @QuantityReceived, QuantityInInspection = @QuantityInInspection, QuantityOnHand = @QuantityOnHand, 
        QuantityOnHold = @QuantityOnHold, BlanketQuantity = @BlanketQuantity, ETADate = @ETADate,
        NeedDate = @NeedDate, DateLastReceipt = @DateLastReceipt, LeadTime = @LeadTime, 
        Discount = @Discount, LineStatus = @LineStatus, UnitPrice = @UnitPrice, 
        ExtendedPrice = @ExtendedPrice, Remark = @Remark, VendorItem = @VendorItem, 
        VIDescription = @VIDescription, VIConversion = @VIConversion, VIUnitOfMeasure = @VIUnitOfMeasure, 
        VIOrderQuantity = @VIOrderQuantity, VIUnitPrice = @VIUnitPrice, ItemFailure = @ItemFailure, 
        PrintUOM = @PrintUOM, DepartmentCode = @DepartmentCode, SegmentCode = @SegmentCode, 
        Created = @Created, CreatedBy = @CreatedBy, Modified = @Modified, 
        ModifiedBy = @ModifiedBy, PackReceived = @PackReceived, Pack = @Pack
    WHERE ID = @ID;
    SELECT * FROM [dbo].[PODetailViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
go

-- End PODetail Store Procedure

-- Start Alter PO Rceipt Store Procedure
-- Alter POReceiptInsert
ALTER PROCEDURE POReceiptInsert 
    @GRNNo VARCHAR(20), @PID INTEGER, @QuantityReceived DECIMAL(18, 0), @QuantityReversed DECIMAL(18, 0), @UnitCost DECIMAL(18, 2), @OrigUnitCost DECIMAL(18, 2), 
    @InspectionCode CHAR(1), @IID INTEGER, @StoreNo VARCHAR(4), @StoreBin VARCHAR(12), @InventoryCode CHAR(1), @LotNo VARCHAR(20), 
    @IRID INTEGER, @Created DATETIME, @CreatedBy VARCHAR(8), @PackReceived INTEGER, @PackReversed INTEGER
AS
BEGIN
    DECLARE @ID INTEGER;
    SET XACT_ABORT ON;
        INSERT INTO [dbo].[POReceiptViewLegacy]
        (GRNNo, PID, QuantityReceived, QuantityReversed, UnitCost, OrigUnitCost, 
    	InspectionCode, IID, StoreNo, StoreBin, InventoryCode, LotNo, 
    	IRID, Created, CreatedBy, PackReceived, PackReversed)
    VALUES
    (@GRNNo, @PID, @QuantityReceived, @QuantityReversed, @UnitCost, @OrigUnitCost, 
    @InspectionCode, @IID, @StoreNo, @StoreBin, @InventoryCode, @LotNo, 
    @IRID, @Created, @CreatedBy, @PackReceived, @PackReversed);           
	SELECT @ID = SCOPE_IDENTITY();
	SELECT * FROM [dbo].[POReceiptViewLegacy]
	   	WHERE ID = @ID;
	   	SET XACT_ABORT OFF;
END
GO

-- Alter POReceiptUpdate
ALTER PROCEDURE POReceiptUpdate @ID INTEGER, 
    @GRNNo VARCHAR(20), @PID INTEGER, @QuantityReceived DECIMAL(18, 0), @QuantityReversed DECIMAL(18, 0), @UnitCost DECIMAL(18, 2), @OrigUnitCost DECIMAL(18, 2), 
    @InspectionCode CHAR(1), @IID INTEGER, @StoreNo VARCHAR(4), @StoreBin VARCHAR(12), @InventoryCode CHAR(1), @LotNo VARCHAR(20), 
    @IRID INTEGER, @Created DATETIME, @CreatedBy VARCHAR(8), @PackReceived INTEGER, @PackReversed INTEGER
AS
BEGIN
    SET XACT_ABORT ON;
    UPDATE [dbo].[POReceiptViewLegacy]
    SET GRNNo = @GRNNo, PID = @PID, QuantityReceived = @QuantityReceived, QuantityReversed = @QuantityReversed, UnitCost = @UnitCost, OrigUnitCost = @OrigUnitCost, 
    InspectionCode = @InspectionCode, IID = @IID, StoreNo = @StoreNo, StoreBin = @StoreBin, InventoryCode = @InventoryCode, LotNo = @LotNo, 
    IRID = @IRID, Created = @Created, CreatedBy = @CreatedBy, PackReceived = @PackReceived, PackReversed = @PackReversed
    WHERE ID = @ID;
    SELECT * FROM [dbo].[POReceiptViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO

-- End POReceipt Store Procedure