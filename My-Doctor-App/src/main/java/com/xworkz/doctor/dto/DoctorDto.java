package com.xworkz.doctor.dto;

import lombok.Data;

@Data
public class DoctorDto {
    private String patientName;
    private String sickness;
    private Integer age;
    private Integer howLong;
    private boolean disabilities;

}
