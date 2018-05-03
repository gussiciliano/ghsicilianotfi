package com.unla.ghsicilianotfi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GhsicilianotfiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GhsicilianotfiApplication.class, args);
	}
}
