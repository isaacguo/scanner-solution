package com.mlreceipt.scanner.data.restcontrollers;

import com.mlreceipt.scanner.common.entities.GeneralSettingEntity;
import com.mlreceipt.scanner.data.repositories.GeneralSettingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/general-settings")
public class GeneralSettingRestController {

    GeneralSettingRepository generalSettingRepository;

    public GeneralSettingRestController(GeneralSettingRepository generalSettingRepository) {
        this.generalSettingRepository = generalSettingRepository;
    }

    @GetMapping
    public GeneralSettingEntity getGeneralSetting() {
        return this.generalSettingRepository.findAll().stream().findFirst().get();
    }


}
