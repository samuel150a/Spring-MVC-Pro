package com.xworkz.rapido.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="otpDetails")
public class OtpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private  Integer ID;

    private String email;
    private String otp;
}
