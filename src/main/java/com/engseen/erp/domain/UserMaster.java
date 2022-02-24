package com.engseen.erp.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@ToString
@Table(name = "UserMasterViewLegacy", schema = "dbo")
public class UserMaster {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "UserID", length = 8)
    private String userID;

    @Column(name = "UserName", length = 50)
    private String userName;

    @Column(name = "Password", length = 12)
    private String password;

    @Column(name = "Status")
    private Character status;

    @Column(name = "UserGroup", length = 15)
    private String userGroup;

    @Column(name = "PlannerBuyer")
    private Character plannerBuyer;

    @Column(name = "CSR")
    private Character csr;

    @Column(name = "Department", length = 50)
    private String department;

    @Column(name = "HOD")
    private Character hod;

    @Column(name = "MD")
    private Character md;

    @Column(name = "PD")
    private Character pd;

    @Column(name = "ShowFullPR")
    private Character showFullPR;

    @Column(name = "SelectHOD")
    private Character selectHOD;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "DateFormat", length = 10)
    private String dateFormat;

    @Column(name = "ItemFilter", length = 50)
    private String itemFilter;

    @Column(name = "PrinterName", length = 50)
    private String printerName;

    @Column(name = "PrinterPort", length = 50)
    private String printerPort;

    @Column(name = "PrinterDriver", length = 50)
    private String printerDriver;

    @Column(name = "DefaultStoreNo", length = 4)
    private String defaultStoreNo;

    @Column(name = "DefaultStoreBin", length = 12)
    private String defaultStoreBin;

    @Column(name = "ViewPrice")
    private Character viewPrice;

    @Column(name = "MoveAllItem")
    private Character moveAllItem;

    @Column(name = "PostGRN")
    private Character postGRN;

    @Column(name = "UnpostGRN")
    private Character unpostGRN;

    @Column(name = "PostPOReturn")
    private Character postPOReturn;

    @Column(name = "UnpostPOReturn")
    private Character unpostPOReturn;

    @Column(name = "PostCashBill")
    private Character postCashBill;

    @Column(name = "UnpostCashBill")
    private Character unpostCashBill;

    @Column(name = "PostRentalBill")
    private Character postRentalBill;

    @Column(name = "UnpostRentalBill")
    private Character unpostRentalBill;

    @Column(name = "PostInvoice")
    private Character postInvoice;

    @Column(name = "UnpostInvoice")
    private Character unpostInvoice;

    @Column(name = "PostDN")
    private Character postDN;

    @Column(name = "UnpostDN")
    private Character unpostDN;

    @Column(name = "PostCN")
    private Character postCN;

    @Column(name = "UnpostCN")
    private Character unpostCN;

    @Column(name = "PostPayment")
    private Character postPayment;

    @Column(name = "UnpostPayment")
    private Character unpostPayment;

    @Column(name = "Created")
    private Instant created;

    @Column(name = "CreatedBy", length = 8)
    private String createdBy;

    @Column(name = "Modified")
    private Instant modified;

    @Column(name = "ModifiedBy", length = 8)
    private String modifiedBy;

    @Column(name = "Accessed")
    private Instant accessed;

    @Column(name = "AccessedBy", length = 8)
    private String accessedBy;

    @Column(name = "Role", length = 50)
    private String role;

    @Column(name = "CanLoginByPsw")
    private Character canLoginByPsw;

    @Column(name = "IsPswAdded")
    private Character isPswAdded;

    @Column(name = "CanLoginByFingerprint")
    private Character canLoginByFingerprint;

    @Column(name = "IsFingerprintAdded")
    private Character isFingerprintAdded;

    @Column(name = "SCView")
    private Character sCView;

    @Column(name = "SCAdjustError")
    private Character sCAdjustError;

    @Column(name = "STView")
    private Character sTView;

    @Column(name = "SIView")
    private Character sIView;

    @Column(name = "IdleLogoutDuration")
    private Integer idleLogoutDuration;

    @Column(name = "SIEditQty")
    private Character sIEditQty;

    public Character getSIEditQty() {
        return sIEditQty;
    }

    public void setSIEditQty(Character sIEditQty) {
        this.sIEditQty = sIEditQty;
    }

    public Integer getIdleLogoutDuration() {
        return idleLogoutDuration;
    }

    public void setIdleLogoutDuration(Integer idleLogoutDuration) {
        this.idleLogoutDuration = idleLogoutDuration;
    }

    public Character getSIView() {
        return sIView;
    }

    public void setSIView(Character sIView) {
        this.sIView = sIView;
    }

    public Character getSTView() {
        return sTView;
    }

    public void setSTView(Character sTView) {
        this.sTView = sTView;
    }

    public Character getSCAdjustError() {
        return sCAdjustError;
    }

    public void setSCAdjustError(Character sCAdjustError) {
        this.sCAdjustError = sCAdjustError;
    }

    public Character getSCView() {
        return sCView;
    }

    public void setSCView(Character sCView) {
        this.sCView = sCView;
    }

    public Character getIsFingerprintAdded() {
        return isFingerprintAdded;
    }

    public void setIsFingerprintAdded(Character isFingerprintAdded) {
        this.isFingerprintAdded = isFingerprintAdded;
    }

    public Character getCanLoginByFingerprint() {
        return canLoginByFingerprint;
    }

    public void setCanLoginByFingerprint(Character canLoginByFingerprint) {
        this.canLoginByFingerprint = canLoginByFingerprint;
    }

    public Character getIsPswAdded() {
        return isPswAdded;
    }

    public void setIsPswAdded(Character isPswAdded) {
        this.isPswAdded = isPswAdded;
    }

    public Character getCanLoginByPsw() {
        return canLoginByPsw;
    }

    public void setCanLoginByPsw(Character canLoginByPsw) {
        this.canLoginByPsw = canLoginByPsw;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccessedBy() {
        return accessedBy;
    }

    public void setAccessedBy(String accessedBy) {
        this.accessedBy = accessedBy;
    }

    public Instant getAccessed() {
        return accessed;
    }

    public void setAccessed(Instant accessed) {
        this.accessed = accessed;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Character getUnpostPayment() {
        return unpostPayment;
    }

    public void setUnpostPayment(Character unpostPayment) {
        this.unpostPayment = unpostPayment;
    }

    public Character getPostPayment() {
        return postPayment;
    }

    public void setPostPayment(Character postPayment) {
        this.postPayment = postPayment;
    }

    public Character getUnpostCN() {
        return unpostCN;
    }

    public void setUnpostCN(Character unpostCN) {
        this.unpostCN = unpostCN;
    }

    public Character getPostCN() {
        return postCN;
    }

    public void setPostCN(Character postCN) {
        this.postCN = postCN;
    }

    public Character getUnpostDN() {
        return unpostDN;
    }

    public void setUnpostDN(Character unpostDN) {
        this.unpostDN = unpostDN;
    }

    public Character getPostDN() {
        return postDN;
    }

    public void setPostDN(Character postDN) {
        this.postDN = postDN;
    }

    public Character getUnpostInvoice() {
        return unpostInvoice;
    }

    public void setUnpostInvoice(Character unpostInvoice) {
        this.unpostInvoice = unpostInvoice;
    }

    public Character getPostInvoice() {
        return postInvoice;
    }

    public void setPostInvoice(Character postInvoice) {
        this.postInvoice = postInvoice;
    }

    public Character getUnpostRentalBill() {
        return unpostRentalBill;
    }

    public void setUnpostRentalBill(Character unpostRentalBill) {
        this.unpostRentalBill = unpostRentalBill;
    }

    public Character getPostRentalBill() {
        return postRentalBill;
    }

    public void setPostRentalBill(Character postRentalBill) {
        this.postRentalBill = postRentalBill;
    }

    public Character getUnpostCashBill() {
        return unpostCashBill;
    }

    public void setUnpostCashBill(Character unpostCashBill) {
        this.unpostCashBill = unpostCashBill;
    }

    public Character getPostCashBill() {
        return postCashBill;
    }

    public void setPostCashBill(Character postCashBill) {
        this.postCashBill = postCashBill;
    }

    public Character getUnpostPOReturn() {
        return unpostPOReturn;
    }

    public void setUnpostPOReturn(Character unpostPOReturn) {
        this.unpostPOReturn = unpostPOReturn;
    }

    public Character getPostPOReturn() {
        return postPOReturn;
    }

    public void setPostPOReturn(Character postPOReturn) {
        this.postPOReturn = postPOReturn;
    }

    public Character getUnpostGRN() {
        return unpostGRN;
    }

    public void setUnpostGRN(Character unpostGRN) {
        this.unpostGRN = unpostGRN;
    }

    public Character getPostGRN() {
        return postGRN;
    }

    public void setPostGRN(Character postGRN) {
        this.postGRN = postGRN;
    }

    public Character getMoveAllItem() {
        return moveAllItem;
    }

    public void setMoveAllItem(Character moveAllItem) {
        this.moveAllItem = moveAllItem;
    }

    public Character getViewPrice() {
        return viewPrice;
    }

    public void setViewPrice(Character viewPrice) {
        this.viewPrice = viewPrice;
    }

    public String getDefaultStoreBin() {
        return defaultStoreBin;
    }

    public void setDefaultStoreBin(String defaultStoreBin) {
        this.defaultStoreBin = defaultStoreBin;
    }

    public String getDefaultStoreNo() {
        return defaultStoreNo;
    }

    public void setDefaultStoreNo(String defaultStoreNo) {
        this.defaultStoreNo = defaultStoreNo;
    }

    public String getPrinterDriver() {
        return printerDriver;
    }

    public void setPrinterDriver(String printerDriver) {
        this.printerDriver = printerDriver;
    }

    public String getPrinterPort() {
        return printerPort;
    }

    public void setPrinterPort(String printerPort) {
        this.printerPort = printerPort;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getItemFilter() {
        return itemFilter;
    }

    public void setItemFilter(String itemFilter) {
        this.itemFilter = itemFilter;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Character getSelectHOD() {
        return selectHOD;
    }

    public void setSelectHOD(Character selectHOD) {
        this.selectHOD = selectHOD;
    }

    public Character getShowFullPR() {
        return showFullPR;
    }

    public void setShowFullPR(Character showFullPR) {
        this.showFullPR = showFullPR;
    }

    public Character getPd() {
        return pd;
    }

    public void setPd(Character pd) {
        this.pd = pd;
    }

    public Character getMd() {
        return md;
    }

    public void setMd(Character md) {
        this.md = md;
    }

    public Character getHod() {
        return hod;
    }

    public void setHod(Character hod) {
        this.hod = hod;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Character getCsr() {
        return csr;
    }

    public void setCsr(Character csr) {
        this.csr = csr;
    }

    public Character getPlannerBuyer() {
        return plannerBuyer;
    }

    public void setPlannerBuyer(Character plannerBuyer) {
        this.plannerBuyer = plannerBuyer;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}