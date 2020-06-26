package com.onlinetest;

import java.io.FileReader;

import org.apache.catalina.webresources.FileResource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OnlineTestingApplication {

	public static void main(String[] args) {
		System.out.println("Mian method");
		SpringApplication.run(OnlineTestingApplication.class, args);
		
	}

}
