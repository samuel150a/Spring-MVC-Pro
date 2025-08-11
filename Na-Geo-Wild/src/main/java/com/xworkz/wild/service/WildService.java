package com.xworkz.wild.service;

import com.xworkz.wild.dto.WildDto;
import com.xworkz.wild.entity.WildEntity;

import java.util.List;

public interface WildService {
    boolean saveDetails(WildDto wildDto);
    List<WildDto> fetchListOfEntities();

}
