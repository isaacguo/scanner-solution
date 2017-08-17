package com.mlreceipt.scanner.processor.services.upload;

import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import com.mlreceipt.scanner.processor.services.execution.ScanExecutionService;
import com.mlreceipt.scanner.processor.services.storage.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    public UploadServiceImpl(StorageService storageService, ScanExecutionService scanExecutionService) {
        this.storageService = storageService;
        this.scanExecutionService = scanExecutionService;
    }

    private StorageService storageService;
    private ScanExecutionService scanExecutionService;

    @Override
    public void handleFileUpload(String uuid, MultipartFile file) {

        String filename = storageService.store(uuid, file);
    }

    @Override
    public String initiateUploading() {

        String uuid = UUID.randomUUID().toString();
        if (this.storageService.createFolder(uuid))
            return "{\"scanid\":\"" + uuid + "\"}";
        else
            return "{\"scanid\":\"na\"}";
    }

    @Override
    public String finishUploading(String uuid) {
        //tell data service to create a task
        ScanTaskEntity scanTaskEntity=new ScanTaskEntity();

        //start to execute
        this.scanExecutionService.execute(uuid);
        return "{\"result\":\"success\"}";
    }
}
