package com.mlreceipt.scanner.scannerdata.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yueguo01 on 7/18/2017.
 */
@RestController
public class TestRestControllers {

    @GetMapping
    public String get()
    {
        return "a";
    }

}
