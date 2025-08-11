package com.xworkz.doctor.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DoctorIntializer  extends AbstractAnnotationConfigDispatcherServletInitializer {
    public DoctorIntializer()
    {
        System.out.println("Running in the DoctorIntializer constructor");
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DoctorConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
