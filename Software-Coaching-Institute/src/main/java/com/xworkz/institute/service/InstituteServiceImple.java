package com.xworkz.institute.service;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.entity.InstituteEntity;
import com.xworkz.institute.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
