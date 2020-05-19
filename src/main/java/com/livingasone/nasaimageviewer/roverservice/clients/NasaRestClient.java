package com.livingasone.nasaimageviewer.roverservice.clients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.livingasone.nasaimageviewer.roverservice.AppConstants;
import com.livingasone.nasaimageviewer.roverservice.data.RoverList;

@Service
public class NasaRestClient extends RestTemplateClient {
	public static Logger logger = LogManager.getLogger(NasaRestClient.class);
	
	public RoverList getRovers() throws Exception {
		logger.info("getRoverList starts...");	
		
		String urlOverHttps = AppConstants.NASA_REST_URI+AppConstants.NASA_REST_URI_ROVER_ENDPOINT;	    
		UriComponentsBuilder builder = 
					UriComponentsBuilder.fromHttpUrl(urlOverHttps)
			        						.queryParam(AppConstants.NASA_API_KEY_PARAM_NAME, 
			        								    AppConstants.NASAS_API_KEY);
			
		logger.info("Making the call with URL: " + builder.toUriString());			
	    //ResponseEntity<RoverList> response = rest.exchange(builder.toUriString(), HttpMethod.GET, null, RoverList.class); 
		ResponseEntity<RoverList> response = makeGetCallWithExchange(builder.toUriString(), RoverList.class);
	    return response.getBody();
	}
}
