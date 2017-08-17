package com.mlreceipt.scanner.processor.services.upload;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    void handleFileUpload(MultipartFile file);
}
