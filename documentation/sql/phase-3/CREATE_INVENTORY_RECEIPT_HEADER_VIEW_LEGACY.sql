-- Create a new view called '[InventoryReceiptHeaderViewLegacy]' in schema '[dbo]'
-- Drop the view if it already exists
IF OBJECT_ID('[dbo].[InventoryReceiptHeaderViewLegacy]', 'U') IS NOT NULL
    DROP view [dbo].[InventoryReceiptHeaderViewLegacy]
GO
-- Create the view in the specified schema
CREATE view [dbo].[InventoryReceiptHeaderViewLegacy]
AS
SELECT *
FROM InventoryReceiptHeader;
GO