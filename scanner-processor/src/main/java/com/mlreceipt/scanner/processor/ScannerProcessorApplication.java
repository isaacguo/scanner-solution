package com.mlreceipt.scanner.processor;

import com.mlreceipt.scanner.processor.common.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties(StorageProperties.class)
@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})
public class ScannerProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScannerProcessorApplication.class, args);
	}


}
