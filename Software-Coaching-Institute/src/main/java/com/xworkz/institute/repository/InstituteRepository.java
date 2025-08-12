package com.xworkz.institute.repository;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.entity.InstituteEntity;

import java.util.List;

public interface InstituteRepository {
    boolean saveDetails(InstituteEntity instituteEntity);
    List<InstituteEntity> fethAllData();
    InstituteEntity fetchById(Integer id);
}
