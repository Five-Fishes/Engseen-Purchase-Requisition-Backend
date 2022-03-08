-- To handle the connection to legacy database, views that reference tables of legacy database are created

create view [dbo].[InventoryViewLegacy]
as
select *
from Inventory;
GO

create view [dbo].[ItemMasterViewLegacy]
as
select *
from ItemMaster;
GO

create view [dbo].[PODetailViewLegacy]
as
select *
from PODetail;
GO

create view [dbo].[POHeaderViewLegacy]
as
select *
from POHeader;
GO

create view [dbo].[UserMasterViewLegacy]
as
select *
from UserMaster;
GO

create view [dbo].[VendorItemViewLegacy]
as
select *
from VendorItem;
GO

create view [dbo].[VendorMasterViewLegacy]
as
select *
from VendorMaster;
GO
