package com.mlreceipt.scanner.processor.restcontrollers;

import com.mlreceipt.scanner.processor.services.storage.StorageService;
import com.mlreceipt.scanner.processor.services.upload.UploadService;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadRestController {

    private final UploadService uploadService;

    public UploadRestController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @GetMapping()
    public String get() {
        return "Get";
    }

    @PostMapping("/initiateUploading")
    public String initiateUploading() {
        return this.uploadService.initiateUploading();
    }

    @PostMapping("/")
    public void handleFileUpload(@RequestParam("scanid") String scanId, @RequestParam("file") MultipartFile file) {
        this.uploadService.handleFileUpload(scanId, file);
    }

    @PostMapping("/finishUploading/{scanId}/")
    public String finishUploading(@PathVariable("scanId") String scanId)
    {
        return this.uploadService.finishUploading(scanId);
    }

}
