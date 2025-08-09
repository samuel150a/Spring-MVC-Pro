package com.xworkz.wild.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.wild")
public class WildConfig {
    public WildConfig()
    {
        System.out.println("Running in the WildConfig Constructor");
    }
     @Bean
    public InternalResourceViewResolver viewResolver()
     {
         System.out.println("Running in the viewResolver method");
         InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
         internalResourceViewResolver.setPrefix("/");
         internalResourceViewResolver.setSuffix(".jsp");
         return internalResourceViewResolver;
     }


}
