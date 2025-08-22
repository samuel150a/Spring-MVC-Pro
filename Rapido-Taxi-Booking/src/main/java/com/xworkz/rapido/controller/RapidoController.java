package com.xworkz.rapido.controller;

import com.xworkz.rapido.dto.RapidoDto;
import com.xworkz.rapido.service.RapidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RapidoController {
    @Autowired RapidoService rapidoService;

    public RapidoController() {
        System.out.println("Running in the RapidoController controller ");
    }

    @GetMapping("login")
    public String login() {
        System.out.println("Running in the login Method in GetMapping");
        return "Login";
    }

    @GetMapping("regi")
    public String Register() {
        System.out.println("Running in the Register Method in GetMapping");
        return "Register";
    }

    @PostMapping("register")
    public String handleRegister(RapidoDto rapidoDto, Model model) {
        System.out.println("Running  in the handleRegister method ");
        System.out.println("Processing Register Post Request: " + rapidoDto);
       // model.addAttribute("rapidoDto", rapidoDto);
        Boolean rapidoDto1=rapidoService.save(rapidoDto);
        if(rapidoDto1)
        {
            System.out.println("SavedSuccessfully");
            model.addAttribute("message","***************SavedSuccessfully***************");
            return "RegisterSuccess";
        }
        else {
            System.out.println("Failed To save");

            return "Register";
        }
    }
    @PostMapping("log")
    public String handleLogin(RapidoDto rapidoDto, Model model)
    {
        System.out.println("Running in the handleLogin method ");
        model.addAttribute("message","LoginSuccessfull");

        return "LoginSuccessfull";
    }
}