package com.mlreceipt.scanner.processor.restcontrollers;

import com.mlreceipt.scanner.processor.services.storage.StorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/upload")
public class UploadRestController {

    private final StorageService storageService;

    public UploadRestController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping()
    public String get() {
        return "Get";
    }


    @PostMapping("/")
    public void handleFileUpload(@RequestParam("file") MultipartFile file){

        storageService.store(file);

    }


}
