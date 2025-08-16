package com.xworkz.doctor.dto;

import lombok.Data;

@Data
public class DoctorDto {

    private Integer ID;
    private String patientName;
    private String sickness;
    private Integer age;
    private Integer howLong;
    private boolean disabilities;

}
