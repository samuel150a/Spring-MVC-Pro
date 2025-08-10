package com.xworkz.institute.repository;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.entity.InstituteEntity;

public interface InstituteRepository {
    boolean saveDetails(InstituteEntity instituteEntity);
}
