package com.mlreceipt.scanner.processor.services.upload;

import com.mlreceipt.scanner.common.entities.ScanPairEntity;
import com.mlreceipt.scanner.common.entities.ScanTaskEntity;
import com.mlreceipt.scanner.common.enums.ScanTaskStatusEnum;
import com.mlreceipt.scanner.processor.feignclients.DataFeignClient;
import com.mlreceipt.scanner.processor.services.execution.ScanExecutionService;
import com.mlreceipt.scanner.processor.services.storage.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    public UploadServiceImpl(DataFeignClient dataFeignClient, StorageService storageService, ScanExecutionService scanExecutionService) {
        this.dataFeignClient = dataFeignClient;
        this.storageService = storageService;
        this.scanExecutionService = scanExecutionService;
    }

    private DataFeignClient dataFeignClient;
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
        String fullPath=this.storageService.getFullUploadPath(uuid);

        File folder = new File(fullPath);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                ScanPairEntity spe=new ScanPairEntity();
                spe.setImagePath(listOfFiles[i].getAbsolutePath());
                spe.setImageName(listOfFiles[i].getName());
                scanTaskEntity.addScanPair(spe);
            }
        }

        scanTaskEntity.setStatus(ScanTaskStatusEnum.UPLOADED);
        scanTaskEntity.setUuid(uuid);
        dataFeignClient.insertScanTask(scanTaskEntity);

        //start to execute
        this.scanExecutionService.execute(uuid,scanTaskEntity);



        return "{\"result\":\"success\"}";
    }
}
