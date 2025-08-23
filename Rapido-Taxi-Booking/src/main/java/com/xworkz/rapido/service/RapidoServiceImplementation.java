package com.xworkz.rapido.service;

import com.xworkz.rapido.dto.RapidoDto;
import com.xworkz.rapido.entity.RapidoEntity;
import com.xworkz.rapido.repository.RapidoRepository;
import com.xworkz.rapido.util.OtpUtil;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Data
@Service
public class RapidoServiceImplementation implements RapidoService{
    @Autowired
    RapidoRepository rapidoRepository;
    @Autowired
    EmailSender emailSender;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public RapidoServiceImplementation()
    {
        System.out.println("Running in the RapidoServiceImplementation Constructor ");

    }
    @Override
    public Boolean save(RapidoDto rapidoDto) {
        RapidoEntity rapidoEntity=new RapidoEntity();
        BeanUtils.copyProperties(rapidoDto,rapidoEntity);

        String otp= OtpUtil.genereateOtp(6);
        rapidoEntity.setOtp(otp);
        rapidoEntity.setOtpExpiry(LocalDateTime.now().plusMinutes(5));
        rapidoEntity.setPassword(encoder.encode(rapidoEntity.getPassword()));

        rapidoEntity.setLoginCount(-1);
        emailSender.mailSend(rapidoDto.getEmail(),otp);

        return rapidoRepository.save(rapidoEntity);
    }

    @Override
    public RapidoDto getByEmail(String email) {
        System.out.println("Running in the getByEmail in service method");
        RapidoEntity rapidoEntity = rapidoRepository.getByEmail(email);
        if (rapidoEntity == null) {
            return null;
        }

        RapidoDto rapidoDto = new RapidoDto();
        BeanUtils.copyProperties(rapidoEntity,rapidoDto);
        return  rapidoDto;
    }

    @Override
    public Long getByPhoneNumber(Long num) {
        System.out.println("Running in the getByPhoneNumber");
        return rapidoRepository.getByPhoneNumber(num);
    }

    @Override
    public Boolean verifyOtp(String email, String otp) {
        RapidoEntity entity=rapidoRepository.getByEmail(email);
        if(entity==null)
        {
            return false;
        }
        if(entity.getOtp().equals(otp) && entity.getOtpExpiry().isAfter(LocalDateTime.now()))
        {
return true;
        }
        return false;
    }


}
