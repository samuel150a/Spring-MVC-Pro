package com.xworkz.rapido.service;

import com.xworkz.rapido.dto.RapidoDto;
import com.xworkz.rapido.entity.RapidoEntity;

public interface RapidoService {
    Boolean save(RapidoDto rapidoDto);
    RapidoDto getByEmail(String email);
    Long getByPhoneNumber(Long num);
    Boolean verifyOtp(String email,String otp);
    RapidoDto findByEmail(String email);
}
