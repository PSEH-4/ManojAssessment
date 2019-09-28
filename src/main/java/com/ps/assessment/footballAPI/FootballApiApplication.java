package com.ps.assessment.footballAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ps.assessment")
public class FootballApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballApiApplication.class, args);
	}

}
