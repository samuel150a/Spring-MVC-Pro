package com.xworkz.tourism.service;

import com.xworkz.tourism.dto.TourismDto;

import java.util.List;

public interface TourismService {
    boolean saveDetails(TourismDto touristDto);
    List<TourismDto> fetchAllEnties();
    TourismDto fetchById(Integer id);

}

