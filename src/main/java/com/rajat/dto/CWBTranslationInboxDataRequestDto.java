package com.rajat.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CWBTranslationInboxDataRequestDto {
	private String caat_cwb_workflow_UUID;
	private String project_UUID;
	private String projectCode;
	private String product;
	private String locale;
	private String workflow;
	private String geo;
	private List<TemplateDataDto> data;
	private String selection;
	
	private int limit;
	private int offset;
	private String sortBy;
	private String sortType;
	private SearchParamsForTemplateSetup searchParams;
	private String partNumber;
	private String runType;
	private String runTypeValue;
	List<String> productTypes;
	public String getRunType() {
		return runType;
	}
	public void setRunType(String runType) {
		this.runType = runType;
	}
	public String getRunTypeValue() {
		return runTypeValue;
	}
	public void setRunTypeValue(String runTypeValue) {
		this.runTypeValue = runTypeValue;
	}
	public List<String> getProductTypes() {
		return productTypes;
	}
	public void setProductTypes(List<String> productTypes) {
		this.productTypes = productTypes;
	}
	
	
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public SearchParamsForTemplateSetup getSearchParams() {
		return searchParams;
	}
	public void setSearchParams(SearchParamsForTemplateSetup searchParams) {
		this.searchParams = searchParams;
	}
	public String getSelection() {
		return selection;
	}
	public void setSelection(String selection) {
		this.selection = selection;
	}
	public List<TemplateDataDto> getData() {
		return data;
	}
	public void setData(List<TemplateDataDto> data) {
		this.data = data;
	}
	public String getCaat_cwb_workflow_UUID() {
		return caat_cwb_workflow_UUID;
	}
	public void setCaat_cwb_workflow_UUID(String caat_cwb_workflow_UUID) {
		this.caat_cwb_workflow_UUID = caat_cwb_workflow_UUID;
	}
	public String getProject_UUID() {
		return project_UUID;
	}
	public void setProject_UUID(String project_UUID) {
		this.project_UUID = project_UUID;
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
	
	public String getWorkflow() {
		return workflow;
	}
	public void setWorkflow(String workflow) {
		this.workflow = workflow;
	}
	
	@Override
	public String toString() {
		return "CWBTranslationInboxDataRequestDto [caat_cwb_workflow_UUID=" + caat_cwb_workflow_UUID + ", project_UUID="
				+ project_UUID + ", projectCode=" + projectCode + ", product=" + product + ", locale=" + locale
				+ ", workflow=" + workflow + ", geo=" + geo + ", data=" + data + ", selection=" + selection + "]";
	}
	
}
