package com.xworkz.seva.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="seva_details")
@NamedQuery(name="fetchAllData",query="SELECT i from SevaEntity i")
/*@NamedQuery(
        name = "checkEmail",
        query = "SELECT e FROM SevaEntity e WHERE e.emailId =:emailId")*/

@NamedQuery(name="checkEmail",query ="select d from SevaEntity d where d.emailId=:emailId")

public class SevaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer ID;

    @Column(name = "PASSPORT_OFFICE")
    private String passportOffice;

    @Column(name = "GIVEN_NAME")
    private String givenName;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "DATE_OF_BIRTH")
    private Integer dateOfBirth;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "PHONE_NO")
    private Long phoneNo;

    @Column(name = "AS_EMAIL")
    private String asEmail;

    @Column(name = "LOGIN_ID")
    private String loginID;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CONFIRM_PASSWORD")
    private String confirmPassword;

    @Column(name = "HINT_QUESTION")
    private String hintQuestion;

    @Column(name = "HINT_ANSWER")
    private String hintAnswer;


}
