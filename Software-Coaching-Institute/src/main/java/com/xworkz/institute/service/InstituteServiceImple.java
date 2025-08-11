package com.xworkz.institute.service;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.entity.InstituteEntity;
import com.xworkz.institute.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class InstituteServiceImple implements InstituteService {
    @Autowired
    InstituteRepository instituteRepository;
    @Override
    public boolean saveDetails(InstituteDto instituteDto) {
        System.out.println("Running in saveDetails in InstituteServiceImple class ");
        InstituteEntity instituteEntity=new InstituteEntity();

        instituteEntity.setCandidateName(instituteDto.getCandidateName());
        instituteEntity.setDegree(instituteDto.getDegree());
        instituteEntity.setYearOfPassout(instituteDto.getYearOfPassout());
        instituteEntity.setCourse(instituteDto.getCourse());
        instituteEntity.setDuration(instituteDto.getDuration());
        return instituteRepository.saveDetails(instituteEntity);


    }

    @Override
    public List<InstituteDto> fethAllData() {
        System.out.println("Running in the fethAllData method");


        List<InstituteEntity> data =instituteRepository.fethAllData();
        List<InstituteDto>  instituteDtos=data.stream().map(e->{
            InstituteDto instituteDto=new InstituteDto();

            instituteDto.setCandidateName(e.getCandidateName());
            instituteDto.setDegree(e.getDegree());
            instituteDto.setCourse(e.getCourse());
            instituteDto.setDuration(e.getDuration());
            instituteDto.setYearOfPassout(e.getYearOfPassout());
            instituteDto.setId(e.getID());
            return instituteDto;
        }).collect(Collectors.toList());
return  instituteDtos;
    }

}
