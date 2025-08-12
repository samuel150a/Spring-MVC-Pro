package com.xworkz.wild.repository;

import com.xworkz.wild.dto.WildDto;
import com.xworkz.wild.entity.WildEntity;

import java.util.List;

public interface WildRepository {
    boolean saveDetails(WildEntity wildEntity);
    List<WildEntity> fetchListOfEntities( );
    WildEntity fetchById(Integer id);

}
