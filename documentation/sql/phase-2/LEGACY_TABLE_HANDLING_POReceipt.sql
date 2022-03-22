-- TODO: Add 4 parts DB Object name
create view [dbo].[POReceiptHeaderViewLegacy]
as
select *
from POReceiptHeader;
GO

create view [dbo].[POReceiptViewLegacy]
as
select *
from POReceipt;
GO