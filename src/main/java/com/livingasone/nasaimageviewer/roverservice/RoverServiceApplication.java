package com.livingasone.nasaimageviewer.roverservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RoverServiceApplication {
	public static Logger logger = LogManager.getLogger(RoverServiceApplication.class);
	public static void main(String[] args) {
	    logger.info("RoverServiceApplication main starts...");
	    SpringApplication.run(RoverServiceApplication.class, args);
	}
}
