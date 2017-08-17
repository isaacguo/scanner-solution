package com.mlreceipt.scanner.data.services.scantask;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import com.mlreceipt.scanner.data.repositories.ScanTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScanTaskServiceImpl implements ScanTaskService {

    ScanTaskRepository scanTaskRepository;

    public ScanTaskServiceImpl(ScanTaskRepository scanTaskRepository) {
        this.scanTaskRepository = scanTaskRepository;
    }

    @Override
    public List<ScanTaskEntity> getScanTasks() {
        return this.scanTaskRepository.findAll();
    }

    @Override
    public ScanTaskEntity insertScanTask(ScanTaskEntity scanTask) {
        return this.scanTaskRepository.save(scanTask);
    }
}
