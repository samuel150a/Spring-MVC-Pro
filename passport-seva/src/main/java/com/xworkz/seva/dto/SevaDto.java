package com.xworkz.seva.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SevaDto {

    private String passportOffice;
    private String givenName;
    private String surname;
    private Integer dateOfBirth;
    private String emailId;
    private Long phoneNo;
    private String asEmail;
    private String loginID;
    private String password;
    private String confirmPassword;
    private String hintQuestion;
    private String hintAnswer;
}
