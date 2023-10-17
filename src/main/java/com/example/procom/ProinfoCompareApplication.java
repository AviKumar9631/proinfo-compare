package com.example.procom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProinfoCompareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProinfoCompareApplication.class, args);
		
		CompareResponses.compareApi();
	}

}
