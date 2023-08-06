package com.akr.business.url.shortner.creator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UrlShortnerCreationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortnerCreationApplication.class, args);
	}

}
