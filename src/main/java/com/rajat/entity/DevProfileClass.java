package com.rajat.entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevProfileClass {
	private Log LOGGER = LogFactory.getLog(ProdProfileClass.class);
	public DevProfileClass() {
		LOGGER.info("DevProfileClass constructor called");
	}
}
