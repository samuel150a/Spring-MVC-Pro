package com.xworkz.rapido.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {
    public EmailConfig()
    {
        System.out.println("Running in the EmailConfig constructor");
    }
    public JavaMailSenderImpl javaMailSender()
    {
        JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
//        javaMailSender.setUsername();
//        javaMailSender.setPassword();

        javaMailSender.setUsername("samuelofficial184@gmail.com");
        javaMailSender.setPassword("gaxl neys esxn xnot");

        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.tranport.protocol","smtp");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        return javaMailSender;

    }
}
