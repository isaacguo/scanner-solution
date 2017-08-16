package com.mlreceipt.scanner.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ScannerEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScannerEurekaApplication.class, args);
	}
}
