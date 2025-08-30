package com.xworkz.ecommerce.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@ToString
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findByEmail", query = "SELECT u FROM UserEntity u WHERE u.email = :email"),
        @NamedQuery(
                name = "validateEmail",
                query = "SELECT u.email FROM UserEntity u WHERE u.email = :email"),
        @NamedQuery(
                name = "validatePhoneNumber",
                query = "SELECT u.phoneNumber FROM UserEntity u WHERE u.phoneNumber = :phoneNumber")
})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private LocalDate dob;

    private String gender;

    private String state;

    private String address;

    private String password;

    // private String confirmPassword;
}
