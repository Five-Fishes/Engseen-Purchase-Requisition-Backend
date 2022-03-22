
IF OBJECT_ID('[dbo].[InventoryReceiptHeader]', 'U') IS NOT NULL
DROP TABLE [dbo].[InventoryReceiptHeader]
GO

Create Table [dbo].[InventoryReceiptHeader]
(
	[ID] int IDENTITY(1,1) NOT NULL,
	[IRNNo] varchar(20) NOT NULL,
	[IRNDate] datetime NOT NULL,
	[CustomerID] varchar(12),
	[DONumber] varchar(30),
	[Remark] varchar(480),
	[Created] datetime,
    [CreatedBy] varchar(8),
    [Modified] datetime,
    [ModifiedBy] varchar(8),
    [Accessed] datetime,
    [AccessedBy] varchar(8)
);
GO


IF OBJECT_ID('[dbo].[InventoryReceipt]', 'U') IS NOT NULL
DROP TABLE [dbo].[InventoryReceipt]
GO

Create Table [dbo].[InventoryReceipt]
(
	[ID] int IDENTITY(1,1) NOT NULL,
	[IRNNo] varchar(20) NOT NULL,
	[Item] varchar(30) NOT NULL,
	[StoreNo] varchar(4) NOT NULL,
	[StoreBin] varchar(12) NOT NULL,
	[ReceiptQuantity] decimal NOT NULL,
	[Weight] decimal NOT NULL,
	[IID] int NOT NULL,
	[Created] datetime ,
    [CreatedBy] varchar(8) 
);
GO

create view [dbo].[InventoryReceiptHeaderViewLegacy]
as
select *
from InventoryReceiptHeader;
GO

create view [dbo].[InventoryReceiptViewLegacy]
as
select *
from InventoryReceipt;
GO
