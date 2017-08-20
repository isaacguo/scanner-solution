package com.mlreceipt.scanner.common.feignclients;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IDataFeignClient {

    @PostMapping("/scantasks/insert")
    public ScanTaskEntity insertScanTask(@RequestBody ScanTaskEntity scanTaskEntity);
}
