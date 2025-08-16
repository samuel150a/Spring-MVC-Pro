package com.xworkz.tourism.dto;

import lombok.Data;

@Data
public class TourismDto {
    public TourismDto()
    {
        System.out.println("Running in the TourismDto Constructor ");
    }
    private int ID;
    private String touristName;
    private String  destination;
    private  Integer days;
    private  Integer fee;
    private  Integer personCount;



}
