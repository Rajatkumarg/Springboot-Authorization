package com.rajat.controller;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoException;
import com.rajat.constants.CAATPortalConstants;
import com.rajat.dto.CWBTranslationInboxDataRequestDto;
import com.rajat.dto.CWBTranslationInboxDataResponseDto;
import com.rajat.dto.ResponseDto;
import com.rajat.dto.SearchParamsForTemplateSetup;
import com.rajat.dto.TranslationInboxMapping;
import com.rajat.entity.CAATCWBTranslationInboxSetup;
import com.rajat.entity.TemplateData;
import com.rajat.repo.CAATCWBTranslationInboxSetupRepo;
import com.rajat.util.CAATUtil;

@RestController
@RequestMapping("/myController")
public class MyController {
	
	private static final Logger LOGGER = LogManager.getLogger(MyController.class);

	@Autowired
	MongoOperations mongoOperations;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	CAATCWBTranslationInboxSetupRepo translationRepo;
    
	@GetMapping("/getName")
	public String getName() {
		System.out.println("Rajat");
		return "Rajat Kumar";
	}
	
	@PostMapping("/getCWBTranslationInboxData")
	public String getCWBTranslationInboxData(@RequestBody CWBTranslationInboxDataRequestDto requestDto){

		CWBTranslationInboxDataResponseDto responseDto = null;
		List<CAATCWBTranslationInboxSetup> entities = null;
		List<TranslationInboxMapping> templateMappings = new ArrayList<TranslationInboxMapping>();
		TranslationInboxMapping templateMapping = null;
		long totalCount = 0;
		try {
			if (requestDto.getProjectCode() != null) {
				if (requestDto.getProduct() != null) {


					List<TranslationInboxMapping> tempMappings = null;
					entities = translationRepo.findByProject_UUID(requestDto.getProject_UUID());
					if(entities!=null && !entities.isEmpty())
						requestDto.setLimit(entities.size());
					entities = null;
					if (requestDto.getLimit() != 0) {
						int pageSize = requestDto.getLimit();
						int pageNo;
						if (requestDto.getOffset() < pageSize) {
							pageNo = 0;
						} else {
							pageNo = requestDto.getOffset() / pageSize;
						}
						Sort sortObject = null;
						if (requestDto.getSortBy() != null && !requestDto.getSortBy().isBlank()) {
							if (requestDto.getSortBy().equalsIgnoreCase("locale")
									|| requestDto.getSortBy().equalsIgnoreCase("geo")
									|| requestDto.getSortBy().equalsIgnoreCase("partNumber")) {
								sortObject = Sort.by(requestDto.getSortBy());
								LOGGER.info("METHOD=getCWBTranslationInboxData Sorting " + requestDto.getSortBy());
							} else {
								sortObject = Sort.by("templateData." + requestDto.getSortBy());
							}
						} else {
							sortObject = Sort.by("templateData.updatedDate").descending();
						}
						if (requestDto.getSortType() != null && !requestDto.getSortType().isBlank()) {
							if (requestDto.getSortType().equalsIgnoreCase("desc"))
								sortObject = sortObject.descending();
							else
								sortObject = sortObject.ascending();
						}

						LOGGER.info("METHOD=getCWBTranslationInboxData search/sort params "
								+ requestDto.getSearchParams() + "" + requestDto.getSortBy());
				
						SearchParamsForTemplateSetup searchParams = requestDto.getSearchParams();
						if ((searchParams != null && ((searchParams.getLocale() != null
								&& !searchParams.getLocale().isBlank())
								|| (searchParams.getGeo() != null && !searchParams.getGeo().isBlank())
								|| (searchParams.getPartNumber() != null && !searchParams.getPartNumber().isBlank())
								|| (searchParams.getStatus() != null && !searchParams.getStatus().isBlank())
								|| (searchParams.getApprovedCount() != null
										&& !searchParams.getApprovedCount().isBlank())
								|| (searchParams.getCaCount() != null && !searchParams.getCaCount().isBlank())
								|| (searchParams.getPendingCount() != null && !searchParams.getPendingCount().isBlank())
								|| (searchParams.getRejectCount() != null && !searchParams.getRejectCount().isBlank())
								|| (searchParams.getVersion() != null && !searchParams.getVersion().isBlank())
								|| (searchParams.getRevision() != null && !searchParams.getRevision().isBlank())
								|| (searchParams.getSearch() != null && !searchParams.getSearch().isBlank())))
								|| requestDto.getSortBy() != null) {

							LOGGER.info("METHOD=getCWBTranslationInboxData SEARCHING");

							try {
								List<AggregationOperation> list = new ArrayList<AggregationOperation>();
								list.add(Aggregation.unwind("templateData"));
								list.add(Aggregation.match(Criteria.where("templateData.latest").is(true)));
								list.add(Aggregation
										.match(Criteria.where("projectCode").is(requestDto.getProjectCode())));
								list.add(Aggregation.match(Criteria.where("product").is(requestDto.getProduct())));
								list.add(Aggregation.match(Criteria.where("project_UUID").is(requestDto.getProject_UUID())));
								
								if (searchParams.getPartNumber() != null && !searchParams.getPartNumber().isBlank())
									list.add(Aggregation.match(new Criteria().orOperator(
										Criteria.where("partNumber").regex(searchParams.getPartNumber(), "i"),
										Criteria.where("allAPNList").regex(searchParams.getPartNumber(), "i"))));
								
								if (searchParams.getLocale() != null && !searchParams.getLocale().isBlank()) {
									Set<String> localeSet = new HashSet<>(Arrays.asList(searchParams.getLocale().toUpperCase().trim().split("\\s*,\\s*")));
									String localeRegex = String.join("|",localeSet);
									list.add(Aggregation
											.match(Criteria.where("locale").regex(localeRegex, "i")));
								}
								if (searchParams.getGeo() != null && !searchParams.getGeo().isBlank())
									list.add(
											Aggregation.match(Criteria.where("geo").regex(searchParams.getGeo(), "i")));
								if (searchParams.getStatus() != null && !searchParams.getStatus().isBlank())
									list.add(Aggregation.match(Criteria.where("templateData.status")
											.regex(searchParams.getStatus(), "i")));
								if (searchParams.getRevision() != null && !searchParams.getRevision().isBlank())
									list.add(Aggregation.match(Criteria.where("templateData.revision")
											.regex(searchParams.getRevision(), "i")));
								if (searchParams.getApprovedCount() != null
										&& !searchParams.getApprovedCount().isBlank())
									list.add(Aggregation.match(Criteria.where("templateData.approvedCount")
											.is(Integer.parseInt(searchParams.getApprovedCount()))));
								if (searchParams.getCaCount() != null && !searchParams.getCaCount().isBlank())
									list.add(Aggregation.match(Criteria.where("templateData.caCount")
											.is(Integer.parseInt(searchParams.getCaCount()))));
								if (searchParams.getPendingCount() != null && !searchParams.getPendingCount().isBlank())
									list.add(Aggregation.match(Criteria.where("templateData.pendingCount")
											.is(Integer.parseInt(searchParams.getPendingCount()))));
								if (searchParams.getRejectCount() != null && !searchParams.getRejectCount().isBlank())
									list.add(Aggregation.match(Criteria.where("templateData.rejectCount")
											.is(Integer.parseInt(searchParams.getRejectCount()))));

								if (searchParams.getVersion() != null && !searchParams.getVersion().isBlank()) {
									String version = searchParams.getVersion();
									if (version.charAt(0) == 'V' || version.charAt(0) == 'v')
										version = version.substring(1);
									else
										version = searchParams.getVersion();
									list.add(Aggregation.match(
											Criteria.where("templateData.version").is(Integer.parseInt(version))));
								}
								if (searchParams.getSearch() != null && !searchParams.getSearch().isBlank()) {
									int version = -1;
									int count = -1;

									String number = searchParams.getSearch();
									ParsePosition pos = new ParsePosition(0);
									NumberFormat.getInstance().parse(number, pos);
									if (number.length() == pos.getIndex())
										count = Integer.parseInt(number);
									if (number.charAt(0) == 'V' || number.charAt(0) == 'v')
										number = number.substring(1);
									NumberFormat.getInstance().parse(number, pos);
									if (number.length() == pos.getIndex())
										version = Integer.parseInt(number);
									LOGGER.info(
											"METHOD=getCWBTemplateData searching search " + searchParams.getSearch());
									list.add(Aggregation.match(new Criteria().orOperator(
											Criteria.where("partNumber").regex(searchParams.getSearch(), "i"),
											Criteria.where("allAPNList").regex(searchParams.getSearch(), "i"),
											Criteria.where("locale").regex(searchParams.getSearch(), "i"),
											Criteria.where("geo").regex(searchParams.getSearch(), "i"),
											Criteria.where("templateData.status").regex(searchParams.getSearch(), "i"),
											Criteria.where("templateData.revision").regex(searchParams.getSearch(),
													"i"),
											Criteria.where("templateData.approvedCount").is(count),
											Criteria.where("templateData.caCount").is(count),
											Criteria.where("templateData.pendingCount").is(count),
											Criteria.where("templateData.rejectCount").is(count),
											Criteria.where("templateData.version").is(version))));
								}
								list.add(Aggregation
										.group("caat_cwb_workflow_UUID", "projectCode", "product", "partNumber",
												"locale", "geo", "createdBy", "createdDate", "updatedBy", "updatedDate","allAPNList")
										.push("templateData").as("templateData"));
								list.add(Aggregation.project("caat_cwb_workflow_UUID", "projectCode", "product",
										"partNumber", "locale", "geo", "createdBy", "createdDate", "updatedBy",
										"updatedDate","allAPNList","templateData"));
								list.add(Aggregation.sort(sortObject));

								entities = mongoOperations
										.aggregate(Aggregation.newAggregation(CAATCWBTranslationInboxSetup.class, list),
												CAATCWBTranslationInboxSetup.class, CAATCWBTranslationInboxSetup.class)
										.getMappedResults();
								totalCount = entities.size();

								list.add(Aggregation.limit(requestDto.getLimit() + requestDto.getOffset()));
								list.add(Aggregation.skip(requestDto.getOffset()));
								entities = mongoOperations
										.aggregate(Aggregation.newAggregation(CAATCWBTranslationInboxSetup.class, list),
												CAATCWBTranslationInboxSetup.class, CAATCWBTranslationInboxSetup.class)
										.getMappedResults();

							} catch (MongoException e) {
								LOGGER.error("METHOD=getCWBTranslationInboxData, exception = {}", e.getMessage());
								LOGGER.error(CAATUtil.getJsonResponseString(e));
							}
						} else {

							Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("updatedDate").descending());
							Query query = new Query();
							query.addCriteria(Criteria.where("projectCode").is(requestDto.getProjectCode()));
							query.addCriteria(Criteria.where("product").is(requestDto.getProduct()));
							query.addCriteria(Criteria.where("project_UUID").is(requestDto.getProject_UUID()));

							query.with(pageable);
							entities = mongoTemplate.find(query, CAATCWBTranslationInboxSetup.class);
						}
					} else {
						entities = translationRepo.findByProject_UUID(requestDto.getProject_UUID());
					}

					LOGGER.info("getCWBTranslationInboxData: RequestDto " + requestDto.getProjectCode() + " "
							+ requestDto.getProduct());
					LOGGER.info("getCWBTranslationInboxData: findAllByProjectCodeAndProductForTranslation "
							+ CAATUtil.getJsonResponseString(entities));
					if (entities != null && !entities.isEmpty()) {
						
						LOGGER.info("getCWBTranslationInboxData entities not null");
						responseDto = new CWBTranslationInboxDataResponseDto();
						responseDto.setTotalCount(totalCount);
						responseDto.setProjectCode(entities.get(0).getProjectCode());
						responseDto.setProduct(entities.get(0).getProduct());
						responseDto.setProject_UUID(entities.get(0).getProject_UUID());


						for (CAATCWBTranslationInboxSetup entity : entities) {
								LOGGER.info("getCWBTranslationInboxData CAATCWBTranslationInboxSetup "
									+ CAATUtil.getJsonResponseString(entity));
							String caat_cwb_workflow_UUID = entity.getCaat_cwb_workflow_UUID();

							templateMapping = new TranslationInboxMapping();
							templateMapping.setCaat_cwb_workflow_UUID(caat_cwb_workflow_UUID);
							templateMapping.setLocale(entity.getLocale());
							LOGGER.info("getCWBTranslationInboxData CAATCWBTranslationInboxSetup, fetching getAllAPNList ");
							
							templateMapping.setGeo(entity.getGeo());
							for (TemplateData templateData : entity.getTemplateData()) {
								if (templateData != null && templateData.isLatest()) {
									templateMapping.setLatest(templateData.isLatest());
									templateMapping.setVersion(templateData.getVersion());
									templateMapping.setStatus(templateData.getStatus());
									LOGGER.info("data. revision 4: " + String.valueOf(templateData.getRevision()));
								}
							}

							templateMappings.add(templateMapping);
							LOGGER.info("getCWBTranslationInboxData: templateMapping "
									+ CAATUtil.getJsonResponseString(templateMapping));
							
						}
						responseDto.setData(templateMappings);

						LOGGER.info(
								"getCWBTranslationInboxData Mongo entity " + CAATUtil.getJsonResponseString(entities));
					} else {
						LOGGER.info("getCWBTranslationInboxData Record not found");
					}
				} else {
					LOGGER.info("getCWBTranslationInboxData Product from request" + requestDto.getProduct()
							+ " is not provided");
				}
			}

			else {
				LOGGER.info(
						"getCWBTranslationInboxData ProjectCode from request not found " + requestDto.getProjectCode());
			}
		} catch (NullPointerException npe) {
			LOGGER.error("getCWBTranslationInboxData NullPointerException: error message = " + npe.getMessage());
		} catch (IllegalArgumentException iae) {
			LOGGER.error("getCWBTranslationInboxData IllegalArgumentException: error message = " + iae.getMessage());
		}catch (Exception e) {
			LOGGER.info("getCWBTranslationInboxData Exception message ");
			LOGGER.error(e.getMessage(), CAATUtil.getJsonResponseString(e));
		}

		String message = responseDto == null ? "Could Not Retrieve CWB Translation Inbox Data Information"
				: "CWB Translation Inbox Data Information Retrieved Successfully";
		String status = responseDto == null ? CAATPortalConstants.CAAT_STATUS_SUCCESS
				: CAATPortalConstants.CAAT_STATUS_SUCCESS;
		ResponseDto beanResponseDto = CAATUtil.getJsonResponseObject(responseDto, status, message);
		LOGGER.info("---CAATTranslationInboxController::::getCWBTranslationInboxData::::END---");
		return CAATUtil.getJsonResponseString(beanResponseDto);
	}
	
}
