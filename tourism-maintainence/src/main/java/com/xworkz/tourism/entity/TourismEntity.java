package com.xworkz.tourism.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="tmaint")
@NamedQuery(name="fetchAllEnties",query="SELECT i FROM TourismEntity i")
public class TourismEntity {
    public TourismEntity()
    {
        System.out.println("Running in the TourismEntity constructor ");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @Column(name="tourismName")
    private String tourismName;

    @Column(name="destination")
    private String  destination;
    @Column(name="days")

    private  Integer days;

    @Column(name="fee")
    private  Integer fee;

    @Column(name="personCount")
    private  Integer personCount;




}
