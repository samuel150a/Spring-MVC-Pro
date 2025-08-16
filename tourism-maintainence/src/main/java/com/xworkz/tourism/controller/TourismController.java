package com.xworkz.tourism.controller;


import com.xworkz.tourism.dto.TourismDto;
import com.xworkz.tourism.service.TourismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class TourismController {
    public TourismController()
    {
        System.out.println("Running in the TourismController constructor ");
    }
    @Autowired
    TourismService tourismService;

    @GetMapping("tourism")
    public String redirectToTourism() {
        System.out.println("Running in the redirectToTourism Getmethod ");
        return "Tourism";


    }

    @PostMapping("register")
    public String fillDetails(TourismDto touristDto, Model model) {
        System.out.println("Running in the fillDetails PostMethod ");
        System.out.println("details" + touristDto);
        model.addAttribute("message", "Done Registration");

        boolean result=tourismService.saveDetails(touristDto);
        if(result)
        {
            model.addAttribute("mes","good");
        }

        return "Tourism";


    }
    @RequestMapping("indexPage")
    public String backButton()
    {
        System.out.println("Running in backButton method");
        return "index";
    }
    @GetMapping({"displayAllEntites","back"})
    public String displayAllEntites(Model model)
    {
        System.out.println("Running in the displayAllEntites in controller in getMapping");
        List<TourismDto> fetched=tourismService.fetchAllEnties();
        System.out.println("the fetched entity:___________________>");
        fetched.forEach(System.out::println);
        model.addAttribute("ref",fetched);

        return "PrintEntities";
    }
    @GetMapping("view/{ID}")
    public String pribtByView(@PathVariable Integer ID,Model model)
    {
        System.out.println("Running in the pribtByView method");
        TourismDto result=tourismService.fetchById(ID);
        model.addAttribute("value",result);
        return "PrintByView";
    }

    @GetMapping("pback")
    public String anotherbackButton()
    {
        System.out.println("Running in anotherbackButton method");
        return "Tourism";
    }



}
