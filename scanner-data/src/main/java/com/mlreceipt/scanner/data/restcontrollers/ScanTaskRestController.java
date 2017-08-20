package com.mlreceipt.scanner.data.restcontrollers;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import com.mlreceipt.scanner.common.enums.ScanTaskStatusEnum;
import com.mlreceipt.scanner.data.services.scantask.ScanTaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scantasks")
public class ScanTaskRestController {

    private final ScanTaskService scanTaskService;

    public ScanTaskRestController(ScanTaskService scanTaskService) {
        this.scanTaskService = scanTaskService;
    }

    @GetMapping
    public List<ScanTaskEntity> getScanTasks() {
        return this.scanTaskService.getScanTasks();
    }

    @GetMapping("/bystatus/{status}/")
    public List<ScanTaskEntity> getScanTasksByStatus(@PathVariable("status") ScanTaskStatusEnum status) {
        return this.scanTaskService.getScanTasksByStatus(status);
    }

    @PostMapping("/insert")
    public ScanTaskEntity insertScanTask(@RequestBody ScanTaskEntity scanTaskEntity) {
        return this.scanTaskService.insertScanTask(scanTaskEntity);
    }
}
