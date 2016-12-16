package com.osi.urm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestservicesApplication.class, args);
	}
}
