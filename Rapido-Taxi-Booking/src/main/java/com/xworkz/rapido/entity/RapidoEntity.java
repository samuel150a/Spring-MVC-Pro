package com.xworkz.rapido.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="rapidoDetails3")
@NamedQueries({
        @NamedQuery(name="getByEmail", query="SELECT a.email FROM RapidoEntity a WHERE a.email=:email"),
        @NamedQuery(name="getByPhoneNumber", query="SELECT p.phoneNumber FROM RapidoEntity p WHERE p.phoneNumber=:phoneNumber")
})
@Data
public class RapidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer ID;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="phoneNumber")
    private Long phoneNumber;

    @Column(name="dob")
    private String dob;

    @Column(name="gender")
    private String gender;

    @Column(name="state")
    private String state;

    @Column(name="address")
    private String address;

    @Column(name="password")
    private String password;

    @Column(name="confirmPassword")
    private String confirmPassword;
}
