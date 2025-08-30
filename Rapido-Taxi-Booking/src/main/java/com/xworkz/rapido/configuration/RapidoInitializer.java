package com.xworkz.rapido.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

public class RapidoInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public RapidoInitializer() {
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
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration)
    {
        File uploadDirectory=new File(System.getProperty("java.io.tmpdir"));
        int maxUploadSizeInMb=5*1024*1024;
        MultipartConfigElement multipartConfigElement=new MultipartConfigElement(uploadDirectory.getAbsolutePath()
                ,maxUploadSizeInMb,maxUploadSizeInMb*2
                ,maxUploadSizeInMb/2);

        registration.setMultipartConfig(multipartConfigElement);


    }

}
