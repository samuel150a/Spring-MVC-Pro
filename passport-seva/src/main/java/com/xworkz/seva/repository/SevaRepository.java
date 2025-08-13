package com.xworkz.seva.repository;

import com.xworkz.seva.entity.SevaEntity;

import java.util.List;

public interface SevaRepository {
    boolean saveDetails(SevaEntity sevaEntity);
//    List<SevaEntity> fetchAllData( );
boolean isEmailAlreadyUsed(String email);

}
