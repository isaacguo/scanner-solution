package com.mlreceipt.scanner.processor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class BeanConfiguration {
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver cmr=new CommonsMultipartResolver();
        cmr.setDefaultEncoding("utf-8");
        cmr.setResolveLazily(true);
        return cmr;
    }
}
