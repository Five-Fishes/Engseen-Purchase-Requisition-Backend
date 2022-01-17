package com.engseen.erp.domain;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@ToString
@Table(name = "ItemMaster", schema = "dbo")
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
    private String drawing;

    @Column(name = "ItemClassifications")
    private char itemClassifications;

    @Column(name = "Reference1")
    private String reference1;

    @Column(name = "Reference2")
    private String reference2;

    @Column(name = "Reference3")
    private String reference3;

    @Column(name = "Reference4")
    private String reference4;

    @Column(name = "ItemShippingWeight")
    private BigDecimal itemShippingWeight;

    @Column(name = "ItemShippingVolumn")
    private BigDecimal itemShippingVolumn;

    @Column(name = "ItemPackageType")
    private String itemPackageType;

    @Column(name = "ItemPiecesPerPackage")
    private BigDecimal itemPiecesPerPackage;

    @Column(name = "ItemGrossWeight")
    private BigDecimal itemGrossWeight;

    @Column(name = "LotAssignmentPolicy")
    private char lotAssignmentPolicy;

    @Column(name = "LotDefaultPolicy")
    private char lotDefaultPolicy;

    @Column(name = "FIFOInventoryPolicy")
    private char fIFOInventoryPolicy;

    @Column(name = "BackflushPolicy")
    private char backflushPolicy;

    @Column(name = "AvailableCalendarDays")
    private int availableCalendarDays;

    @Column(name = "ShelfLifeCalendarDays")
    private int shelfLifeCalendarDays;

    @Column(name = "RetestCalendarDays")
    private int retestCalendarDays;

    @Column(name = "LastLot")
    private int lastLot;

    @Column(name = "LotMask")
    private String lotMask;

    @Column(name = "DefaultLot")
    private String defaultLot;

    @Column(name = "LotCounter")
    private char lotCounter;

    @Column(name = "SerialNumberMask")
    private String serialNumberMask;

    @Column(name = "DefaultSerialNumber")
    private String defaultSerialNumber;

    @Column(name = "SerialNumberCounter")
    private char serialNumberCounter;

    @Column(name = "PlannerBuyer")
    private String plannerBuyer;

    @Column(name = "RunLeadTime")
    private int runLeadTime;

    @Column(name = "FixedLeadTime")
    private int fixedLeadTime;

    @Column(name = "InspectionLeadTime")
    private int inspectionLeadTime;

    @Column(name = "PlanLeadTime")
    private int planLeadTime;

    @Column(name = "LotSizeDay")
    private int lotSizeDay;

    @Column(name = "LotSizeQuantity")
    private BigDecimal lotSizeQuantity;

    @Column(name = "SafetyStock")
    private BigDecimal safetyStock;

    @Column(name = "MinimumLotSize")
    private BigDecimal minimumLotSize;

    @Column(name = "MultipleLotSize")
    private BigDecimal multipleLotSize;

    @Column(name = "PreferredStoreNo")
    private String preferredStoreNo;

    @Column(name = "PreferredStoreBin")
    private String preferredStoreBin;

    @Column(name = "ForecastCode")
    private char forecastCode;

    @Column(name = "ForecastPeriod")
    private char forecastPeriod;

    @Column(name = "ItemYieldFactor")
    private int itemYieldFactor;

    @Column(name = "DecimalPrecisionCode")
    private int decimalPrecisionCode;

    @Column(name = "LowLevelCode")
    private int lowLevelCode;

    @Column(name = "Remark1")
    private String remark1;

    @Column(name = "Remark2")
    private String remark2;

    @Column(name = "Remark3")
    private String remark3;

    @Column(name = "InventoryAccountNo")
    private String inventoryAccountNo;

    @Column(name = "SalesAccountNo")
    private String salesAccountNo;

    @Column(name = "COGSAccountNo")
    private String cOGSAccountNo;

    @Column(name = "AverageSellingPrice")
    private BigDecimal averageSellingPrice;

    @Column(name = "CostCode")
    private int costCode;

    @Column(name = "MaterialCost")
    private BigDecimal materialCost;

    @Column(name = "LaborCost")
    private BigDecimal laborCost;

    @Column(name = "VariableOverheadCost")
    private BigDecimal variableOverheadCost;

    @Column(name = "FixedOverheadCost")
    private BigDecimal fixedOverheadCost;

    @Column(name = "TotalCost")
    private BigDecimal totalCost;

    @Column(name = "RolledMaterialCost")
    private BigDecimal rolledMaterialCost;

    @Column(name = "RolledLaborCost")
    private BigDecimal rolledLaborCost;

    @Column(name = "RolledVariableOverheadCost")
    private BigDecimal rolledVariableOverheadCost;

    @Column(name = "RolledFixedOverheadCost")
    private BigDecimal rolledFixedOverheadCost;

    @Column(name = "TotalRolledCost")
    private BigDecimal totalRolledCost;

    @Column(name = "StandardUnitPrice")
    private BigDecimal standardUnitPrice;

    @Column(name = "Label1")
    private String label1;

    @Column(name = "Label2")
    private String label2;

    @Column(name = "MinimumSellingPrice")
    private BigDecimal minimumSellingPrice;

    @Column(name = "LastSerialNumber")
    private int lastSerialNumber;

    @Column(name = "MRPPriority")
    private int mRPPriority;

    @Column(name = "Created")
    private Date created;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "Modified")
    private Date modified;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    @Column(name = "Accessed")
    private Date accessed;

    @Column(name = "AccessedBy")
    private String accessedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getRevisionLevel() {
        return revisionLevel;
    }

    public void setRevisionLevel(String revisionLevel) {
        this.revisionLevel = revisionLevel;
    }

    public char getMakeBuyCode() {
        return makeBuyCode;
    }

    public void setMakeBuyCode(char makeBuyCode) {
        this.makeBuyCode = makeBuyCode;
    }

    public char getItemType() {
        return itemType;
    }

    public void setItemType(char itemType) {
        this.itemType = itemType;
    }

    public char getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(char itemStatus) {
        this.itemStatus = itemStatus;
    }

    public char getLotTrace() {
        return lotTrace;
    }

    public void setLotTrace(char lotTrace) {
        this.lotTrace = lotTrace;
    }

    public char getSerialization() {
        return serialization;
    }

    public void setSerialization(char serialization) {
        this.serialization = serialization;
    }

    public char getOrderPolicy() {
        return orderPolicy;
    }

    public void setOrderPolicy(char orderPolicy) {
        this.orderPolicy = orderPolicy;
    }

    public char getInspectionRequired() {
        return inspectionRequired;
    }

    public void setInspectionRequired(char inspectionRequired) {
        this.inspectionRequired = inspectionRequired;
    }

    public String getDrawing() {
        return drawing;
    }

    public void setDrawing(String drawing) {
        this.drawing = drawing;
    }

    public char getItemClassifications() {
        return itemClassifications;
    }

    public void setItemClassifications(char itemClassifications) {
        this.itemClassifications = itemClassifications;
    }

    public String getReference1() {
        return reference1;
    }

    public void setReference1(String reference1) {
        this.reference1 = reference1;
    }

    public String getReference2() {
        return reference2;
    }

    public void setReference2(String reference2) {
        this.reference2 = reference2;
    }

    public String getReference3() {
        return reference3;
    }

    public void setReference3(String reference3) {
        this.reference3 = reference3;
    }

    public String getReference4() {
        return reference4;
    }

    public void setReference4(String reference4) {
        this.reference4 = reference4;
    }

    public BigDecimal getItemShippingWeight() {
        return itemShippingWeight;
    }

    public void setItemShippingWeight(BigDecimal itemShippingWeight) {
        this.itemShippingWeight = itemShippingWeight;
    }

    public BigDecimal getItemShippingVolumn() {
        return itemShippingVolumn;
    }

    public void setItemShippingVolumn(BigDecimal itemShippingVolumn) {
        this.itemShippingVolumn = itemShippingVolumn;
    }

    public String getItemPackageType() {
        return itemPackageType;
    }

    public void setItemPackageType(String itemPackageType) {
        this.itemPackageType = itemPackageType;
    }

    public BigDecimal getItemPiecesPerPackage() {
        return itemPiecesPerPackage;
    }

    public void setItemPiecesPerPackage(BigDecimal itemPiecesPerPackage) {
        this.itemPiecesPerPackage = itemPiecesPerPackage;
    }

    public BigDecimal getItemGrossWeight() {
        return itemGrossWeight;
    }

    public void setItemGrossWeight(BigDecimal itemGrossWeight) {
        this.itemGrossWeight = itemGrossWeight;
    }

    public char getLotAssignmentPolicy() {
        return lotAssignmentPolicy;
    }

    public void setLotAssignmentPolicy(char lotAssignmentPolicy) {
        this.lotAssignmentPolicy = lotAssignmentPolicy;
    }

    public char getLotDefaultPolicy() {
        return lotDefaultPolicy;
    }

    public void setLotDefaultPolicy(char lotDefaultPolicy) {
        this.lotDefaultPolicy = lotDefaultPolicy;
    }

    public char getfIFOInventoryPolicy() {
        return fIFOInventoryPolicy;
    }

    public void setfIFOInventoryPolicy(char fIFOInventoryPolicy) {
        this.fIFOInventoryPolicy = fIFOInventoryPolicy;
    }

    public char getBackflushPolicy() {
        return backflushPolicy;
    }

    public void setBackflushPolicy(char backflushPolicy) {
        this.backflushPolicy = backflushPolicy;
    }

    public int getAvailableCalendarDays() {
        return availableCalendarDays;
    }

    public void setAvailableCalendarDays(int availableCalendarDays) {
        this.availableCalendarDays = availableCalendarDays;
    }

    public int getShelfLifeCalendarDays() {
        return shelfLifeCalendarDays;
    }

    public void setShelfLifeCalendarDays(int shelfLifeCalendarDays) {
        this.shelfLifeCalendarDays = shelfLifeCalendarDays;
    }

    public int getRetestCalendarDays() {
        return retestCalendarDays;
    }

    public void setRetestCalendarDays(int retestCalendarDays) {
        this.retestCalendarDays = retestCalendarDays;
    }

    public int getLastLot() {
        return lastLot;
    }

    public void setLastLot(int lastLot) {
        this.lastLot = lastLot;
    }

    public String getLotMask() {
        return lotMask;
    }

    public void setLotMask(String lotMask) {
        this.lotMask = lotMask;
    }

    public String getDefaultLot() {
        return defaultLot;
    }

    public void setDefaultLot(String defaultLot) {
        this.defaultLot = defaultLot;
    }

    public char getLotCounter() {
        return lotCounter;
    }

    public void setLotCounter(char lotCounter) {
        this.lotCounter = lotCounter;
    }

    public String getSerialNumberMask() {
        return serialNumberMask;
    }

    public void setSerialNumberMask(String serialNumberMask) {
        this.serialNumberMask = serialNumberMask;
    }

    public String getDefaultSerialNumber() {
        return defaultSerialNumber;
    }

    public void setDefaultSerialNumber(String defaultSerialNumber) {
        this.defaultSerialNumber = defaultSerialNumber;
    }

    public char getSerialNumberCounter() {
        return serialNumberCounter;
    }

    public void setSerialNumberCounter(char serialNumberCounter) {
        this.serialNumberCounter = serialNumberCounter;
    }

    public String getPlannerBuyer() {
        return plannerBuyer;
    }

    public void setPlannerBuyer(String plannerBuyer) {
        this.plannerBuyer = plannerBuyer;
    }

    public int getRunLeadTime() {
        return runLeadTime;
    }

    public void setRunLeadTime(int runLeadTime) {
        this.runLeadTime = runLeadTime;
    }

    public int getFixedLeadTime() {
        return fixedLeadTime;
    }

    public void setFixedLeadTime(int fixedLeadTime) {
        this.fixedLeadTime = fixedLeadTime;
    }

    public int getInspectionLeadTime() {
        return inspectionLeadTime;
    }

    public void setInspectionLeadTime(int inspectionLeadTime) {
        this.inspectionLeadTime = inspectionLeadTime;
    }

    public int getPlanLeadTime() {
        return planLeadTime;
    }

    public void setPlanLeadTime(int planLeadTime) {
        this.planLeadTime = planLeadTime;
    }

    public int getLotSizeDay() {
        return lotSizeDay;
    }

    public void setLotSizeDay(int lotSizeDay) {
        this.lotSizeDay = lotSizeDay;
    }

    public BigDecimal getLotSizeQuantity() {
        return lotSizeQuantity;
    }

    public void setLotSizeQuantity(BigDecimal lotSizeQuantity) {
        this.lotSizeQuantity = lotSizeQuantity;
    }

    public BigDecimal getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(BigDecimal safetyStock) {
        this.safetyStock = safetyStock;
    }

    public BigDecimal getMinimumLotSize() {
        return minimumLotSize;
    }

    public void setMinimumLotSize(BigDecimal minimumLotSize) {
        this.minimumLotSize = minimumLotSize;
    }

    public BigDecimal getMultipleLotSize() {
        return multipleLotSize;
    }

    public void setMultipleLotSize(BigDecimal multipleLotSize) {
        this.multipleLotSize = multipleLotSize;
    }

    public String getPreferredStoreNo() {
        return preferredStoreNo;
    }

    public void setPreferredStoreNo(String preferredStoreNo) {
        this.preferredStoreNo = preferredStoreNo;
    }

    public String getPreferredStoreBin() {
        return preferredStoreBin;
    }

    public void setPreferredStoreBin(String preferredStoreBin) {
        this.preferredStoreBin = preferredStoreBin;
    }

    public char getForecastCode() {
        return forecastCode;
    }

    public void setForecastCode(char forecastCode) {
        this.forecastCode = forecastCode;
    }

    public char getForecastPeriod() {
        return forecastPeriod;
    }

    public void setForecastPeriod(char forecastPeriod) {
        this.forecastPeriod = forecastPeriod;
    }

    public int getItemYieldFactor() {
        return itemYieldFactor;
    }

    public void setItemYieldFactor(int itemYieldFactor) {
        this.itemYieldFactor = itemYieldFactor;
    }

    public int getDecimalPrecisionCode() {
        return decimalPrecisionCode;
    }

    public void setDecimalPrecisionCode(int bigDecimalPrecisionCode) {
        this.decimalPrecisionCode = bigDecimalPrecisionCode;
    }

    public int getLowLevelCode() {
        return lowLevelCode;
    }

    public void setLowLevelCode(int lowLevelCode) {
        this.lowLevelCode = lowLevelCode;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getInventoryAccountNo() {
        return inventoryAccountNo;
    }

    public void setInventoryAccountNo(String inventoryAccountNo) {
        this.inventoryAccountNo = inventoryAccountNo;
    }

    public String getSalesAccountNo() {
        return salesAccountNo;
    }

    public void setSalesAccountNo(String salesAccountNo) {
        this.salesAccountNo = salesAccountNo;
    }

    public String getcOGSAccountNo() {
        return cOGSAccountNo;
    }

    public void setcOGSAccountNo(String cOGSAccountNo) {
        this.cOGSAccountNo = cOGSAccountNo;
    }

    public BigDecimal getAverageSellingPrice() {
        return averageSellingPrice;
    }

    public void setAverageSellingPrice(BigDecimal averageSellingPrice) {
        this.averageSellingPrice = averageSellingPrice;
    }

    public int getCostCode() {
        return costCode;
    }

    public void setCostCode(int costCode) {
        this.costCode = costCode;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getVariableOverheadCost() {
        return variableOverheadCost;
    }

    public void setVariableOverheadCost(BigDecimal variableOverheadCost) {
        this.variableOverheadCost = variableOverheadCost;
    }

    public BigDecimal getFixedOverheadCost() {
        return fixedOverheadCost;
    }

    public void setFixedOverheadCost(BigDecimal fixedOverheadCost) {
        this.fixedOverheadCost = fixedOverheadCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getRolledMaterialCost() {
        return rolledMaterialCost;
    }

    public void setRolledMaterialCost(BigDecimal rolledMaterialCost) {
        this.rolledMaterialCost = rolledMaterialCost;
    }

    public BigDecimal getRolledLaborCost() {
        return rolledLaborCost;
    }

    public void setRolledLaborCost(BigDecimal rolledLaborCost) {
        this.rolledLaborCost = rolledLaborCost;
    }

    public BigDecimal getRolledVariableOverheadCost() {
        return rolledVariableOverheadCost;
    }

    public void setRolledVariableOverheadCost(BigDecimal rolledVariableOverheadCost) {
        this.rolledVariableOverheadCost = rolledVariableOverheadCost;
    }

    public BigDecimal getRolledFixedOverheadCost() {
        return rolledFixedOverheadCost;
    }

    public void setRolledFixedOverheadCost(BigDecimal rolledFixedOverheadCost) {
        this.rolledFixedOverheadCost = rolledFixedOverheadCost;
    }

    public BigDecimal getTotalRolledCost() {
        return totalRolledCost;
    }

    public void setTotalRolledCost(BigDecimal totalRolledCost) {
        this.totalRolledCost = totalRolledCost;
    }

    public BigDecimal getStandardUnitPrice() {
        return standardUnitPrice;
    }

    public void setStandardUnitPrice(BigDecimal standardUnitPrice) {
        this.standardUnitPrice = standardUnitPrice;
    }

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public BigDecimal getMinimumSellingPrice() {
        return minimumSellingPrice;
    }

    public void setMinimumSellingPrice(BigDecimal minimumSellingPrice) {
        this.minimumSellingPrice = minimumSellingPrice;
    }

    public int getLastSerialNumber() {
        return lastSerialNumber;
    }

    public void setLastSerialNumber(int lastSerialNumber) {
        this.lastSerialNumber = lastSerialNumber;
    }

    public int getmRPPriority() {
        return mRPPriority;
    }

    public void setmRPPriority(int mRPPriority) {
        this.mRPPriority = mRPPriority;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getAccessed() {
        return accessed;
    }

    public void setAccessed(Date accessed) {
        this.accessed = accessed;
    }

    public String getAccessedBy() {
        return accessedBy;
    }

    public void setAccessedBy(String accessedBy) {
        this.accessedBy = accessedBy;
    }
}
