package com.xworkz.seva.service;

import com.xworkz.seva.dto.SevaDto;
import com.xworkz.seva.entity.SevaEntity;
import com.xworkz.seva.repository.SevaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SevaServiceImple implements SevaService{
    @Autowired
    SevaRepository sevaRepository;
    @Override
    public boolean saveDetails(SevaDto sevaDto) {
        SevaEntity sevaEntity=new SevaEntity();
        BeanUtils.copyProperties(sevaDto,sevaEntity);
        return sevaRepository.saveDetails(sevaEntity);
    }

    @Override
    public boolean isEmailAlreadyUsed(String email) {
        return sevaRepository.isEmailAlreadyUsed(email);
    }

//    @Override
//    public List<SevaDto> fetchAllData() {
//        List<SevaEntity> entities = sevaRepository.fetchAllData();
//        List<SevaDto> dtoList = new ArrayList<>();
//
//        for (SevaEntity entity : entities) {
//            SevaDto dto = new SevaDto();
//            BeanUtils.copyProperties(entity, dto);
//            dtoList.add(dto);
//        }
//
//        return dtoList;
//    }

}
