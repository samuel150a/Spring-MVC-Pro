package com.xworkz.doctor.service;

import com.xworkz.doctor.dto.DoctorDto;
import com.xworkz.doctor.entity.DoctorEntity;
import com.xworkz.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public boolean save(DoctorDto doctorDto) {
        DoctorEntity doctorEntity=new DoctorEntity();
doctorEntity.setPatientName(doctorDto.getPatientName());
doctorEntity.setSickness(doctorDto.getSickness());
doctorEntity.setAge(doctorDto.getAge());
doctorEntity.setHowLong(doctorDto.getHowLong());
doctorEntity.setDisabilities(doctorDto.isDisabilities());

        return doctorRepository.save(doctorEntity);
    }
}
