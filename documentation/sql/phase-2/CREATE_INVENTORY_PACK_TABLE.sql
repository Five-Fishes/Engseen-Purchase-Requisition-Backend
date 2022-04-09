-- Create a new table called '[InventoryPack]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[InventoryPack]', 'U') IS NOT NULL
    DROP TABLE [dbo].[InventoryPack]
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[InventoryPack]
(
    [ID]       INTEGER IDENTITY (1,1) NOT NULL,
    [Item]     VARCHAR(30) NOT NULL,
    [StoreNo]  VARCHAR(4) NOT NULL,
    [StoreBin] VARCHAR(12) NOT NULL,
    [Pack]     INTEGER,
)
GO

create view [dbo].[InventoryPackViewLegacy]
as
select *
from InventoryPack;
GO
