package com.mlreceipt.scanner.processor.services.execution;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;

public interface ScanExecutionService {
    void execute(String imagePath, ScanTaskEntity scanTaskEntity);
}
