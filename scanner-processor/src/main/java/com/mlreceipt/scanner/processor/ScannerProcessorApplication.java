package com.mlreceipt.scanner.processor;

import com.mlreceipt.scanner.processor.common.ScanExecutorProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties({ScanExecutorProperties.class})
@EnableFeignClients
@ComponentScan(basePackages = {"com.mlreceipt.scanner"})
@EntityScan("com.mlreceipt.scanner")
@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})
public class ScannerProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScannerProcessorApplication.class, args);
	}

}
