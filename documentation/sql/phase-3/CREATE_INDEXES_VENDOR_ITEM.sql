--- Vendor Item Indexes
CREATE INDEX Index_VendorId
ON [dbo].[VendorItem] (VendorID);
CREATE INDEX Index_Item
ON [dbo].[VendorItem] (Item);
GO

--- Vendor Master Indexes
CREATE INDEX Index_VendorId
ON [dbo].[VendorMaster] (VendorID);
CREATE INDEX Index_VendorName
ON [dbo].[VendorMaster] (VendorName);
GO

--- Item Master Indexes
CREATE INDEX Index_Item
ON [dbo].[ItemMaster] (Item);
CREATE INDEX Index_ItemDescription
ON [dbo].[ItemMaster] (ItemDescription);
GO
