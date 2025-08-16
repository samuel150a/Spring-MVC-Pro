package com.xworkz.doctor.service;

import com.xworkz.doctor.dto.DoctorDto;
import com.xworkz.doctor.entity.DoctorEntity;
import com.xworkz.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<DoctorDto> fetchAllEntites() {
        System.out.println("Running  in the fethAllEntites method ");
        List<DoctorDto> doctorDto1=null;
        List<DoctorEntity> doctorEntity =doctorRepository.fetchAllEntites();
        doctorDto1= doctorEntity.stream().map(e->{
            DoctorDto doctorDto=new DoctorDto();
            doctorDto.setID(e.getID());
            doctorDto.setPatientName(e.getPatientName());
            doctorDto.setAge(e.getAge());
            doctorDto.setHowLong(e.getHowLong());
            doctorDto.setSickness(e.getSickness());
            doctorDto.setDisabilities(e.isDisabilities());
            return doctorDto;
        }).collect(Collectors.toList());
        return doctorDto1;
    }

    @Override
    public DoctorDto fetchByID(Integer id) {
        DoctorEntity doctorEntity=doctorRepository.fetchByID(id);
        DoctorDto doctorDto=new DoctorDto();

        doctorDto.setID(doctorEntity.getID());
        doctorDto.setPatientName(doctorEntity.getPatientName());
        doctorDto.setSickness(doctorEntity.getSickness());
        doctorDto.setAge(doctorEntity.getAge());
        doctorDto.setHowLong(doctorEntity.getHowLong());
        doctorDto.setDisabilities(doctorEntity.isDisabilities());
        
        return doctorDto;
    }


}
