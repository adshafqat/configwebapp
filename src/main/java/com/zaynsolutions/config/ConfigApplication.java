package com.zaynsolutions.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
@SpringBootApplication
public class ConfigApplication {


	@Value("${url}")
    private static String url; 

	@Value("${port}")
    private static String port; 

	public static void main(String[] args) {
		System.out.println("Here I am going to print the content of Config Map. URL:"+url+", port:"+port);
		SpringApplication.run(ConfigApplication.class, args);
	}

}
