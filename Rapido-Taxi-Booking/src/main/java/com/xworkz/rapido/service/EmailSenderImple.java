package com.xworkz.rapido.service;

import com.xworkz.rapido.configuration.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImple implements EmailSender{
    public EmailSenderImple()
    {
        System.out.println("Running in the EmailSenderImple constructor ");
    }
    @Autowired
    EmailConfig emailConfig;
    @Override
    public boolean mailSend(String email, String otp) {
        try{
            System.out.println("Runnning in the Email Send Method");
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("Otp To User For Verification");
            simpleMailMessage.setText("Otp for verification " +otp);
            emailConfig.javaMailSender().send(simpleMailMessage);
            System.out.println("mail sent to :" + email + " - OTP : " + otp);
            return  true;


        }
        catch(Exception e) {
            System.out.println(e.getMessage());

            return false;
        }
    }
}
