package com.xworkz.rapido.restcontroller;

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
        System.out.println("Running in the mailValidation");
        String exsisting = rapidoService.getByEmail(email);
        if (exsisting == null) {
            return "Email is not exsisting";
        } else {
            return "Email is exsisting";
        }
    }

        @GetMapping("checkPhNo")
                public String phNoValidation(@RequestParam("cdc") Long phNo)
        {
            System.out.println("Running in phNoValidation");
            Long exsisting= rapidoService.getByPhoneNumber(phNo);
            if(exsisting==null)
            {


                
            }

        }
    }

}
