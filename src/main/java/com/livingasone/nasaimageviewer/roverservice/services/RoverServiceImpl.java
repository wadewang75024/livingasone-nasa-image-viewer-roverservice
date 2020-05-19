package com.livingasone.nasaimageviewer.roverservice.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livingasone.nasaimageviewer.roverservice.RoverServiceApplication;
import com.livingasone.nasaimageviewer.roverservice.clients.NasaRestClient;
import com.livingasone.nasaimageviewer.roverservice.data.RoverList;

@Service
public class RoverServiceImpl implements RoverService {
	public static Logger logger = LogManager.getLogger(RoverServiceImpl.class);
	
	@Autowired 
	private NasaRestClient client;
	
	public RoverList getRovers() throws Exception {
		logger.info("getRovers");
		return client.getRovers();
	}
}
