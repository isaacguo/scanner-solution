package com.mlreceipt.scanner.data.services.scantask;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import com.mlreceipt.scanner.common.enums.ScanTaskStatusEnum;

import java.util.List;

public interface ScanTaskService {

    List<ScanTaskEntity> getScanTasks();
    ScanTaskEntity insertScanTask(ScanTaskEntity scanTask);
    List<ScanTaskEntity> getScanTasksByStatus(ScanTaskStatusEnum status);
}
