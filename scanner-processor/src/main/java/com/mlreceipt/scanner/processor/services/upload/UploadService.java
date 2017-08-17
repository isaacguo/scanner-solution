package com.mlreceipt.scanner.processor.services.upload;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    void handleFileUpload(String uuid, MultipartFile file);
    String initiateUploading();
    String finishUploading(String uuid);
}

