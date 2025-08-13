package com.xworkz.seva.service;

import com.xworkz.seva.dto.SevaDto;
import com.xworkz.seva.entity.SevaEntity;

import java.util.List;

public interface SevaService {
    boolean saveDetails(SevaDto sevaDto);
//    List<SevaDto> fetchAllData( );
boolean isEmailAlreadyUsed(String email);

}
