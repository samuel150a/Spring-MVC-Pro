package com.xworkz.tourism.repository;

import com.xworkz.tourism.dto.TourismDto;
import com.xworkz.tourism.entity.TourismEntity;

import java.util.List;

public interface TourismRepo {
    boolean saveDetails(TourismEntity tourismEntity);
    List<TourismEntity> fetchAllEnties();
    TourismEntity fetchById(Integer id);

}
