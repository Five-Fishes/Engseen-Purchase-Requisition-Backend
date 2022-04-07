-- Create ItemMasterUpdate
CREATE PROCEDURE ItemMasterUpdate @ID INTEGER, 
    @Item VARCHAR(30), @ItemDescription VARCHAR(70), @UnitOfMeasure VARCHAR(4), 
    @VariableOverheadCost DECIMAL(18, 2), @TotalCost DECIMAL(18, 2), @RolledVariableOverheadCost DECIMAL(18, 2), @TotalRolledCost DECIMAL(18, 2), 
    @Modified DATETIME, @ModifiedBy VARCHAR(8), @Accessed DATETIME, @AccessedBy VARCHAR(8)
AS
BEGIN
    SET XACT_ABORT ON;
    UPDATE [dbo].[ItemMasterViewLegacy]
    SET Item = @Item, ItemDescription = @ItemDescription, UnitOfMeasure = @UnitOfMeasure, 
        VariableOverheadCost = @VariableOverheadCost, TotalCost = @TotalCost, RolledVariableOverheadCost = @RolledVariableOverheadCost, TotalRolledCost = @TotalRolledCost, 
        Modified = @Modified, ModifiedBy = @ModifiedBy, Accessed = @Accessed, AccessedBy = @AccessedBy
    WHERE ID = @ID;
    SELECT * FROM [dbo].[ItemMasterViewLegacy]
    WHERE ID = @ID;
    SET XACT_ABORT OFF;
END
GO