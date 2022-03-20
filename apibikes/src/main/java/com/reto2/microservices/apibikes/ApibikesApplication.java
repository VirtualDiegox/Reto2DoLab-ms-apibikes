package com.reto2.microservices.apibikes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ApibikesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApibikesApplication.class, args);
	}

}
