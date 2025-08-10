package com.xworkz.institute.service;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;


public interface InstituteService {

    boolean saveDetails(InstituteDto institueDto);


}
