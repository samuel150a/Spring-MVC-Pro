package com.xworkz.wild.service;

import com.xworkz.wild.dto.WildDto;
import com.xworkz.wild.entity.WildEntity;
import com.xworkz.wild.repository.WildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WildServiceImple implements WildService {
    @Autowired
    WildRepository wildRepository;
    @Override
    public boolean saveDetails(WildDto wildDto) {
        WildEntity wildEntity=new WildEntity();

        wildEntity.setDocumentaryName(wildDto.getDocumentaryName());
        wildEntity.setEpisode(wildDto.getEpisode());
        wildEntity.setPhotographer(wildDto.getPhotographer());
        wildEntity.setFilmingLocation(wildDto.getFilmingLocation());
        wildEntity.setCategory(wildDto.getCategory());

    return wildRepository.saveDetails(wildEntity);

    }
}
