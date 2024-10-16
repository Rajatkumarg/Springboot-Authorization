package com.rajat.entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdProfileClass {
	private Log LOGGER = LogFactory.getLog(ProdProfileClass.class);
	public ProdProfileClass() {
		LOGGER.info("ProdProfileClass constructor called");
	}
}
