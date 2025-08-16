package com.xworkz.doctor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.doctor")
public class DoctorConfig  {
    public DoctorConfig()
    {
        System.out.println("Running in DoctorConfig constructor");
    }
@Bean
    public InternalResourceViewResolver resolver()
    {
        System.out.println("Running in the resolver ");
        InternalResourceViewResolver viewResolver =new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }



}
