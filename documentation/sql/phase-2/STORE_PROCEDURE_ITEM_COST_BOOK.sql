-- Start ItemCostBook Store Procedure
-- Insert ItemCostBook
CREATE PROCEDURE ItemCostBookInsert  
    @Item VARCHAR(30), @Updated CHAR(1), @CreatedBy VARCHAR(8)
AS
BEGIN
    DECLARE @ID INTEGER;
    SET XACT_ABORT ON;
        INSERT INTO [dbo].[ItemCostBookViewLegacy]
        (Item, Updated, CreatedBy)
    VALUES
    (@Item, @Updated, @CreatedBy);
	SELECT @ID = SCOPE_IDENTITY();
	SELECT * FROM [dbo].[ItemCostBookViewLegacy]
	   	WHERE ID = @ID;
	   	SET XACT_ABORT OFF;
END
GO

-- Create ItemCostBookUpdate
CREATE PROCEDURE ItemCostBookUpdate @ID INTEGER, 
    @Item VARCHAR(30), @Updated CHAR(1), @CreatedBy VARCHAR(8)
AS
BEGIN
    SET XACT_ABORT ON;
    UPDATE [dbo].[ItemCostBookViewLegacy]
    SET Item = @Item, Updated = @Updated, CreatedBy = @CreatedBy
    WHERE ID = @ID;
    SELECT * FROM [dbo].[ItemCostBookViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO

-- ItemCostBook Delete
CREATE PROCEDURE ItemCostBookDelete @ID INTEGER
AS
BEGIN
    SET XACT_ABORT ON;
    DELETE FROM [dbo].[ItemCostBookViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO


-- End ItemCostBook Store Procedure