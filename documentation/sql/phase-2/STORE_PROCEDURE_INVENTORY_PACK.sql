-- Start InventoryPack Store Procedure
-- Insert InventoryPack
CREATE PROCEDURE InventoryPackInsert  
    @Item VARCHAR(30), @StoreNo VARCHAR(4), @StoreBin VARCHAR(12), @Pack INTEGER
AS
BEGIN
    DECLARE @ID INTEGER;
    SET XACT_ABORT ON;
        INSERT INTO [dbo].[InventoryPackViewLegacy]
        (Item, StoreNo, StoreBin, Pack)
    VALUES
    (@Item, @StoreNo, @StoreBin, @Pack);
	SELECT @ID = SCOPE_IDENTITY();
	SELECT * FROM [dbo].[InventoryPackViewLegacy]
	   	WHERE ID = @ID;
	   	SET XACT_ABORT OFF;
END
GO

-- Create InventoryPackUpdate
CREATE PROCEDURE InventoryPackUpdate @ID INTEGER, 
    @Item VARCHAR(30), @StoreNo VARCHAR(4), @StoreBin VARCHAR(12), @Pack INTEGER
AS
BEGIN
    SET XACT_ABORT ON;
    UPDATE [dbo].[InventoryPackViewLegacy]
    SET Item = @Item, StoreNo = @StoreNo, StoreBin = @StoreBin, Pack = @Pack
    WHERE ID = @ID;
    SELECT * FROM [dbo].[InventoryPackViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO

-- InventoryPack Delete
CREATE PROCEDURE InventoryPackDelete @ID INTEGER
AS
BEGIN
    SET XACT_ABORT ON;
    DELETE FROM [dbo].[InventoryPackViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO


-- End InventoryPack Store Procedure