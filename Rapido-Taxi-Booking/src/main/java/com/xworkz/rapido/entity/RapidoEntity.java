package com.xworkz.rapido.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name="rapidoDetails")
//@NamedQuery(name = "getByEmail",query = "select a.email from UserEntity a where a.email = :email and a.isPresent=true")
@NamedQuery(name="getByEmail",query="SELECT a.email from RapidoEntity a WHERE a.email=:email")
@NamedQuery(name="getByPhoneNumber",query="SELECT P.phoneNumber from RapidoEntity p WHERE P.phoneNumber=:phoneNumber")
public class RapidoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private  int ID;

//    private int ID;
//    private String name;
//    private String email;
//    private String phoneNumber;
//    private LocalDate dob;
//    private  String gender;
//    private String state;
//    private String address;
//    private String password;
//    private String confirmPassword;


    @Column(name="name")
    private  String name;

    @Column(name="email")
    private  String email;


    @Column(name="phoneNumber")
    private  int phoneNumber;

    @Column(name="dob")
    private  LocalDate dob;

    @Column(name="gender")
    private  String gender;

    @Column(name="state")
    private  String state;

    @Column(name="address")
    private  String address;

    @Column(name="password")
    private  String password;

    @Column(name="confirmPassword")
    private  String confirmPassword;

}
