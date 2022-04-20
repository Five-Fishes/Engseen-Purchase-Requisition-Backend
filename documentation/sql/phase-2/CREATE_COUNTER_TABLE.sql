-- Create a new table called '[CounterTable]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[CounterTable]', 'U') IS NOT NULL
    DROP TABLE [dbo].[CounterTable]
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[CounterTable]
(
    [ID]          INTEGER IDENTITY (1,1) NOT NULL,
    [CounterCode]    VARCHAR(20)           NOT NULL,
    [CounterMask]    VARCHAR(20),
    [DefaultCounter]    VARCHAR(20),
    [LastCounter]    int NOT NULL,
    [FileName]    VARCHAR(20),
)
GO

create view [dbo].[CounterTableViewLegacy]
as
select *
from CounterTable;
GO