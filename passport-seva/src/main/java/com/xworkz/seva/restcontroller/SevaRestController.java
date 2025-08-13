package com.xworkz.seva.restcontroller;

import com.xworkz.seva.service.SevaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



    @RestController
    @RequestMapping("/")
    public class SevaRestController {
public SevaRestController()
{
    System.out.println("Running in the SevaRestController");
}
        @Autowired
        private SevaService sevaService;

        @GetMapping("checkemail")
        public String checkEmail(@RequestParam("email") String email) {
            System.out.println("Running in the RestController");

            System.out.println("emsi == === "+email);
            boolean exists = sevaService.isEmailAlreadyUsed(email);
            if(exists)
            {
                System.out.println("email is exists");
                return "email is exists";
            }
            else {
                System.out.println("email id not exists");
                   return "email id not exists";
            }
        }
    }

