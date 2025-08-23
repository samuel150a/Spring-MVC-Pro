package com.xworkz.rapido.restcontroller;

import com.xworkz.rapido.dto.RapidoDto;
import com.xworkz.rapido.service.RapidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RapidoRestController {
    @Autowired
    RapidoService rapidoService;

    public RapidoRestController() {
        System.out.println("Running in the RapidoRestController");
    }

    @GetMapping("checkEmail")
    public String mailValidation(@RequestParam("email") String email) {
        System.out.println("Running in the mailValidation in restController");
        RapidoDto exsisting = rapidoService.getByEmail(email);
        if (exsisting == null) {
            return "Email is not existing";
        } else {
            return "Email is existing";
        }
    }

        @GetMapping("checkPhNo")
                public String phNoValidation(@RequestParam("phoneNumber") Long phNo)
        {
            System.out.println("Running in phNoValidation in restController");
            Long exsisting= rapidoService.getByPhoneNumber(phNo);
            if(exsisting==null)
            {
                return "Phone No is not Existing";
            }
            else {
                return"Phone Number Existing";
            }
    }

}
