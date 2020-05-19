package com.livingasone.nasaimageviewer.roverservice.apis;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livingasone.nasaimageviewer.roverservice.RoverServiceApplication;
import com.livingasone.nasaimageviewer.roverservice.data.RoverList;
import com.livingasone.nasaimageviewer.roverservice.exceptions.BusinessException;
import com.livingasone.nasaimageviewer.roverservice.services.RoverService;

@RestController
@RequestMapping("/api/v1")
public class RoverServiceApi {
	public static Logger logger = LogManager.getLogger(RoverServiceApi.class);
	
	@Autowired
	private RoverService service;
	
	@GetMapping("/rovers")
	public RoverList getRovers() {
		logger.info("getRovers...");
		try {
			return service.getRovers();
		}
		catch (Exception e) {
			throw new BusinessException();
		}
	}
}
