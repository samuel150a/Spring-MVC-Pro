package com.xworkz.wild.controller;

import com.xworkz.wild.dto.WildDto;
import com.xworkz.wild.service.WildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WildController {
    @Autowired
    WildService wildService;

    public WildController() {
        System.out.println("Running in the WildController Constructor ");
    }

    @GetMapping("/click")
    public String RedirectPage() {
        System.out.println("Running in RedirectPage method ");
        return "Wild";
    }

    @PostMapping("/details")
    public String fillDetails(WildDto wildDto, Model model) {
        System.out.println("Running in the fillDetails method ");
        System.out.println(wildDto);


        boolean check = wildService.saveDetails(wildDto);
        if (check) {
            model.addAttribute("message", "Done");

            return "WildSuccesfull";
        }
else {
            model.addAttribute("error", "Failed");

            System.out.println("Not Saved for DataBase");
            return "Wild";
        }
    }
}