package com.mlreceipt.scanner.data.services.scantask;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;

import java.util.List;

public interface ScanTaskService {

    List<ScanTaskEntity> getScanTasks();
    ScanTaskEntity insertScanTask(ScanTaskEntity scanTask);

}
