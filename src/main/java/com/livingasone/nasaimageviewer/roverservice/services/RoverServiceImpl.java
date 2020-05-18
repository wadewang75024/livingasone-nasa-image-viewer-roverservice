package com.livingasone.nasaimageviewer.roverservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livingasone.nasaimageviewer.roverservice.clients.NasaRestClient;
import com.livingasone.nasaimageviewer.roverservice.data.RoverList;

@Service
public class RoverServiceImpl implements RoverService {
	
	@Autowired 
	private NasaRestClient client;
	
	public RoverList getRovers() throws Exception {
		return client.getRovers();
	}
}
