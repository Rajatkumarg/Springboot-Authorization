package com.rajat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TranslationInboxMapping {
	
	private String caat_cwb_workflow_UUID;	
	private String caat_cwb_approval_UUID;	
	private String locale;
	private String geo;
	private boolean latest;
	private int version;
	private String fileName;
	private String geneva_UUID;	
	private String uploadedBy;
	private Date uploadedDate;
	private int approvedCount;
	private int caCount;
	private int rejectCount;
	private int pendingCount;
	private String status;
	private boolean sendToApproval;
	private String partNumber;
	private String content;
	private boolean iorNotApplicable;
	private String translationRadar;

	private String changeRequestID;
	private String changeRequestStatus;

	private String updatedBy;
	private Date updatedDate;
	private String localeStatus;
	
	private String revision;
	
	private String allAPNList;
	private  boolean isFansiPublishLoc;
	
	public String getAllAPNList() {
		return allAPNList;
	}
	public void setAllAPNList(String allAPNList) {
		this.allAPNList = allAPNList;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public String getLocaleStatus() {
		return localeStatus;
	}
	public void setLocaleStatus(String localeStatus) {
		this.localeStatus = localeStatus;
	}
	public String getChangeRequestID() {
		return changeRequestID;
	}
	public void setChangeRequestID(String changeRequestID) {
		this.changeRequestID = changeRequestID;
	}
	public String getChangeRequestStatus() {
		return changeRequestStatus;
	}
	public void setChangeRequestStatus(String changeRequestStatus) {
		this.changeRequestStatus = changeRequestStatus;
	}
	public String getCaat_cwb_workflow_UUID() {
		return caat_cwb_workflow_UUID;
	}
	public boolean isSendToApproval() {
		return sendToApproval;
	}
	public void setSendToApproval(boolean sendToApproval) {
		this.sendToApproval = sendToApproval;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isIorNotApplicable() {
		return iorNotApplicable;
	}
	public void setIorNotApplicable(boolean iorNotApplicable) {
		this.iorNotApplicable = iorNotApplicable;
	}
	public String getTranslationRadar() {
		return translationRadar;
	}
	public void setTranslationRadar(String translationRadar) {
		this.translationRadar = translationRadar;
	}
	public void setCaat_cwb_workflow_UUID(String caat_cwb_workflow_UUID) {
		this.caat_cwb_workflow_UUID = caat_cwb_workflow_UUID;
	}
	public String getCaat_cwb_approval_UUID() {
		return caat_cwb_approval_UUID;
	}
	public void setCaat_cwb_approval_UUID(String caat_cwb_approval_UUID) {
		this.caat_cwb_approval_UUID = caat_cwb_approval_UUID;
	}
	public boolean isLatest() {
		return latest;
	}
	public void setLatest(boolean latest) {
		this.latest = latest;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getApprovedCount() {
		return approvedCount;
	}
	public void setApprovedCount(int approvedCount) {
		this.approvedCount = approvedCount;
	}
	public int getCaCount() {
		return caCount;
	}
	public void setCaCount(int caCount) {
		this.caCount = caCount;
	}
	public int getRejectCount() {
		return rejectCount;
	}
	public void setRejectCount(int rejectCount) {
		this.rejectCount = rejectCount;
	}
	public int getPendingCount() {
		return pendingCount;
	}
	public void setPendingCount(int pendingCount) {
		this.pendingCount = pendingCount;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getGeneva_UUID() {
		return geneva_UUID;
	}
	public void setGeneva_UUID(String geneva_UUID) {
		this.geneva_UUID = geneva_UUID;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getGeo() {
		return geo;
	}
	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Date getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	@Override
	public String toString() {
		return "TranslationInboxMapping [caat_cwb_workflow_UUID=" + caat_cwb_workflow_UUID + ", caat_cwb_approval_UUID="
				+ caat_cwb_approval_UUID + ", locale=" + locale + ", geo=" + geo + ", latest=" + latest + ", version="
				+ version + ", fileName=" + fileName + ", geneva_UUID=" + geneva_UUID + ", uploadedBy=" + uploadedBy
				+ ", uploadedDate=" + uploadedDate + ", approvedCount=" + approvedCount + ", caCount=" + caCount
				+ ", rejectCount=" + rejectCount + ", pendingCount=" + pendingCount + ", status=" + status
				+ ", sendToApproval=" + sendToApproval + ", partNumber=" + partNumber + ", content=" + content
				+ ", iorNotApplicable=" + iorNotApplicable + ", translationRadar=" + translationRadar
				+ ", changeRequestID=" + changeRequestID + ", changeRequestStatus=" + changeRequestStatus
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", localeStatus=" + localeStatus + "]";
	}

	
}
