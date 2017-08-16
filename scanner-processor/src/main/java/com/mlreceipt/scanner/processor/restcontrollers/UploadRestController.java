package com.mlreceipt.scanner.processor.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class UploadRestController {

    @GetMapping()
    public String get()
    {
        return "Get";
    }

}
