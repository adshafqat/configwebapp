package com.zaynsolutions.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class ConfigController {
	
private BackendProperties backendProperties;

	
	    @Autowired
	    public ConfigController(BackendProperties backendProperties) {
		this.backendProperties = backendProperties;
	    }

	
	@GetMapping("/")
	public String returnResponse() {
		System.out.println("This is a dummy project. URL:"+backendProperties.getUrl());		
		return "This is a test application. URL value is :"+backendProperties.getUrl()+" Port:"+backendProperties.getPort();
	}


}
