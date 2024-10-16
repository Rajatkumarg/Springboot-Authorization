package com.rajat.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
public class SearchParamsForTemplateSetup {

	private String search;
	private String template;
	private String locale;
	private String geo;
	private String sentInBatch;
	private String version;
	private String stage;
	private String status;
	private String approvedCount;
	private String caCount;
	private String rejectCount;
	private String pendingCount;
	//extra filter attribute for F&B
	private String set;
	private String type;
	//extra filter attribute for F&B and IOR
	private String partNumber;
	//extra filter attribute for pdfGeberation
	private String part;
	//extra filter attribute for udm and review_BOB
	private String mpn;
	private String site;
	//extra filter attribute for SendToFactory
	private String region;
	private String engMergerPN;
	private String fileName;
	private String updatedBy;
	private String fromUpdatedDate;
	private String toUpdatedDate;
	//extra filter attribute for MPNBlowout
	private String base;
	private String model;
	private Date effectiveDate;
	private String productType;
	private String upc;
	@ToString.Exclude
    private String agileDescription;
	private String color;
	private String jan;
	//extra filter attribute for Content Aggregation
	private String bobTemplatePN;
	private String inversePrint;
	private String other;
	private String cooPrefix;
	private String demoText;
	private String demoTextLineQty;
	private String carrier;
	private String simIn;
	private String esim;
	private String fbIORTemplatePN;
	private String fbIORTemplateDemoPN;
	private String seg11PN;
	private String seg11DemoPN;
	private String productRedPN;
	private String fromEffectiveDate;
	private String toEffectiveDate;
	//extra filter attribute for Translation/Localisation
	private String revision;

	private String QRCode;
	private String seg11Status;
	private String ocrValidationStatus;
	private String allAPNList;
	private String envMsgFiles;
	private String side;

	public String getOcrValidationStatus() {
		return ocrValidationStatus;
	}

	public void setOcrValidationStatus(String ocrValidationStatus) {
		this.ocrValidationStatus = ocrValidationStatus;
	}

	public String getSeg11Status() {
		return seg11Status;
	}
	public void setSeg11Status(String seg11Status) {
		this.seg11Status = seg11Status;
	}
	public String getQRCode() {
		return QRCode;
	}
	public void setQRCode(String QRCode) {
		this.QRCode = QRCode;
	}

	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public String getFromEffectiveDate() {
		return fromEffectiveDate;
	}
	public void setFromEffectiveDate(String fromEffectiveDate) {
		this.fromEffectiveDate = fromEffectiveDate;
	}
	public String getToEffectiveDate() {
		return toEffectiveDate;
	}
	public void setToEffectiveDate(String toEffectiveDate) {
		this.toEffectiveDate = toEffectiveDate;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getBobTemplatePN() {
		return bobTemplatePN;
	}
	public void setBobTemplatePN(String bobTemplatePN) {
		this.bobTemplatePN = bobTemplatePN;
	}
	public String getInversePrint() {
		return inversePrint;
	}
	public void setInversePrint(String inversePrint) {
		this.inversePrint = inversePrint;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getCooPrefix() {
		return cooPrefix;
	}
	public void setCooPrefix(String cooPrefix) {
		this.cooPrefix = cooPrefix;
	}
	public String getDemoText() {
		return demoText;
	}
	public void setDemoText(String demoText) {
		this.demoText = demoText;
	}
	public String getDemoTextLineQty() {
		return demoTextLineQty;
	}
	public void setDemoTextLineQty(String demoTextLineQty) {
		this.demoTextLineQty = demoTextLineQty;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getSimIn() {
		return simIn;
	}
	public void setSimIn(String simIn) {
		this.simIn = simIn;
	}
	public String getEsim() {
		return esim;
	}
	public void setEsim(String esim) {
		this.esim = esim;
	}
	public String getFbIORTemplatePN() {
		return fbIORTemplatePN;
	}
	public void setFbIORTemplatePN(String fbIORTemplatePN) {
		this.fbIORTemplatePN = fbIORTemplatePN;
	}
	public String getFbIORTemplateDemoPN() {
		return fbIORTemplateDemoPN;
	}
	public void setFbIORTemplateDemoPN(String fbIORTemplateDemoPN) {
		this.fbIORTemplateDemoPN = fbIORTemplateDemoPN;
	}
	public String getSeg11PN() {
		return seg11PN;
	}
	public void setSeg11PN(String seg11pn) {
		seg11PN = seg11pn;
	}
	public String getSeg11DemoPN() {
		return seg11DemoPN;
	}
	public void setSeg11DemoPN(String seg11DemoPN) {
		this.seg11DemoPN = seg11DemoPN;
	}
	public String getProductRedPN() {
		return productRedPN;
	}
	public void setProductRedPN(String productRedPN) {
		this.productRedPN = productRedPN;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getAgileDescription() {
		return agileDescription;
	}
	public void setAgileDescription(String agileDescription) {
		this.agileDescription = agileDescription;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getJan() {
		return jan;
	}
	public void setJan(String jan) {
		this.jan = jan;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getEngMergerPN() {
		return engMergerPN;
	}
	public void setEngMergerPN(String engMergerPN) {
		this.engMergerPN = engMergerPN;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getFromUpdatedDate() {
		return fromUpdatedDate;
	}
	public void setFromUpdatedDate(String fromUpdatedDate) {
		this.fromUpdatedDate = fromUpdatedDate;
	}
	public String getToUpdatedDate() {
		return toUpdatedDate;
	}
	public void setToUpdatedDate(String toUpdatedDate) {
		this.toUpdatedDate = toUpdatedDate;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getMpn() {
		return mpn;
	}
	public void setMpn(String mpn) {
		this.mpn = mpn;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getSet() {
		return set;
	}
	public void setSet(String set) {
		this.set = set;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getApprovedCount() {
		return approvedCount;
	}
	public void setApprovedCount(String approvedCount) {
		this.approvedCount = approvedCount;
	}
	public String getCaCount() {
		return caCount;
	}
	public void setCaCount(String caCount) {
		this.caCount = caCount;
	}
	public String getRejectCount() {
		return rejectCount;
	}
	public void setRejectCount(String rejectCount) {
		this.rejectCount = rejectCount;
	}
	public String getPendingCount() {
		return pendingCount;
	}
	public void setPendingCount(String pendingCount) {
		this.pendingCount = pendingCount;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}	
}
