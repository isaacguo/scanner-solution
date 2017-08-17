package com.mlreceipt.scanner.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.mlreceipt.scanner"})
@EntityScan("com.mlreceipt.scanner")
public class ScannerDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScannerDataApplication.class, args);
	}
}
