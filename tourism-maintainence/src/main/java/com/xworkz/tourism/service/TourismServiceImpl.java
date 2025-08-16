package com.xworkz.tourism.service;

import com.xworkz.tourism.dto.TourismDto;
import com.xworkz.tourism.entity.TourismEntity;
import com.xworkz.tourism.repository.TourismRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourismServiceImpl implements TourismService{


    @Autowired
    TourismRepo tourismRepo;

    @Override
    public boolean saveDetails(TourismDto touristDto) {
        System.out.println("Running in the saveDetails method in service imple");

        TourismEntity tourismEntity=new TourismEntity();

        tourismEntity.setTourismName(touristDto.getTouristName());
        tourismEntity.setDestination(touristDto.getDestination());
        tourismEntity.setDays(touristDto.getDays());
        tourismEntity.setFee(touristDto.getFee());
        tourismEntity.setPersonCount(touristDto.getPersonCount());


        return tourismRepo.saveDetails(tourismEntity);
    }
//    @Override
//    public List<WildDto> fetchListOfEntities( ) {
//        System.out.println("Running in the fetchListOfEntities");
//        List<WildDto> listWildDto=null;
//
//        List<WildEntity> listWildtEntites= wildRepository.fetchListOfEntities();
//        listWildDto =listWildtEntites.stream().map(e->{
//            WildDto wildDto=new WildDto();
//
//            wildDto.setId(e.getID());
//
//            wildDto.setDocumentaryName(e.getDocumentaryName());
//            wildDto.setEpisode(e.getEpisode());
//            wildDto.setFilmingLocation(e.getFilmingLocation());
//            wildDto.setCategory(e.getCategory());
//            wildDto.setPhotographer(e.getPhotographer());
//            return  wildDto;
//        }).collect(Collectors.toList());
//        System.out.println("here the conversion details");
//        listWildtEntites.forEach(e-> System.out.println(e));
//
//        return listWildDto;
//
//
//
//    }
    @Override
    public List<TourismDto> fetchAllEnties() {

        System.out.println("Running in the fetchAllEnties");
        List<TourismDto> tourismDto=null;
        List<TourismEntity> tourismEntitiy1=tourismRepo.fetchAllEnties();
        tourismDto=tourismEntitiy1.stream().map(e->
        {
            TourismDto tourismDto1=new TourismDto();
            tourismDto1.setID(e.getID());
            tourismDto1.setTouristName(e.getTourismName());
            tourismDto1.setDestination(e.getDestination());
            tourismDto1.setDays(e.getDays());
            tourismDto1.setFee(e.getFee());
            tourismDto1.setPersonCount(e.getPersonCount());
            return tourismDto1;
        }).collect(Collectors.toList());
        return tourismDto;


    }

    @Override
    public TourismDto fetchById(Integer id) {
        System.out.println("Running in the fetchById method ");
        TourismDto tourismDto=new TourismDto();
        TourismEntity tourismEntity=tourismRepo.fetchById(id);

        tourismDto.setID(tourismEntity.getID());
        tourismDto.setTouristName(tourismEntity.getTourismName());
        tourismDto.setDestination(tourismEntity.getDestination());
        tourismDto.setDays(tourismEntity.getDays());
        tourismDto.setFee(tourismEntity.getFee());
        tourismDto.setPersonCount(tourismEntity.getPersonCount());
        return tourismDto;
    }


}
