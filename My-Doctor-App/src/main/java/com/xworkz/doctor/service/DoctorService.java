package com.xworkz.doctor.service;

import com.xworkz.doctor.dto.DoctorDto;
import com.xworkz.doctor.entity.DoctorEntity;

import java.util.List;

public interface DoctorService {
    boolean save(DoctorDto doctorDto);
    List<DoctorDto> fetchAllEntites();
    DoctorDto fetchByID(Integer id);

}
