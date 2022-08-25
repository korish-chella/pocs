package com.learnwell.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PocApplication {
	static Logger  logger = LoggerFactory.getLogger(PocApplication.class);
	public static void main(String[] args) {
		logger.info("Entered Main applicaion in POC");
		SpringApplication.run(PocApplication.class, args);
	}

}
