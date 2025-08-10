package com.xworkz.institute.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="institute_details")
public class InstituteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer ID;

    @Column(name="candidateName")
    private String candidateName;

    @Column(name="degree")
    private String degree;

    @Column(name="yearOfPassout")
    private String yearOfPassout;

    @Column(name="course")
    private String course;

    @Column(name="duration")
    private Integer duration;
}
