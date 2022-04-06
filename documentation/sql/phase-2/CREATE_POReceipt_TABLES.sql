
IF OBJECT_ID('[dbo].[POReceipt]', 'U') IS NOT NULL
DROP TABLE [dbo].[POReceipt]
GO

Create Table [dbo].[POReceipt]
(
	[ID] int IDENTITY(1,1) NOT NULL,
	[GRNNo] varchar(20) NOT NULL,
	[PID] int NOT NULL,
	[QuantityReceived] decimal NOT NULL,
	[QuantityReversed] decimal,
	[UnitCost] decimal,
	[OrigUnitCost] decimal,
	[InspectionCode] char(1),
	[IID] int,
	[StoreNo] varchar(4),
	[StoreBin] varchar(12),
	[InventoryCode] char(1),
	[LotNo] varchar(20),
	[IRID] int,
	[Created] datetime ,
    [CreatedBy] varchar(8) 
);
GO


IF OBJECT_ID('[dbo].[POReceiptHeader]', 'U') IS NOT NULL
DROP TABLE [dbo].[POReceiptHeader]
GO

Create Table [dbo].[POReceiptHeader]
(
	[ID] int IDENTITY(1,1) NOT NULL,
	[GRNNo] varchar(20) NOT NULL,
	[GRNDate] datetime NOT NULL,
	[Status] char(1) NOT NULL,
	[VendorID] varchar(12) NOT NULL,
	[ExchangeRate] decimal,
	[TransportVia] varchar(30),
	[FreightBillNumber] varchar(30),
	[PackingListNumber] varchar(30),
	[GRNReference] varchar(12),
	[DiscountAmount] decimal,
	[Remark] varchar(480),
	[GRNType] char(1),
	[InvoiceAmount] decimal,
	[Hold] char(1),
	[Paid] char(1),
	[Posted] char(1),
	[Created] datetime,
    [CreatedBy] varchar(8),
    [Modified] datetime,
    [ModifiedBy] varchar(8),
    [Accessed] datetime,
    [AccessedBy] varchar(8),
    [CustomFormDate] smalldatetime,
    [CIFValue] decimal,
    [CustomFormNo] varchar(20)
);
GO

--- Alter Decimal column with scale
ALTER TABLE [dbo].[POReceiptHeader]
ALTER COLUMN [ExchangeRate] decimal(18, 5);
GO
ALTER TABLE [dbo].[POReceiptHeader]
ALTER COLUMN [DiscountAmount] decimal(18, 2);
GO
ALTER TABLE [dbo].[POReceiptHeader]
ALTER COLUMN [InvoiceAmount] decimal(18, 2);
GO

ALTER TABLE [dbo].[POReceipt]
ALTER COLUMN [UnitCost] decimal(18, 2);
GO
ALTER TABLE [dbo].[POReceipt]
ALTER COLUMN [OrigUnitCost] decimal(18, 2);
GO
