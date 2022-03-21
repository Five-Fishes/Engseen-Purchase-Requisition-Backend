-- Start Inventory Store Procedure
-- Insert Inventory
CREATE PROCEDURE InventoryInsert  
    @Item VARCHAR(30), @StoreNo VARCHAR(4), @StoreBin VARCHAR(12), @InventoryCode CHAR(1), @Quantity DECIMAL(18, 0), @UnitCost DECIMAL(18, 0),
    @InspectionCode CHAR(1), @ReceiptID INTEGER, @ReceiptDate DATETIME, @VendorID VARCHAR(12), @LotNo VARCHAR(20), @GRNNo VARCHAR(20), 
    @ReferenceNo VARCHAR(20), @ReferenceNo2 VARCHAR(20), @OrderType CHAR(1), @OrderNumber VARCHAR(30), @LineNumber INTEGER, @FromID INTEGER, 
    @ToOrderType CHAR(1), @ToOrderNumber VARCHAR(30), @ToLineNumber INTEGER, @Weight DECIMAL(18, 0), @SellingPrice DECIMAL(18, 0), @FUnitCost DECIMAL(18, 0), 
    @FCurrencyCode VARCHAR(10), @FExchangeRate DECIMAL(18, 0), @Created DATETIME, @CreatedBy VARCHAR(8)
AS
BEGIN
    DECLARE @ID INTEGER;
    SET XACT_ABORT ON;
        INSERT INTO [dbo].[InventoryViewLegacy]
        (Item, StoreNo, StoreBin, InventoryCode, Quantity, UnitCost,
	    InspectionCode, ReceiptID, ReceiptDate, VendorID, LotNo, GRNNo, 
	    ReferenceNo, ReferenceNo2, OrderType, OrderNumber, LineNumber, FromID, 
	    ToOrderType, ToOrderNumber, ToLineNumber, Weight, SellingPrice, FUnitCost, 
	    FCurrencyCode, FExchangeRate, Created, CreatedBy)
    VALUES
    (@Item, @StoreNo, @StoreBin, @InventoryCode, @Quantity, @UnitCost,
    @InspectionCode, @ReceiptID, @ReceiptDate, @VendorID, @LotNo, @GRNNo, 
    @ReferenceNo, @ReferenceNo2, @OrderType, @OrderNumber, @LineNumber, @FromID, 
    @ToOrderType, @ToOrderNumber, @ToLineNumber, @Weight, @SellingPrice, @FUnitCost, 
    @FCurrencyCode, @FExchangeRate, @Created, @CreatedBy);
	SELECT @ID = SCOPE_IDENTITY();
	SELECT * FROM [dbo].[InventoryViewLegacy]
	   	WHERE ID = @ID;
	   	SET XACT_ABORT OFF;
END
GO

-- Create InventoryUpdate
CREATE PROCEDURE InventoryUpdate @ID INTEGER, 
     @Item VARCHAR(30), @StoreNo VARCHAR(4), @StoreBin VARCHAR(12), @InventoryCode CHAR(1), @Quantity DECIMAL(18, 0), @UnitCost DECIMAL(18, 0),
     @InspectionCode CHAR(1), @ReceiptID INTEGER, @ReceiptDate DATETIME, @VendorID VARCHAR(12), @LotNo VARCHAR(20), @GRNNo VARCHAR(20), 
     @ReferenceNo VARCHAR(20), @ReferenceNo2 VARCHAR(20), @OrderType CHAR(1), @OrderNumber VARCHAR(30), @LineNumber INTEGER, @FromID INTEGER, 
     @ToOrderType CHAR(1), @ToOrderNumber VARCHAR(30), @ToLineNumber INTEGER, @Weight DECIMAL(18, 0), @SellingPrice DECIMAL(18, 0), @FUnitCost DECIMAL(18, 0), 
     @FCurrencyCode VARCHAR(10), @FExchangeRate DECIMAL(18, 0), @Created DATETIME, @CreatedBy VARCHAR(8)
AS
BEGIN
    SET XACT_ABORT ON;
    UPDATE [dbo].[InventoryViewLegacy]
    SET Item = @Item, StoreNo = @StoreNo, StoreBin = @StoreBin, InventoryCode = @InventoryCode, Quantity = @Quantity, UnitCost = @UnitCost,
	    InspectionCode = @InspectionCode, ReceiptID = @ReceiptID, ReceiptDate = @ReceiptDate, VendorID = @VendorID, LotNo = @LotNO, GRNNo = @GRNNo, 
	    ReferenceNo = @ReferenceNo, ReferenceNo2 = @ReferenceNo2, OrderType = @OrderType, OrderNumber = @OrderNumber, LineNumber = @LineNumber, FromID = @FromID, 
	    ToOrderType = @ToOrderType, ToOrderNumber = @ToOrderNumber, ToLineNumber = @ToLineNumber, Weight = @Weight, SellingPrice = @SellingPrice, FUnitCost = @FUnitCost, 
	    FCurrencyCode = @FCurrencyCode, FExchangeRate = @FExchangeRate, Created = @Created, CreatedBy = @CreatedBy
    WHERE ID = @ID;
    SELECT * FROM [dbo].[InventoryViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO

-- Inventory Delete
CREATE PROCEDURE InventoryDelete @ID INTEGER
AS
BEGIN
    SET XACT_ABORT ON;
    DELETE FROM [dbo].[InventoryViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO


-- End Inventory Store Procedure
