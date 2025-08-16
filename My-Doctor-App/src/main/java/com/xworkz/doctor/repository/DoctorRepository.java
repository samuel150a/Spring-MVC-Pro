package com.xworkz.doctor.repository;

import com.xworkz.doctor.dto.DoctorDto;
import com.xworkz.doctor.entity.DoctorEntity;

import java.util.List;

public interface DoctorRepository {
    boolean save(DoctorEntity doctorEntity);
    List<DoctorEntity> fetchAllEntites();
    DoctorEntity fetchByID(Integer id);
}
