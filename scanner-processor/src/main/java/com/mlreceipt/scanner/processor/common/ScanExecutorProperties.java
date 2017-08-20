package com.mlreceipt.scanner.processor.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("scanner")
public class ScanExecutorProperties {

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    @Value("#{environment['uploadPath']}")
    private String uploadPath = ".";

    @Value("#{environment['scannerPath']}")
    private String scannerPath = "";

    @Value("#{environment['scannerOutputPath']}")
    private String scannerOutputPath = "";

    @Value("#{environment['scannerInputPath']}")
    private String scannerInputPath="";

    public String getScannerPath() {
        return scannerPath;
    }

    public void setScannerPath(String scannerPath) {
        this.scannerPath = scannerPath;
    }

    public String getScannerInputPath() {
        return scannerInputPath;
    }

    public void setScannerInputPath(String scannerInputPath) {
        this.scannerInputPath = scannerInputPath;
    }

    public String getScannerOutputPath() {
        return scannerOutputPath;
    }

    public void setScannerOutputPath(String scannerOutputPath) {
        this.scannerOutputPath = scannerOutputPath;
    }
}
