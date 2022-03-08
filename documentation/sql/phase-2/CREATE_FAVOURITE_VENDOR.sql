-- Create a new table called '[FavouriteVendor]' in schema '[dbo]'
-- Drop the table if it already exists
IF OBJECT_ID('[dbo].[FavouriteVendor]', 'U') IS NOT NULL
    DROP TABLE [dbo].[FavouriteVendor]
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[FavouriteVendor]
(
    [ID]          BIGINT IDENTITY (1,1) NOT NULL,
    [VendorId]    VARCHAR(12)           NOT NULL,
    [CreatedDate] datetime2,
    [CreatedBy]   varchar(10),
)
GO