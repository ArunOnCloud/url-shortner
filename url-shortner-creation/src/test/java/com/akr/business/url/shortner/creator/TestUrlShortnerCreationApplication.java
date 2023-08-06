package com.akr.business.url.shortner.creator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestUrlShortnerCreationApplication {

	public static void main(String[] args) {
		SpringApplication.from(UrlShortnerCreationApplication::main).with(TestUrlShortnerCreationApplication.class).run(args);
	}

}
