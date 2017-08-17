package com.mlreceipt.scanner.processor.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("scanner")
public class ScanExecutorProperties {

    @Value("#{environment['scannerPath']}")
    private String scannerPath = "";

    @Value("#{environment['scannerOutputPath']}")
    private String scannerOutputPath = "";

    public String getScannerPath() {
        return scannerPath;
    }

    public void setScannerPath(String scannerPath) {
        this.scannerPath = scannerPath;
    }

    public String getScannerOutputPath() {
        return scannerOutputPath;
    }

    public void setScannerOutputPath(String scannerOutputPath) {
        this.scannerOutputPath = scannerOutputPath;
    }
}
