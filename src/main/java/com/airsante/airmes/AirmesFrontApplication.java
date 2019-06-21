package com.airsante.airmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class AirmesFrontApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AirmesFrontApplication.class, args);
	}

}
