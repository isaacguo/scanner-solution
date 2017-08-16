package com.mlreceipt.scanner.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ScannerProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScannerProcessorApplication.class, args);
	}
}
