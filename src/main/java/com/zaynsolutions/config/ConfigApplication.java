package com.zaynsolutions.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
@SpringBootApplication
public class ConfigApplication {


	public static void main(String[] args) {
		System.out.println("This is a dummy project.");		
		SpringApplication.run(ConfigApplication.class, args);
	}

}
