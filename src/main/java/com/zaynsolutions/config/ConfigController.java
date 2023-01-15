package com.zaynsolutions.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class ConfigController {


	@Autowired
	private BackendserverProperties backendserverProperties;
	
	@Value("${testurl}")
   	private String urlvalue;
	
	@GetMapping("/")
	public String returnResponse() {
		System.out.println("This is a test application. URL1:"+urlvalue+" URL2:"+backendserverProperties.getUrl());		
		return "This is a test application. URL1:"+urlvalue+". URL2 value is :"+backendserverProperties.getUrl()+" Port:"+backendserverProperties.getPort();
	}


}
