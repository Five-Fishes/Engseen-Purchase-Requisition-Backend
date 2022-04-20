-- Create a new table called '[ItemCostBook]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[ItemCostBook]', 'U') IS NOT NULL
    DROP TABLE [dbo].[ItemCostBook]
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[ItemCostBook]
(
    [ID]       INTEGER IDENTITY (1,1) NOT NULL,
    [Item]     VARCHAR(30),
    [Updated]  CHAR(1),
    [CreatedBy] VARCHAR(8),
)
GO

create view [dbo].[ItemCostBookViewLegacy]
as
select *
from ItemCostBook;
GO
