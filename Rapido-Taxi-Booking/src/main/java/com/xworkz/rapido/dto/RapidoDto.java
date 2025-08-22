package com.xworkz.rapido.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class RapidoDto {
    public RapidoDto()
    {
        System.out.println("Running in the RapidoDto");
    }

    private Integer ID;
    private String name;
    private String email;
    private Long phoneNumber;
    private String dob;
    private  String gender;
    private String state;
    private String address;
    private String password;
    private String confirmPassword;

}
