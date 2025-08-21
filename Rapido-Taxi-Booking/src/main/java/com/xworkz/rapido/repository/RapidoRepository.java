package com.xworkz.rapido.repository;

import com.xworkz.rapido.entity.RapidoEntity;

public interface RapidoRepository {
    Boolean save(RapidoEntity rapidoEntity);
    String getByEmail(String email);
    Long getByPhoneNumber(Long num);

}
