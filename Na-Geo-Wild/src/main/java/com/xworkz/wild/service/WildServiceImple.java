package com.xworkz.wild.service;

import com.xworkz.wild.dto.WildDto;
import com.xworkz.wild.entity.WildEntity;
import com.xworkz.wild.repository.WildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WildServiceImple implements WildService {
    WildEntity wildEntity=new WildEntity();


    @Autowired
    WildRepository wildRepository;
    @Override
    public boolean saveDetails(WildDto wildDto) {

        wildEntity.setDocumentaryName(wildDto.getDocumentaryName());
        wildEntity.setEpisode(wildDto.getEpisode());
        wildEntity.setPhotographer(wildDto.getPhotographer());
        wildEntity.setFilmingLocation(wildDto.getFilmingLocation());
        wildEntity.setCategory(wildDto.getCategory());

    return wildRepository.saveDetails(wildEntity);

    }

    @Override
    public List<WildDto> fetchListOfEntities( ) {
        System.out.println("Running in the fetchListOfEntities");
        List<WildDto> listWildDto=null;

        List<WildEntity> listWildtEntites= wildRepository.fetchListOfEntities();
        listWildDto =listWildtEntites.stream().map(e->{
            WildDto wildDto=new WildDto();

            wildDto.setId(e.getID());

            wildDto.setDocumentaryName(e.getDocumentaryName());
            wildDto.setEpisode(e.getEpisode());
            wildDto.setFilmingLocation(e.getFilmingLocation());
            wildDto.setCategory(e.getCategory());
            wildDto.setPhotographer(e.getPhotographer());
            return  wildDto;
        }).collect(Collectors.toList());
        System.out.println("here the conversion details");
        listWildtEntites.forEach(e-> System.out.println(e));

        return listWildDto;



    }

    @Override
    public WildDto fetchById(Integer id) {
        WildEntity wildEntity1= wildRepository.fetchById(id);
        WildDto wildDto =new WildDto();

        wildDto.setId(wildEntity1.getID());

        wildDto.setDocumentaryName(wildEntity1.getDocumentaryName());
        wildDto.setEpisode(wildEntity1.getEpisode());
        wildDto.setPhotographer(wildEntity1.getPhotographer());
        wildDto.setFilmingLocation(wildEntity1.getFilmingLocation());
        wildDto.setCategory(wildEntity1.getCategory());
        return wildDto;

    }
}
