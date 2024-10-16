package com.rajat.entity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
public class SpringProfile {

	private Log LOGGER = LogFactory.getLog(SpringProfile.class);
	
	@Bean
	@Profile("dev")
	public void SpringProfileDev() {
		LOGGER.info("SpringProfileDev called");
	}
	
	@Bean
	@Profile("prod")
	public void SpringProfileProd() {
		LOGGER.info("SpringProfileProd called");
	}
}
