package com.zerobase.bootlmsdemo.configration;

import com.zerobase.bootlmsdemo.BootLmsDemoApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BootLmsDemoApplication.class);
    }

}
