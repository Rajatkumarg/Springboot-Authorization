package com.rajat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

import com.rajat.dto.GenevaFileDTO;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TemplateData {
	
	
	private boolean latest;
	private int version;
	private String fileName;
	private String geneva_UUID;

	private List<GenevaFileDTO> files;
	
	private String demoFileName;
	private String demoGeneva_UUID;
	
	private String ktoFileName;
	private String ktoGeneva_UUID;
	
	private String uploadedBy;
	private Date uploadedDate;
	private int approvedCount;
	private int caCount;
	private int rejectCount;
	private int pendingCount;
	private String status;
	private String updatedBy;
	private Date updatedDate;
	private String type;
	private String set;
	private String carrier;	
	private String partNumber;
	private String latestGenevaID;
	private String translationRadar;
	private String content;
	private boolean sendToApproval;
	private String revision;

	private String zipFileName;
	private String zipGeneva_UUID;
	private  boolean isFansiPublishLoc;

	public String getKtoFileName() {
		return ktoFileName;
	}
	public void setKtoFileName(String ktoFileName) {
		this.ktoFileName = ktoFileName;
	}
	public String getKtoGeneva_UUID() {
		return ktoGeneva_UUID;
	}
	public void setKtoGeneva_UUID(String ktoGeneva_UUID) {
		this.ktoGeneva_UUID = ktoGeneva_UUID;
	}
	public boolean isSendToApproval() {
		return sendToApproval;
	}
	public void setSendToApproval(boolean sendToApproval) {
		this.sendToApproval = sendToApproval;
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
	public String getDemoFileName() {
		return demoFileName;
	}
	public void setDemoFileName(String demoFileName) {
		this.demoFileName = demoFileName;
	}
	public String getDemoGeneva_UUID() {
		return demoGeneva_UUID;
	}
	public void setDemoGeneva_UUID(String demoGeneva_UUID) {
		this.demoGeneva_UUID = demoGeneva_UUID;
	}
	public String getUploadedBy() {
		return uploadedBy;
	}
	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	public Date getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getLatestGenevaID() {
		return latestGenevaID;
	}

	public void setLatestGenevaID(String latestGenevaID) {
		this.latestGenevaID = latestGenevaID;
	}

	public String getTranslationRadar() {
		return translationRadar;
	}

	public void setTranslationRadar(String translationRadar) {
		this.translationRadar = translationRadar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}

	public List<GenevaFileDTO> getFiles() {
		return files;
	}
	public void setFiles(List<GenevaFileDTO> files) {
		this.files = files;
	}

	public String getZipFileName() {
		return zipFileName;
	}

	public void setZipFileName(String zipFileName) {
		this.zipFileName = zipFileName;
	}

	public String getZipGeneva_UUID() {
		return zipGeneva_UUID;
	}

	public void setZipGeneva_UUID(String zipGeneva_UUID) {
		this.zipGeneva_UUID = zipGeneva_UUID;
	}

	public boolean isFansiPublishLoc() {
		return isFansiPublishLoc;
	}

	public void setFansiPublishLoc(boolean isFansiPublishLoc) {
		this.isFansiPublishLoc = isFansiPublishLoc;
	}
	
}
