package com.xworkz.seva.controller;

import com.xworkz.seva.dto.SevaDto;
import com.xworkz.seva.service.SevaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")

public class SevaController {
    @Autowired
    SevaService sevaService;
    public SevaController()
    {
        System.out.println("Running in the SevaController Constructor");
    }

    @GetMapping("Redirect")
    public String redirect()
    {
        System.out.println("Running in the redirect method");
        return "Seva";
    }
    @PostMapping("form")
    public String saveAll(SevaDto sevaDto, Model model)
    {
        System.out.println("Running in the saveAll method");
        sevaService.saveDetails(sevaDto);
//
//        read= sevaService.fetchAllData();
//        System.out.println(read);
       return "Seva";
    }

}
