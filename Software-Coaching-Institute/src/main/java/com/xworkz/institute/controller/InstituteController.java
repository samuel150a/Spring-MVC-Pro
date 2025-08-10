package com.xworkz.institute.controller;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;
import java.sql.SQLOutput;

@Controller
public class InstituteController {
    @Autowired
    InstituteService instituteService;
    public InstituteController()
    {
        System.out.println("Running in the InstituteController constructor");
    }

    @GetMapping("/Check")
    public String getInstitutePage()
    {
        System.out.println("Running in the getInstitutePage Method");
        return "Institute";
    }

    @PostMapping("/insti")
    public String  details(InstituteDto instituteDto, Model model)
    {
        System.out.println("Running in the details ");
        System.out.println(instituteDto);
         Boolean check=instituteService.saveDetails(instituteDto);
         if(check)
         {
             model.addAttribute("mess","Save done");
             System.out.println("Saved Successfully");
             return "InstituteSuccess";
         }
         else {
             model.addAttribute("error"," Not saved");
             System.out.println("Not saved");
             return "Institute";

         }


    }
}
