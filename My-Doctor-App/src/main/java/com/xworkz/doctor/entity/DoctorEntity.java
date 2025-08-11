package com.xworkz.doctor.entity;

import lombok.Data;

import javax.persistence.*;



    @Entity
    @Data
    @Table(name="doc_details")
    public class DoctorEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="ID")
        private Integer ID;

        @Column(name="patientName")
        private String patientName;

        @Column(name="sickness")
        private String sickness;

        @Column(name="age")
        private Integer age;

        @Column(name="howLong")
        private Integer howLong;

        @Column(name="disabilities")
        private boolean disabilities;
    }


