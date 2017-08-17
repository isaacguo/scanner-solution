package com.mlreceipt.scanner.processor.restcontrollers;

import com.mlreceipt.scanner.processor.services.storage.StorageService;
import com.mlreceipt.scanner.processor.services.upload.UploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;

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


    @PostMapping("/")
    public void handleFileUpload(@RequestParam("file") MultipartFile file){
        this.uploadService.handleFileUpload(file);


    }


}
