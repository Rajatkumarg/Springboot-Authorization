package com.rajat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MySpringbootProject1Application implements CommandLineRunner{

	private Log LOGGER = LogFactory.getLog(MySpringbootProject1Application.class);
	@Autowired
	Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(MySpringbootProject1Application.class, args).stop();;
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info(env.getProperty("message"));
	}

}
