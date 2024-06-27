package com.medicine.apiggteway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiggtewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiggtewayApplication.class, args);
	}

}
