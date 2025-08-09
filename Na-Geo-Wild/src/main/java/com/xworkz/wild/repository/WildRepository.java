package com.xworkz.wild.repository;

import com.xworkz.wild.dto.WildDto;
import com.xworkz.wild.entity.WildEntity;

public interface WildRepository {
    boolean saveDetails(WildEntity wildEntity);

}
