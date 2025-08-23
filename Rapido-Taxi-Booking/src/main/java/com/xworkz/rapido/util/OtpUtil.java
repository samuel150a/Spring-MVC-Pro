package com.xworkz.rapido.util;

import javax.validation.constraints.Digits;
import java.security.SecureRandom;

public class OtpUtil {
    private static final String DIGITS="0123456789";
    private static final SecureRandom random= new SecureRandom();
    public static String genereateOtp(int length)
    {
        StringBuilder otp=new StringBuilder();
        {
            for(int i=0;i<length;i++)
            {
                otp.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
            }
            return otp.toString();

        }
    }
}
