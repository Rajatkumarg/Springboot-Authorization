package com.rajat.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rajat.dto.CWBTranslationInboxDataResponseDto;
import com.rajat.dto.ResponseDto;

@Component
public class CAATUtil {

	private static final Logger LOGGER = LogManager.getLogger(CAATUtil.class);
	
	public static String getJsonResponseString(Object obj) {
		String json = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOGGER.error("CAATUtil"+" getJsonResponseString :"+ "error message : " + e.getMessage());
		}
		return json;
	}

	public static ResponseDto getJsonResponseObject(Object data, String status, String userMessage) {

		ResponseDto responseBean = new ResponseDto();
		responseBean.setStatus(status);
		responseBean.setData(data);
		responseBean.setStatusMessage(userMessage);
		return responseBean;
	}
}
