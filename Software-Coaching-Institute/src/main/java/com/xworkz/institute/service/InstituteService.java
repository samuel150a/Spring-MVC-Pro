package com.xworkz.institute.service;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.entity.InstituteEntity;
import com.xworkz.institute.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public interface InstituteService {

    boolean saveDetails(InstituteDto institueDto);
    List<InstituteDto> fethAllData();

}
