package com.xworkz.rapido.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RapidoInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public RapidoInitializer(){
        System.out.println("Running in the RapidoInitializer constructor");
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{RapidoConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
