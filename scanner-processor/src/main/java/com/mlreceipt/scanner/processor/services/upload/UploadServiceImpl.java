package com.mlreceipt.scanner.processor.services.upload;

import com.mlreceipt.scanner.processor.services.execution.ScanExecutionService;
import com.mlreceipt.scanner.processor.services.storage.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {

    public UploadServiceImpl(StorageService storageService, ScanExecutionService scanExecutionService) {
        this.storageService = storageService;
        this.scanExecutionService = scanExecutionService;
    }

    private StorageService storageService;
    private ScanExecutionService scanExecutionService;

    @Override
    public void handleFileUpload(MultipartFile file) {
        String filename = storageService.store(file);
        this.scanExecutionService.execute(filename);
    }
}
