package com.xworkz.doctor.controller;

import com.xworkz.doctor.dto.DoctorDto;
import com.xworkz.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")

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

            List<DoctorDto> fetched=doctorService.fetchAllEntites();
            System.out.println("The fetched datas are------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>");
            fetched.forEach(System.out::println);
            return "DoctorSuccess";
        }
        else {
            System.out.println("details not saved ");
            model.addAttribute("error","Not Saved!");
            return "Doctor";
        }
        }
        @GetMapping({"fetchAllData","Gback"})
    public String fetchAllData(Model model)
        {
            System.out.println("Running in the fetchAllData in getMapping");
            List<DoctorDto> fetched=doctorService.fetchAllEntites();
            System.out.println("The fetched datas are------------------------------------->>>>>>>>>>>>>>>>>>>>>>>>>");
            fetched.forEach(System.out::println);
            model.addAttribute("data",fetched);
            return "AllData";
        }

        @GetMapping("view/{ID}")
    public String viewById(@PathVariable Integer ID, Model model)
        {
            DoctorDto doctorDto=doctorService.fetchByID(ID);
            System.out.println("Running in the viewById method");
            model.addAttribute("viewMe",doctorDto);
            return "ViewById";
        }

    @GetMapping("/back")
    public String backButton()
    {
        System.out.println("Running in the backButton method");
        return "index";
    }

    @GetMapping("/dback")
    public String backButton2()
    {
        System.out.println("Running in the backButton2 method");
        return "index";
    }

    @GetMapping("/Eback")
    public String backButton3()
    {
        System.out.println("Running in the backButton3 method");
        return "Doctor";
    }



    }

