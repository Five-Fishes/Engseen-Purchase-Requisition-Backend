package com.engseen.erp.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "ItemMaster")
public class ItemMaster implements Serializable {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "Item")
    private String item;

    @Column(name = "ItemDescription")
    private String itemDescription;

    @Column(name = "UnitOfMeasure")
    private String unitOfMeasure;

    @Column(name = "RevisionLevel")
    private String revisionLevel;

    @Column(name = "MakeBuyCode")
    private char makeBuyCode;

    @Column(name = "ItemType")
    private char itemType;

    @Column(name = "ItemStatus")
    private char itemStatus;

    @Column(name = "LotTrace")
    private char lotTrace;

    @Column(name = "Serialization")
    private char serialization;

    @Column(name = "OrderPolicy")
    private char orderPolicy;

    @Column(name = "InspectionRequired")
    private char inspectionRequired;

    @Column(name = "Drawing")
    private String Drawing;

    @Column(name = "ItemClassifications")
    private char ItemClassifications;

    @Column(name = "Reference1")
    private String Reference1;

    @Column(name = "Reference2")
    private String Reference2;

    @Column(name = "Reference3")
    private String Reference3;

    @Column(name = "Reference4")
    private String Reference4;

    @Column(name = "ItemShippingWeight")
    private BigDecimal ItemShippingWeight;

    @Column(name = "ItemShippingVolumn")
    private BigDecimal ItemShippingVolumn;

    @Column(name = "ItemPackageType")
    private String ItemPackageType;

    @Column(name = "ItemPiecesPerPackage")
    private BigDecimal ItemPiecesPerPackage;

    @Column(name = "ItemGrossWeight")
    private BigDecimal ItemGrossWeight;

    @Column(name = "LotAssignmentPolicy")
    private char LotAssignmentPolicy;

    @Column(name = "LotDefaultPolicy")
    private char LotDefaultPolicy;

    @Column(name = "FIFOInventoryPolicy")
    private char FIFOInventoryPolicy;

    @Column(name = "BackflushPolicy")
    private char BackflushPolicy;

    @Column(name = "AvailableCalendarDays")
    private int AvailableCalendarDays;

    @Column(name = "ShelfLifeCalendarDays")
    private int ShelfLifeCalendarDays;

    @Column(name = "RetestCalendarDays")
    private int RetestCalendarDays;

    @Column(name = "LastLot")
    private int LastLot;

    @Column(name = "LotMask")
    private String LotMask;

    @Column(name = "DefaultLot")
    private String DefaultLot;

    @Column(name = "LotCounter")
    private char LotCounter;

    @Column(name = "SerialNumberMask")
    private String SerialNumberMask;

    @Column(name = "DefaultSerialNumber")
    private String DefaultSerialNumber;

    @Column(name = "SerialNumberCounter")
    private char SerialNumberCounter;

    @Column(name = "PlannerBuyer")
    private String PlannerBuyer;

    @Column(name = "RunLeadTime")
    private int RunLeadTime;

    @Column(name = "FixedLeadTime")
    private int FixedLeadTime;

    @Column(name = "InspectionLeadTime")
    private int InspectionLeadTime;

    @Column(name = "PlanLeadTime")
    private int PlanLeadTime;

    @Column(name = "LotSizeDay")
    private int LotSizeDay;

    @Column(name = "LotSizeQuantity")
    private BigDecimal LotSizeQuantity;

    @Column(name = "SafetyStock")
    private BigDecimal SafetyStock;

    @Column(name = "MinimumLotSize")
    private BigDecimal MinimumLotSize;

    @Column(name = "MultipleLotSize")
    private BigDecimal MultipleLotSize;

    @Column(name = "PreferredStoreNo")
    private String PreferredStoreNo;

    @Column(name = "PreferredStoreBin")
    private String PreferredStoreBin;

    @Column(name = "ForecastCode")
    private char ForecastCode;

    @Column(name = "ForecastPeriod")
    private char ForecastPeriod;

    @Column(name = "ItemYieldFactor")
    private int ItemYieldFactor;

    @Column(name = "BigDecimalPrecisionCode")
    private int BigDecimalPrecisionCode;

    @Column(name = "LowLevelCode")
    private int LowLevelCode;

    @Column(name = "Remark1")
    private String Remark1;

    @Column(name = "Remark2")
    private String Remark2;

    @Column(name = "Remark3")
    private String Remark3;

    @Column(name = "InventoryAccountNo")
    private String InventoryAccountNo;

    @Column(name = "SalesAccountNo")
    private String SalesAccountNo;

    @Column(name = "COGSAccountNo")
    private String COGSAccountNo;

    @Column(name = "AverageSellingPrice")
    private BigDecimal AverageSellingPrice;

    @Column(name = "CostCode")
    private int CostCode;

    @Column(name = "MaterialCost")
    private BigDecimal MaterialCost;

    @Column(name = "LaborCost")
    private BigDecimal LaborCost;

    @Column(name = "VariableOverheadCost")
    private BigDecimal VariableOverheadCost;

    @Column(name = "FixedOverheadCost")
    private BigDecimal FixedOverheadCost;

    @Column(name = "TotalCost")
    private BigDecimal TotalCost;

    @Column(name = "RolledMaterialCost")
    private BigDecimal RolledMaterialCost;

    @Column(name = "RolledLaborCost")
    private BigDecimal RolledLaborCost;

    @Column(name = "RolledVariableOverheadCost")
    private BigDecimal RolledVariableOverheadCost;

    @Column(name = "RolledFixedOverheadCost")
    private BigDecimal RolledFixedOverheadCost;

    @Column(name = "TotalRolledCost")
    private BigDecimal TotalRolledCost;

    @Column(name = "StandardUnitPrice")
    private BigDecimal StandardUnitPrice;

    @Column(name = "Label1")
    private String Label1;

    @Column(name = "Label2")
    private String Label2;

    @Column(name = "MinimumSellingPrice")
    private BigDecimal MinimumSellingPrice;

    @Column(name = "LastSerialNumber")
    private int LastSerialNumber;

    @Column(name = "MRPPriority")
    private int MRPPriority;

    @Column(name = "Created")
    private Date Created;

    @Column(name = "CreatedBy")
    private String CreatedBy;

    @Column(name = "Modified")
    private Date Modified;

    @Column(name = "ModifiedBy")
    private String ModifiedBy;

    @Column(name = "Accessed")
    private Date Accessed;

    @Column(name = "AccessedBy")
    private String AccessedBy;

}
