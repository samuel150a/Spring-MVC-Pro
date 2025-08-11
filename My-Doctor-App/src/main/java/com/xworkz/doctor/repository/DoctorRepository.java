package com.xworkz.doctor.repository;

import com.xworkz.doctor.dto.DoctorDto;
import com.xworkz.doctor.entity.DoctorEntity;

public interface DoctorRepository {
    boolean save(DoctorEntity doctorEntity);
}
