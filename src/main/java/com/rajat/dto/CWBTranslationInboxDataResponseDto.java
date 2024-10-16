package com.rajat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CWBTranslationInboxDataResponseDto {

	private String project_UUID;
	private String projectCode;
	private String product;
	private List<TranslationInboxMapping> data;
	private long totalCount;
	
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
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
	public List<TranslationInboxMapping> getData() {
		return data;
	}
	public void setData(List<TranslationInboxMapping> data) {
		this.data = data;
	}
	
	public String getProject_UUID() {
		return project_UUID;
	}
	public void setProject_UUID(String project_UUID) {
		this.project_UUID = project_UUID;
	}
	@Override
	public String toString() {
		return "CWBTemplateDataResponseDto [projectCode=" + projectCode + ", product=" + product + ", data=" + data
				+ "]";
	}
	
}
