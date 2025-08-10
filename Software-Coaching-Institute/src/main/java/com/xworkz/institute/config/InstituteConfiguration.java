package com.xworkz.institute.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.institute")
public class InstituteConfiguration  {
    public InstituteConfiguration()
    {
        System.out.println("running in the InstituteConfiguration constructor");
    }

    @Bean
    public InternalResourceViewResolver resolver()
    {
        System.out.println("Running in the InternalResourceViewResolver method");
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


}
