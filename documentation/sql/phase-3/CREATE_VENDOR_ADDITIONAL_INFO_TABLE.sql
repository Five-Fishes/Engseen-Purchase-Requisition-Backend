IF OBJECT_ID('[dbo].[VendorAdditionalInfo]', 'U') IS NOT NULL
    DROP TABLE [dbo].[VendorAdditionalInfo]
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[VendorAdditionalInfo]
(
    [VendorId]    VARCHAR(50) NOT NULL PRIMARY KEY,
    [IsFavourite] BIT     NOT NULL DEFAULT 0,
    [Email]       VARCHAR(50)
);
GO