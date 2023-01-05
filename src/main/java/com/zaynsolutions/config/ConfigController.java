package com.zaynsolutions.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class ConfigController {

	@Autowired
	private BackendserverProperties BackendserverProperties;

	
	    @Autowired
	    public ConfigController(BackendserverProperties BackendserverProperties) {
		this.BackendserverProperties = BackendserverProperties;
	    }

	@Value("${transformer.mode}")
   	private String urlvalue;
	
	@GetMapping("/")
	public String returnResponse() {
		System.out.println("This is a dummy project. URL:"+urlvalue+" URL:"+BackendserverProperties.getUrl());		
		return "This is a test application. URL value is :"+BackendserverProperties.getUrl()+" Port:"+BackendserverProperties.getPort();
	}


}
