package com.livingasone.nasaimageviewer.roverservice.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livingasone.nasaimageviewer.roverservice.data.RoverList;
import com.livingasone.nasaimageviewer.roverservice.exceptions.BusinessException;
import com.livingasone.nasaimageviewer.roverservice.services.RoverService;

@RestController
@RequestMapping("/api/v1")
public class RoverServiceApi {
	
	@Autowired
	private RoverService service;
	
	@GetMapping("/rovers")
	public RoverList getRovers() {
		try {
			return service.getRovers();
		}
		catch (Exception e) {
			throw new BusinessException();
		}
	}
}
