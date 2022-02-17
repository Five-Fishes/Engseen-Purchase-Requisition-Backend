-- Start POHeader Store Procedure
-- Insert POHeader
CREATE PROCEDURE POHeaderInsert (
    @PONumber VARCHAR(30), @VendorID VARCHAR(12), @Buyer VARCHAR(8), @Contact VARCHAR(38), @Phone VARCHAR(30), @OurContact VARCHAr(30), 
    @OrderStatus CHAR(1), @OriginalPODate DATETIME, @PORevisionDate DATETIME, @POReference VARCHAR(20), @PORevision VARCHAR(2), @LocationID INTEGER,
    @ShipTo VARCHAR(60), @Address1 VARCHAR(60), @Address2 VARCHAR(60), @City VARCHAR(30), @State VARCHAR(20), @ZipCode VARCHAR(24), 
    @Country VARCHAR(30), @ShipVia VARCHAR(40), @FOBPoint VARCHAR(40), @StandardTerms CHAR(1), @Cash1Percent DECIMAL(18, 0), @Cash1Days INTEGER, 
    @Cash2Percent DECIMAL(18, 0), @Cash2Days INTEGER, @NetDays INTEGER, @DueDay INTEGER, @CutoffDay INTEGER, @MonthsDelay INTEGER, 
    @BlanketOrder CHAR(1), @PrintPO CHAR(1), @Contract VARCHAR(42), @ControllingCurrency CHAR(1), @CurrencyCode VARCHAR(10), @ExchangeRate DECIMAL(18, 0), 
    @Remark VARCHAR(480), @Less1 VARCHAR(50), @Less1Amount DECIMAL(18, 0), @Less2 VARCHAR(50), @Less2Amount DECIMAL(18, 0), @OrderTotal DECIMAL(18, 0), 
    @NoOfLines INTEGER, @PrintPONo INTEGER, @CounterID INTEGER, @POType CHAR(1), @ApprovalStatus CHAR(1), @CurrentApprover VARCHAR(8), 
    @Imported CHAR(1), @GST INTEGER, @Created DATETIME, @CreatedBy VARCHAR(8), @Modified DATETIME, @ModifiedBy VARCHAR(8), 
    @Accessed DATETIME, @AccessedBy VARCHAR(8), @PurchaseRequestApprovalId BIGINT, @Emailed BIT, @Downloaded BIT
)
AS
    BEGIN
        SET XACT_ABORT ON;
            INSERT INTO [dbo].[POHeaderViewLegacy]
                (PONumber, VendorID, Buyer, Contact, Phone, OurContact, 
                OrderStatus, OriginalPODate, PORevisionDate, POReference, PORevision, LocationID, 
                ShipTo, Address1, Address2, City, [State], ZipCode, 
                Country, ShipVia, FOBPoint, StandardTerms, Cash1Percent, Cash1Days, 
                Cash2Percent, Cash2Days, NetDays, DueDay, CutoffDay, MonthsDelay, 
                BlanketOrder, PrintPO, [Contract], ControllingCurrency, CurrencyCode, ExchangeRate, 
                Remark, Less1, Less1Amount, Less2, Less2Amount, OrderTotal, 
                NoOfLines, PrintPONo, CounterID, POType, ApprovalStatus, CurrentApprover, 
                Imported, GST, Created, CreatedBy, Modified, ModifiedBy, 
                Accessed, AccessedBy, PurchaseRequestApprovalId, Emailed, Downloaded)
            VALUES
                (@PONumber, @VendorID, @Buyer, @Contact, @Phone, @OurContact, 
                @OrderStatus, @OriginalPODate, @PORevisionDate, @POReference, @PORevision, @LocationID,
                @ShipTo, @Address1, @Address2, @City, @State, @ZipCode, 
                @Country, @ShipVia, @FOBPoint, @StandardTerms, @Cash1Percent, @Cash1Days, 
                @Cash2Percent, @Cash2Days, @NetDays, @DueDay, @CutoffDay, @MonthsDelay, 
                @BlanketOrder, @PrintPO, @Contract, @ControllingCurrency, @CurrencyCode, @ExchangeRate, 
                @Remark, @Less1, @Less1Amount, @Less2, @Less2Amount, @OrderTotal, 
                @NoOfLines, @PrintPONo, @CounterID, @POType, @ApprovalStatus, @CurrentApprover, 
                @Imported, @GST, @Created, @CreatedBy, @Modified, @ModifiedBy, 
                @Accessed, @AccessedBy, @PurchaseRequestApprovalId, @Emailed, @Downloaded);
        SET XACT_ABORT OFF;
    END

-- Update POHeader
CREATE PROCEDURE POHeaderUpdate (@ID INTEGER, 
    @PONumber VARCHAR(30), @VendorID VARCHAR(12), @Buyer VARCHAR(8), @Contact VARCHAR(38), @Phone VARCHAR(30), @OurContact VARCHAr(30), 
    @OrderStatus CHAR(1), @OriginalPODate DATETIME, @PORevisionDate DATETIME, @POReference VARCHAR(20), @PORevision VARCHAR(2), @LocationID INTEGER,
    @ShipTo VARCHAR(60), @Address1 VARCHAR(60), @Address2 VARCHAR(60), @City VARCHAR(30), @State VARCHAR(20), @ZipCode VARCHAR(24), 
    @Country VARCHAR(30), @ShipVia VARCHAR(40), @FOBPoint VARCHAR(40), @StandardTerms CHAR(1), @Cash1Percent DECIMAL(18, 0), @Cash1Days INTEGER, 
    @Cash2Percent DECIMAL(18, 0), @Cash2Days INTEGER, @NetDays INTEGER, @DueDay INTEGER, @CutoffDay INTEGER, @MonthsDelay INTEGER, 
    @BlanketOrder CHAR(1), @PrintPO CHAR(1), @Contract VARCHAR(42), @ControllingCurrency CHAR(1), @CurrencyCode VARCHAR(10), @ExchangeRate DECIMAL(18, 0), 
    @Remark VARCHAR(480), @Less1 VARCHAR(50), @Less1Amount DECIMAL(18, 0), @Less2 VARCHAR(50), @Less2Amount DECIMAL(18, 0), @OrderTotal DECIMAL(18, 0), 
    @NoOfLines INTEGER, @PrintPONo INTEGER, @CounterID INTEGER, @POType CHAR(1), @ApprovalStatus CHAR(1), @CurrentApprover VARCHAR(8), 
    @Imported CHAR(1), @GST INTEGER, @Created DATETIME, @CreatedBy VARCHAR(8), @Modified DATETIME, @ModifiedBy VARCHAR(8), 
    @Accessed DATETIME, @AccessedBy VARCHAR(8), @PurchaseRequestApprovalId BIGINT, @Emailed BIT, @Downloaded BIT
)
AS
    BEGIN
        SET XACT_ABORT ON;
            UPDATE [dbo].[POHeaderViewLegacy]
            SET PONumber = @PONumber, VendorID = @VendorID, Buyer = @Buyer, 
                Contact = @Contact, Phone = @Phone, OurContact = @OurContact, 
                OrderStatus = @OrderStatus, OriginalPODate = @OriginalPODate, PORevisionDate = @PORevisionDate, 
                POReference = @POReference, PORevision = @PORevision, LocationID = @LocationID, 
                ShipTo = @ShipTo, Address1 = @Address1, Address2 = @Address2, 
                City = @City, [State] = @State, ZipCode = @ZipCode, 
                Country = @Country, ShipVia = @ShipVia, FOBPoint = @FOBPoint, 
                StandardTerms = @StandardTerms, Cash1Percent = @Cash1Percent, Cash1Days = @Cash1Days, 
                Cash2Percent = @Cash2Percent, Cash2Days = @Cash2Days, NetDays = @NetDays, 
                DueDay = @DueDay, CutoffDay = @CutoffDay, MonthsDelay = @MonthsDelay, 
                BlanketOrder = @BlanketOrder, PrintPO = @PrintPO, [Contract] = @Contract, 
                ControllingCurrency = @ControllingCurrency, CurrencyCode = @CurrencyCode, ExchangeRate = @ExchangeRate, 
                Remark = @Remark, Less1 = @Less1, Less1Amount = @Less1Amount, 
                Less2 = @Less2, Less2Amount = @Less2Amount, OrderTotal = @OrderTotal, 
                NoOfLines = @NoOfLines, PrintPONo = @PrintPONo, CounterID = @CounterID, 
                POType = @POType, ApprovalStatus = @ApprovalStatus, CurrentApprover = @CurrentApprover, 
                Imported = @Imported, GST = @GST, Created = @Created, 
                CreatedBy = @CreatedBy, Modified = @Modified, ModifiedBy = @ModifiedBy, 
                Accessed = @Accessed, AccessedBy = @AccessedBy, PurchaseRequestApprovalId = @PurchaseRequestApprovalId, 
                Emailed = @Emailed, Downloaded = @Downloaded)
            WHERE ID = @ID;
        SET XACT_ABORT OFF;
    END

-- Delete POHeader
CREATE PROCEDURE POHeaderDelete (@ID INTEGER)
AS
    BEGIN
        SET XACT_ABORT ON;
            DELETE FROM [dbo].[POHeaderViewLegacy]
            WHERE ID = @ID;
        SET XACT_ABORT OFF;
    END

-- End POHeader Store Procedure

-- Start PODetail Store Procedure
-- Insert PODetail
CREATE PROCEDURE PODetailInsert (
    @PONumber VARCHAR(30), @LineNumber INTEGER, @Item VARCHAR(30), @LineType CHAR(1), @LineSelector CHAR(1), @OrderQuantity DECIMAL(18, 0), 
    @QuantityReceived DECIMAL(18, 0), @QuantityInInspection DECIMAL(18, 0), @QuantityOnHand DECIMAL(18, 0), @QuantityOnHold DECIMAL(18, 0), @BlanketQuantity DECIMAL(18, 0), @ETADate DATETIME,
    @NeedDate DATETIME, @DateLastReceipt DATETIME, @LeadTime INTEGER, @Discount INTEGER, @LineStatus CHAR(1), @UnitPrice DECIMAL(18, 0), 
    @ExtendedPrice DECIMAL(18, 0), @Remark VARCHAR(480), @VendorItem VARCHAR(30), @VIDescription VARCHAR(60), @VIConversion DECIMAL(18, 0), @VIUnitOfMeasure VARCHAR(4), 
    @VIOrderQuantity DECIMAL(18, 0), @VIUnitPrice DECIMAL(18, 0), @ItemFailure VARCHAR(20), @PrintUOM VARCHAR(4), @DepartmentCode VARCHAR(6), @SegmentCode VARCHAR(6), 
    @Created DATETIME, @CreatedBy VARCHAR(8), @Modified DATETIME, @ModifiedBy VARCHAR(8)
)
AS
    BEGIN
        SET XACT_ABORT ON;
            INSERT INTO [dbo].[PODetailViewLegacy]
                (PONumber, LineNumber, Item, LineType, LineSelector, OrderQuantity, 
                QuantityReceived, QuantityInInspection, QuantityOnHand, QuantityOnHold, BlanketQuantity, ETADate, 
                NeedDate, DateLastReceipt, LeadTime, Discount, LineStatus, UnitPrice, 
                ExtendedPrice, Remark, VendorItem, VIDescription, VIConversion, VIUnitOfMeasure, 
                VIOrderQuantity, VIUnitPrice, ItemFailure, PrintUOM, DepartmentCode, SegmentCode, 
                Created, CreatedBy, Modified, ModifiedBy)
            VALUES
                (@PONumber, @LineNumber, @Item, @LineType, @LineSelector, @OrderQuantity, 
                @QuantityReceived, @QuantityInInspection, @QuantityOnHand, @QuantityOnHold, @BlanketQuantity, @ETADate,
                @NeedDate, @DateLastReceipt, @LeadTime, @Discount, @LineStatus, @UnitPrice, 
                @ExtendedPrice, @Remark, @VendorItem, @VIDescription, @VIConversion, @VIUnitOfMeasure, 
                @VIOrderQuantity, @VIUnitPrice, @ItemFailure, @PrintUOM, @DepartmentCode, @SegmentCode, 
                @Created, @CreatedBy, @Modified, @ModifiedBy);
        SET XACT_ABORT OFF;
    END

-- Update PODetail
CREATE PROCEDURE PODetailUpdate (@ID INTEGER, 
    @PONumber VARCHAR(30), @LineNumber INTEGER, @Item VARCHAR(30), @LineType CHAR(1), @LineSelector CHAR(1), @OrderQuantity DECIMAL(18, 0), 
    @QuantityReceived DECIMAL(18, 0), @QuantityInInspection DECIMAL(18, 0), @QuantityOnHand DECIMAL(18, 0), @QuantityOnHold DECIMAL(18, 0), @BlanketQuantity DECIMAL(18, 0), @ETADate DATETIME,
    @NeedDate DATETIME, @DateLastReceipt DATETIME, @LeadTime INTEGER, @Discount INTEGER, @LineStatus CHAR(1), @UnitPrice DECIMAL(18, 0), 
    @ExtendedPrice DECIMAL(18, 0), @Remark VARCHAR(480), @VendorItem VARCHAR(30), @VIDescription VARCHAR(60), @VIConversion DECIMAL(18, 0), @VIUnitOfMeasure VARCHAR(4), 
    @VIOrderQuantity DECIMAL(18, 0), @VIUnitPrice DECIMAL(18, 0), @ItemFailure VARCHAR(20), @PrintUOM VARCHAR(4), @DepartmentCode VARCHAR(6), @SegmentCode VARCHAR(6), 
    @Created DATETIME, @CreatedBy VARCHAR(8), @Modified DATETIME, @ModifiedBy VARCHAR(8)
)
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
                ModifiedBy = @ModifiedBy)
            WHERE ID = @ID;
        SET XACT_ABORT OFF;
    END

-- Delete PODetail
CREATE PROCEDURE PODetailDelete (@ID INTEGER)
AS
    BEGIN
        SET XACT_ABORT ON;
            DELETE FROM [dbo].[PODetailViewLegacy]
            WHERE ID = @ID;
        SET XACT_ABORT OFF;
    END

-- End PODetail Store Procedure
