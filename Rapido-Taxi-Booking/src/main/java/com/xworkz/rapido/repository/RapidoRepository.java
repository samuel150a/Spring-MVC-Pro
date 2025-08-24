package com.xworkz.rapido.repository;

import com.xworkz.rapido.entity.RapidoEntity;

public interface RapidoRepository {
    Boolean save(RapidoEntity rapidoEntity);
    RapidoEntity  getByEmail(String email);
    Long getByPhoneNumber(Long num);
    RapidoEntity  myEmail(String email);
    RapidoEntity findByEmail(String email);
}
