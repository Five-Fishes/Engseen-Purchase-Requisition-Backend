-- Start CounterTable Store Procedure

-- Create CounterTableUpdate
CREATE PROCEDURE CounterTableUpdate @ID INTEGER, 
    @CouterCode VARCHAR(20), @CounterMask VARCHAR(20),  @DefaultCounter VARCHAR(20), @LastCounter INTEGER, @FileName VARCHAR(20)
AS
BEGIN
    SET XACT_ABORT ON;
    UPDATE [dbo].[CounterTableViewLegacy]
    SET CounterCode = @CounterCode, CounterMask = @CounterMask, DefaultCounter = @DefaultCounter, LastCounter = @LastCounter, FileName = @FileName
    WHERE ID = @ID;
    SELECT * FROM [dbo].[CounterTableViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO