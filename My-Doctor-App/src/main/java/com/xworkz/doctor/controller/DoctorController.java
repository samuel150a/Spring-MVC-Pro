package com.xworkz.doctor.controller;

import com.xworkz.doctor.dto.DoctorDto;
import com.xworkz.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    public DoctorController()
    {
        System.out.println("Running in the DoctorController constructor ");
    }

    @GetMapping("/check")
    public String redirect()
    {
        System.out.println("Running in the redirect method");
        return "Doctor";
    }

    @PostMapping("/docs")
    public String details(DoctorDto doctorDto, Model model)
    {
        System.out.println("Running in the details method ");
        boolean gheck=doctorService.save(doctorDto);
        if(gheck)
        {
            System.out.println("details saved successfully");
            model.addAttribute("mess","Save done!");
            return "DoctorSuccess";
        }
        else {
            System.out.println("details not saved ");
            model.addAttribute("error","Not Saved!");
            return "Doctor";
        }
        }
    }

