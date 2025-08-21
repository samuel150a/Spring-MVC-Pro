package com.xworkz.rapido.service;

import com.xworkz.rapido.dto.RapidoDto;
import com.xworkz.rapido.entity.RapidoEntity;
import com.xworkz.rapido.repository.RapidoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RapidoServiceImplementation implements RapidoService{
    @Autowired
    RapidoRepository rapidoRepository;
    public RapidoServiceImplementation()
    {
        System.out.println("Running in the RapidoServiceImplementation Constructor ");

    }
    @Override
    public Boolean save(RapidoDto rapidoDto) {
        RapidoEntity rapidoEntity=new RapidoEntity();
        BeanUtils.copyProperties(rapidoDto,rapidoEntity);
        return rapidoRepository.save(rapidoEntity);
    }

    @Override
    public String getByEmail(String email) {
        System.out.println("Running in the getByEmail in service method");
        return rapidoRepository.getByEmail(email);
    }

    @Override
    public Long getByPhoneNumber(Long num) {
        System.out.println("Running in the getByPhoneNumber");
        return rapidoRepository.getByPhoneNumber(num);
    }


}
