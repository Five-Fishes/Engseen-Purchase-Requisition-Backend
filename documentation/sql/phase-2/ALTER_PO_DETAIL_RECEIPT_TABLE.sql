ALTER TABLE [dbo].[PODetail]
ADD PackReceived INTEGER;
GO
ALTER TABLE [dbo].[PODetail]
ADD Pack INTEGER;
GO

ALTER view [dbo].[PODetailViewLegacy]
as
select *
from PODetail;
GO

ALTER TABLE [dbo].[POReceipt]
ADD PackReceived INTEGER;
GO
ALTER TABLE [dbo].[POReceipt]
ADD PackReversed INTEGER;
GO

ALTER view [dbo].[POReceiptViewLegacy]
as
select *
from POReceipt;
GO
