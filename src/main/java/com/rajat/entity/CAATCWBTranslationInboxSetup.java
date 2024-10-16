package com.rajat.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(value="caat_cwb_translation_inbox")
public class CAATCWBTranslationInboxSetup {
	@Id
	private String _id;
	private String project_UUID;
	private String caat_cwb_workflow_UUID;
	private String projectCode;
	private String product;
	private String locale;
	private String geo;
	private String partNumber;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	private String allAPNList;
	private List<TemplateData> templateData;
	
	
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
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
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCaat_cwb_workflow_UUID() {
		return caat_cwb_workflow_UUID;
	}
	public void setCaat_cwb_workflow_UUID(String caat_cwb_workflow_UUID) {
		this.caat_cwb_workflow_UUID = caat_cwb_workflow_UUID;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public List<TemplateData> getTemplateData() {
		return templateData;
	}
	public void setTemplateData(List<TemplateData> templateData) {
		this.templateData = templateData;
	}
	
	public String getProject_UUID() {
		return project_UUID;
	}
	public void setProject_UUID(String project_UUID) {
		this.project_UUID = project_UUID;
	}
	public String getAllAPNList() {
		return allAPNList;
	}
	public void setAllAPNList(String allAPNList) {
		this.allAPNList = allAPNList;
	}
	@Override
	public String toString() {
		return "CAATCWBTranslationInboxSetup [_id=" + _id + ", caat_cwb_workflow_UUID=" + caat_cwb_workflow_UUID
				+ ", projectCode=" + projectCode + ", product=" + product + ", locale=" + locale + ", geo=" + geo
				+ ", partNumber=" + partNumber + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", templateData=" + templateData + "]";
	}
	
}
