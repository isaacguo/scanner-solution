package com.mlreceipt.scanner.data;

import com.mlreceipt.scanner.common.entities.ScanPairEntity;
import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import com.mlreceipt.scanner.common.enums.ScanTaskStatusEnum;
import com.mlreceipt.scanner.data.services.scantask.ScanTaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.mlreceipt.scanner"})
@EntityScan("com.mlreceipt.scanner")
public class ScannerDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScannerDataApplication.class, args);
	}
}

@Configuration
@Transactional
class MyConf {
	@Bean
	CommandLineRunner commandLineRunner(ScanTaskService scanTaskService) {


		return new CommandLineRunner() {


			@Override
			public void run(String... strings) throws Exception {
				ScanTaskEntity scanTaskEntity=new ScanTaskEntity();
				scanTaskEntity.setStatus(ScanTaskStatusEnum.SCANNED);

				ScanPairEntity scanPairEntity=new ScanPairEntity();
				scanPairEntity.setText("abc");
				scanPairEntity.setImageName("a.jpg");
				scanTaskEntity.addScanPair(scanPairEntity);

				ScanPairEntity scanPairEntity1=new ScanPairEntity();
				scanPairEntity1.setText("def");
				scanPairEntity1.setImageName("b.jpg");
				scanTaskEntity.addScanPair(scanPairEntity1);

				scanTaskService.insertScanTask(scanTaskEntity);
			}

		};
	}
}
