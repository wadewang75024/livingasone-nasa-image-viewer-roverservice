package com.livingasone.nasaimageviewer.roverservice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.livingasone.nasaimageviewer.roverservice.clients.NasaRestClient;
import com.livingasone.nasaimageviewer.roverservice.data.Rover;
import com.livingasone.nasaimageviewer.roverservice.data.RoverList;

@RunWith(MockitoJUnitRunner.class)
public class RestTemplateClientTest {
	 
	    @Mock
	    private RestTemplate rest;
	 
	    @InjectMocks
	    private NasaRestClient client = new NasaRestClient();
	    
	    RoverList roverList = new RoverList();
	    
	    UriComponentsBuilder builder;
		 
		@Before
		public void init() {
			 	List<Rover> rovers = new ArrayList<Rover>();
		        Rover r5 = new Rover();
		        r5.setId("5");
		        r5.setId("Curiosity");
		        rovers.add(r5);
		        Rover r7 = new Rover();
		        r7.setId("7");
		        r7.setId("Spirit");
		        rovers.add(r7);
		        Rover r6 = new Rover();
		        r7.setId("6");
		        r7.setId("Opportunity");
		        rovers.add(r6);
		        roverList.setRovers(rovers);	    
		        
		        String urlOverHttps = AppConstants.NASA_REST_URI+AppConstants.NASA_REST_URI_ROVER_ENDPOINT;	    
				builder = UriComponentsBuilder.fromHttpUrl(urlOverHttps)
					        						.queryParam(AppConstants.NASA_API_KEY_PARAM_NAME, 
					        								    AppConstants.NASAS_API_KEY);
		}
	    
	    @Test
		public void testGetRovers() throws Exception {	
			 Mockito
		     .when(client.makeGetCallWithExchange(builder.toUriString(), 
		    		                              RoverList.class))
		     .thenReturn(new ResponseEntity<>(roverList, HttpStatus.OK));
			 
		     RoverList rlist = client.getRovers();
		     assertEquals(roverList, rlist);
		}
}
