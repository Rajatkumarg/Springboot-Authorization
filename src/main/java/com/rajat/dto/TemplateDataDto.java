package com.rajat.dto;


import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class TemplateDataDto {
	private boolean latest;
	private int version;
	private String fileName;
	private List<GenevaFileDTO> files;
	private String geneva_UUID;
	private String uploadedBy;
	private Date uploadedDate;
	private String type;
	private String additional_instructions;
	private boolean seg11NotApplicable;
	private String language;
	private String locale;
	private String set_type;
	private String updatedBy;
	private Date updatedDate;
	private boolean translationNotApplicable;
	private String partNumber;
	private String revision;
	
	public List<GenevaFileDTO> getFiles() {
		return files;
	}

	public void setFiles(List<GenevaFileDTO> files) {
		this.files = files;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

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

	public String getLanguage() {
		return language;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getSetType() {
		return set_type;
	}

	public void setSetType(String setType) {
		this.set_type = setType;
	}

	public boolean isTranslationNotApplicable() {
		return translationNotApplicable;
	}

	public void setTranslationNotApplicable(boolean translationNotApplicable) {
		this.translationNotApplicable = translationNotApplicable;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getAdditional_instructions() {
		return additional_instructions;
	}

	public void setAdditional_instructions(String additional_instructions) {
		this.additional_instructions = additional_instructions;
	}

	public boolean isSeg11NotApplicable() {
		return seg11NotApplicable;
	}

	public void setSeg11NotApplicable(boolean seg11NotApplicable) {
		this.seg11NotApplicable = seg11NotApplicable;
	}

	@Override
	public String toString() {
		return "TemplateDataDto [latest=" + latest + ", version=" + version + ", fileName=" + fileName
				+ ", geneva_UUID=" + geneva_UUID + ", uploadedBy=" + uploadedBy + ", uploadedDate=" + uploadedDate
				+ ", type=" + type + ", additional_instructions=" + additional_instructions + ", seg11NotApplicable="
				+ seg11NotApplicable + ", language=" + language + ", locale=" + locale + ", setType=" + set_type
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", translationNotApplicable="
				+ translationNotApplicable + "]";
	}

	
}