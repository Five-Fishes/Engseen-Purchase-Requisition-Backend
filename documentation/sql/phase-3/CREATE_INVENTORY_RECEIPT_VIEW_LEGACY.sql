-- Create a new view called '[InventoryReceiptViewLegacy]' in schema '[dbo]'
-- Drop the view if it already exists
IF OBJECT_ID('[dbo].[InventoryReceiptViewLegacy]', 'U') IS NOT NULL
    DROP view [dbo].[InventoryReceiptViewLegacy]
GO
-- Create the view in the specified schema
CREATE view [dbo].[InventoryReceiptViewLegacy]
AS
SELECT *
FROM InventoryReceipt;
GO