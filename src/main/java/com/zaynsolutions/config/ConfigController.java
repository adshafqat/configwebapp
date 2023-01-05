package zaynsolutions.com.upwork;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.lang.Math;
import java.util.concurrent.*;
import org.springframework.beans.factory.annotation.Value;

	@Value("${url}")
  private String url; 

	@Value("${port}")
  private String port; 

@RestController
public class UpworkController {
	@GetMapping("/")
	public String returnResponse() {
		System.out.println("This is a dummy project. Date:"+url);		
		return "This is a test application. Random number value is :"+url+" DateTime:"+port;
	}


}
