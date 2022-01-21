-- Create a new table called '[ItemMaster]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[ItemMaster]', 'U') IS NOT NULL
DROP TABLE [dbo].[ItemMaster]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[ItemMaster]
(
    [ID] int IDENTITY(1,1) ,
    [Item] varchar(30),
    [ItemDescription] varchar(70),
    [UnitOfMeasure] varchar(4),
    [RevisionLevel] varchar(2) ,
    [MakeBuyCode] char(1),
    [ItemType] char(1),
    [ItemStatus] char(1),
    [LotTrace] char(1),
    [Serialization] char(1),
    [OrderPolicy] char(1),
    [InspectionRequired] char(1),
    [Drawing] varchar(30) ,
    [ItemClassifications] char(1) ,
    [Reference1] varchar(30) ,
    [Reference2] varchar(30) ,
    [Reference3] varchar(30) ,
    [Reference4] varchar(30) ,
    [ItemShippingWeight] decimal,
    [ItemShippingVolumn] decimal,
    [ItemPackageType] varchar(4) ,
    [ItemPiecesPerPackage] decimal,
    [ItemGrossWeight] decimal ,
    [LotAssignmentPolicy] char(1) ,
    [LotDefaultPolicy] char(1) ,
    [FIFOInventoryPolicy] char(1) ,
    [BackflushPolicy] char(1) ,
    [AvailableCalendarDays] int ,
    [ShelfLifeCalendarDays] int ,
    [RetestCalendarDays] int ,
    [LastLot] int ,
    [LotMask] varchar(20) ,
    [DefaultLot] varchar(20) ,
    [LotCounter] char(1) ,
    [SerialNumberMask] varchar(20) ,
    [DefaultSerialNumber] varchar(20) ,
    [SerialNumberCounter] char(1) ,
    [PlannerBuyer] varchar(8),
    [RunLeadTime] int,
    [FixedLeadTime] int,
    [InspectionLeadTime] int,
    [PlanLeadTime] int ,
    [LotSizeDay] int,
    [LotSizeQuantity] decimal,
    [SafetyStock] decimal,
    [MinimumLotSize] decimal,
    [MultipleLotSize] decimal,
    [PreferredStoreNo] varchar(4) ,
    [PreferredStoreBin] varchar(12) ,
    [ForecastCode] char(1),
    [ForecastPeriod] char(1),
    [ItemYieldFactor] int,
    [DecimalPrecisionCode] int,
    [LowLevelCode] int,
    [Remark1] varchar(480) ,
    [Remark2] varchar(480) ,
    [Remark3] varchar(480) ,
    [InventoryAccountNo] varchar(20),
    [SalesAccountNo] varchar(20),
    [COGSAccountNo] varchar(20),
    [AverageSellingPrice] decimal,
    [CostCode] int,
    [MaterialCost] decimal,
    [LaborCost] decimal,
    [VariableOverheadCost] decimal,
    [FixedOverheadCost] decimal,
    [TotalCost] decimal,
    [RolledMaterialCost] decimal,
    [RolledLaborCost] decimal,
    [RolledVariableOverheadCost] decimal,
    [RolledFixedOverheadCost] decimal,
    [TotalRolledCost] decimal,
    [StandardUnitPrice] decimal,
    [Label1] varchar(50) ,
    [Label2] varchar(50) ,
    [MinimumSellingPrice] decimal ,
    [LastSerialNumber] int ,
    [MRPPriority] int ,
    [Created] datetime ,
    [CreatedBy] varchar(8) ,
    [Modified] datetime ,
    [ModifiedBy] varchar(8) ,
    [Accessed] datetime ,
    [AccessedBy] varchar(8)
    );
GO

-- Create a new table called '[VendorMaster]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[VendorMaster]', 'U') IS NOT NULL
DROP TABLE [dbo].[VendorMaster]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[VendorMaster]
(
    [ID] int IDENTITY ,
    [VendorID] varchar(12),
    [VendorName] varchar(60),
    [Contact] varchar(38),
    [Phone] varchar(30),
    [FaxNumber] varchar(30),
    [Approval] char(1),
    [Print] char(1),
    [VendorRevision] varchar(2),
    [VendorStatus] char(1),
    [Address1] varchar(60),
    [Address2] varchar(60),
    [City] varchar(30),
    [State] varchar(20),
    [ZipCode] varchar(24),
    [Country] varchar(30),
    [AccountingContactName] varchar(40),
    [AccountingContactPhone] varchar(30),
    [Payee] varchar(60),
    [PayeeAddress1] varchar(60),
    [PayeeAddress2] varchar(60),
    [PayeeCity] varchar(30),
    [PayeeState] varchar(20),
    [PayeeZipCode] varchar(24),
    [PayeeCountry] varchar(30),
    [BankName] varchar(60),
    [BankAccount] varchar(60),
    [StandardTerms] char(1),
    [Cash1Percent] decimal,
    [Cash1Days] int,
    [Cash2Percent] decimal,
    [Cash2Days] int,
    [NetDays] int,
    [DueDay] int,
    [CutoffDay] int,
    [MonthsDelay] int,
    [CurrencyCode] varchar(10),
    [ControllingCurrency] char(1),
    [Remark1] varchar(60),
    [Remark2] varchar(60),
    [Remark3] varchar(600),
    [RegionCode] varchar(12),
    [OIorBF] char(1),
    [GSTNo] varchar(13),
    [Created] datetime,
    [CreatedBy] varchar(8),
    [Modified] datetime,
    [ModifiedBy] varchar(8),
    [Accessed] datetime,
    [AccessedBy] varchar(8)
    );
GO

-- Create a new table called '[VendorItem]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[VendorItem]', 'U') IS NOT NULL
DROP TABLE [dbo].[VendorItem]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[VendorItem]
(
    [ID] int IDENTITY(1,1) ,
    [VendorID] varchar(12),
    [Item] varchar(30),
    [VendorItem] varchar(30),
    [VIDescription] varchar(60),
    [VIConversion] decimal,
    [VIUnitOfMeasure] varchar(4),
    [VIUnitPrice] decimal,
    [EffectiveDate] datetime,
    [RevisionNo] varchar(2),
    [Created] datetime,
    [CreatedBy] varchar(8),
    [Modified] datetime,
    [ModifiedBy] varchar(8)
    );
GO

-- Create a new table called '[Inventory]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[Inventory]', 'U') IS NOT NULL
DROP TABLE [dbo].[Inventory]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[Inventory]
(
    [ID] int IDENTITY(1,1) ,
    [Item] varchar(30),
    [StoreNo] varchar(4),
    [StoreBin] varchar(12),
    [InventoryCode] char(1),
    [Quantity] decimal,
    [UnitCost] decimal,
    [InspectionCode] char(1),
    [ReceiptID] int,
    [ReceiptDate] datetime,
    [VendorID] varchar(12),
    [LotNo] varchar(20),
    [GRNNo] varchar(20),
    [ReferenceNo] varchar(20),
    [ReferenceNo2] varchar(20),
    [OrderType] char(1),
    [OrderNumber] varchar(30),
    [LineNumber] int,
    [FromID] int,
    [ToOrderType] char(1),
    [ToOrderNumber] varchar(30),
    [ToLineNumber] int,
    [Weight] decimal,
    [SellingPrice] decimal,
    [FUnitCost] decimal,
    [FCurrencyCode] varchar(10),
    [FExchangeRate] decimal,
    [Created] datetime,
    [CreatedBy] varchar(8),
    );
GO

-- Create a new table called '[PODetail]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[PODetail]', 'U') IS NOT NULL
DROP TABLE [dbo].[PODetail]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[PODetail]
(
    [ID]                   int         NOT NULL IDENTITY (1,1),
    [PONumber]             varchar(30) NOT NULL,
    [LineNumber]           int         NOT NULL,
    [Item]                 varchar(30) NOT NULL,
    [LineType]             char(1)     NOT NULL,
    [LineSelector]         char(1)     NOT NULL,
    [OrderQuantity]        decimal     NOT NULL,
    [QuantityReceived]     decimal     NOT NULL,
    [QuantityInInspection] decimal     NOT NULL,
    [QuantityOnHand]       decimal     NOT NULL,
    [QuantityOnHold]       decimal     NOT NULL,
    [BlanketQuantity]      decimal     NOT NULL,
    [ETADate]              datetime    NOT NULL,
    [NeedDate]             datetime,
    [DateLastReceipt]      datetime,
    [LeadTime]             int,
    [Discount]             int,
    [LineStatus]           char(1)     NOT NULL,
    [UnitPrice]            decimal     NOT NULL,
    [ExtendedPrice]        decimal     NOT NULL,
    [Remark]               varchar(480),
    [VendorItem]           varchar(30),
    [VIDescription]        varchar(60),
    [VIConversion]         decimal,
    [VIUnitOfMeasure]      varchar(4),
    [VIOrderQuantity]      decimal,
    [VIUnitPrice]          decimal,
    [ItemFailure]          varchar(20),
    [PrintUOM]             varchar(4),
    [DepartmentCode]       varchar(6),
    [SegmentCode]          varchar(6),
    [Created]              datetime,
    [CreatedBy]            varchar(8),
    [Modified]             datetime,
    [ModifiedBy]           varchar(8),
    );
GO

-- Create a new table called '[POHeader]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[POHeader]', 'U') IS NOT NULL
DROP TABLE [dbo].[POHeader]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[POHeader]
(
    [ID]                  int         NOT NULL IDENTITY (1,1),
    [PONumber]            varchar(30) NOT NULL,
    [VendorID]            varchar(12) NOT NULL,
    [Buyer]               varchar(8)  NOT NULL,
    [Contact]             varchar(38),
    [Phone]               varchar(30),
    [OurContact]          varchar(30),
    [OrderStatus]         char(1)     NOT NULL,
    [OriginalPODate]      datetime    NOT NULL,
    [PORevisionDate]      datetime    NOT NULL,
    [POReference]         varchar(20),
    [PORevision]          varchar(2),
    [LocationID]          int,
    [ShipTo]              varchar(60),
    [Address1]            varchar(60),
    [Address2]            varchar(60),
    [City]                varchar(30),
    [State]               varchar(20),
    [ZipCode]             varchar(24),
    [Country]             varchar(30),
    [ShipVia]             varchar(40),
    [FOBPoint]            varchar(40),
    [StandardTerms]       char(1)     NOT NULL,
    [Cash1Percent]        decimal     NOT NULL,
    [Cash1Days]           int         NOT NULL,
    [Cash2Percent]        decimal     NOT NULL,
    [Cash2Days]           int         NOT NULL,
    [NetDays]             int         NOT NULL,
    [DueDay]              int         NOT NULL,
    [CutoffDay]           int         NOT NULL,
    [MonthsDelay]         int         NOT NULL,
    [BlanketOrder]        char(1)     NOT NULL,
    [PrintPO]             char(1)     NOT NULL,
    [Contract]            varchar(42),
    [ControllingCurrency] char(1)     NOT NULL,
    [CurrencyCode]        varchar(10) NOT NULL,
    [ExchangeRate]        decimal     NOT NULL,
    [Remark]              varchar(480),
    [Less1]               varchar(50),
    [Less1Amount]         decimal,
    [Less2]               varchar(50),
    [Less2Amount]         decimal,
    [OrderTotal]          decimal     NOT NULL,
    [NoOfLines]           int,
    [PrintPONo]           int,
    [CounterID]           int,
    [POType]              char(1),
    [ApprovalStatus]      char(1),
    [CurrentApprover]     varchar(8),
    [Imported]            char(1),
    [GST]                 int,
    [Created]             datetime,
    [CreatedBy]           varchar(8),
    [Modified]            datetime,
    [ModifiedBy]          varchar(8),
    [Accessed]            datetime,
    [AccessedBy]          varchar(8),
    );
GO




-- ATTENTION --
-- New tables below, To be executed to real db

-- Create a new table called '[PurchaseRequisitionTemplate]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[PurchaseRequisitionTemplate]', 'U') IS NOT NULL
DROP TABLE [dbo].[PurchaseRequisitionTemplate]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[PurchaseRequisitionTemplate]
(
    [Id] BIGINT IDENTITY(1,1) ,
    [TemplateName] varchar(100) ,
    [Remarks] varchar(1000) ,
    );
GO

-- Create a new table called '[PurchaseRequisitionRequest]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[PurchaseRequisitionRequest]', 'U') IS NOT NULL
DROP TABLE [dbo].[PurchaseRequisitionRequest]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[PurchaseRequisitionRequest]
(
    [Id] BIGINT IDENTITY(1,1) ,
    [CreatedDate] DATETIME,
    [TemplateId] BIGINT,
    [Remarks] varchar(1000) NOT NULL DEFAULT '',
    );
GO

-- Create a new table called '[PurchaseRequisitionApproval]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[PurchaseRequisitionApproval]', 'U') IS NOT NULL
DROP TABLE [dbo].[PurchaseRequisitionApproval]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[PurchaseRequisitionApproval]
(
    [Id] BIGINT IDENTITY(1,1),
    [CreatedDate] DATETIME,
    [Remarks] varchar(1000),
    );
GO

-- Create a new table called '[PurchaseRequisitionTemplateItem]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[PurchaseRequisitionTemplateItem]', 'U') IS NOT NULL
DROP TABLE [dbo].[PurchaseRequisitionTemplateItem]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[PurchaseRequisitionTemplateItem]
(
    [Id] BIGINT IDENTITY(1,1) ,
    [PurchaseRequisitionTemplateId] BIGINT,
    [Sequence] int,
    [ComponentCode] VARCHAR(100),
    [ComponentName] varchar(100),
    [VendorId] VARCHAR(100),
    [VendorName] varchar(100),
    [PackagingSize] decimal,
    );
GO

-- Create a new table called '[PurchaseRequisitionRequestItem]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[PurchaseRequisitionRequestItem]', 'U') IS NOT NULL
DROP TABLE [dbo].[PurchaseRequisitionRequestItem]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[PurchaseRequisitionRequestItem]
(
    [Id] BIGINT IDENTITY(1,1) ,
    [PurchaseRequisitionRequestId] BIGINT,
    [ComponentCode] VARCHAR(100),
    [ComponentName] VARCHAR(100),
    [VendorId] VARCHAR(100),
    [VendorName] VARCHAR(100),
    [StockBalance] DECIMAL,
    [PackagingSize] DECIMAL,
    [NoOfPacks] DECIMAL,
    [Quantity] DECIMAL,
    [DeliveryDate] DATETIME,
    );
GO

-- Create a new table called '[PurchaseRequisitionApprovalItem]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[PurchaseRequisitionApprovalItem]', 'U') IS NOT NULL
DROP TABLE [dbo].[PurchaseRequisitionApprovalItem]
    GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[PurchaseRequisitionApprovalItem]
(
    [Id] BIGINT IDENTITY(1,1) ,
    [PurchaseRequisitionApprovalId] BIGINT,
    [ItemCost] DECIMAL,
    [Status] INT,
    [Balance] DECIMAL,
    [ComponentCode] VARCHAR(100),
    [ComponentName] VARCHAR(100),
    [VendorId] VARCHAR(100),
    [VendorName] VARCHAR(100),
    [StockBalance] DECIMAL,
    [PackagingSize] DECIMAL,
    [NoOfPacks] DECIMAL,
    [Quantity] DECIMAL,
    [DeliveryDate] DATETIME,
    );
GO

ALTER TABLE [dbo].[POHeader]
ADD 
PurchaseRequestApprovalId BIGINT,
Emailed BIT,
Downloaded BIT;
GO
