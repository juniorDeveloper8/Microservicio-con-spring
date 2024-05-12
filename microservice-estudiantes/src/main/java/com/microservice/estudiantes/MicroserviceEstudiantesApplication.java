package com.microservice.estudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceEstudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEstudiantesApplication.class, args);
	}

}
