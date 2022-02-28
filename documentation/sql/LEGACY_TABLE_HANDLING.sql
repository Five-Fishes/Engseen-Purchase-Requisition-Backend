-- To handle the connection to legacy database, views that reference tables of legacy database are created

create view [dbo].[InventoryViewLegacy]
as
select *
from Inventory;

create view [dbo].[ItemMasterViewLegacy]
as
select *
from ItemMaster;

create view [dbo].[PODetailViewLegacy]
as
select *
from PODetail;

create view [dbo].[POHeaderViewLegacy]
as
select *
from POHeader;

create view [dbo].[UserMasterViewLegacy]
as
select *
from UserMaster;

create view [dbo].[VendorItemViewLegacy]
as
select *
from VendorItem;

create view [dbo].[VendorMasterViewLegacy]
as
select *
from VendorMaster;