package com.mlreceipt.scanner.data.restcontrollers;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import com.mlreceipt.scanner.data.services.scantask.ScanTaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scantasks")
public class ScanTaskRestController {

   private final ScanTaskService scanTaskService;

   public ScanTaskRestController(ScanTaskService scanTaskService) {
      this.scanTaskService = scanTaskService;
   }

   @GetMapping
   public List<ScanTaskEntity> getScanTasks()
   {
      return this.scanTaskService.getScanTasks();
   }
}
