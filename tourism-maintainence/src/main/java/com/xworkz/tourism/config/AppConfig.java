package com.xworkz.tourism.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.tourism")

public class AppConfig {

    public AppConfig()
    {
        System.out.println("Running in the AppConfig constructor ");
    }


    @Bean
    public InternalResourceViewResolver viewResolver() {
        System.out.println("running in the viewResolver method");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
