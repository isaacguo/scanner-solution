package com.mlreceipt.scanner.processor.feignclients;

import com.mlreceipt.scanner.common.feignclients.IDataFeignClient;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name="ScannerData")
public interface DataFeignClient extends IDataFeignClient {
}
