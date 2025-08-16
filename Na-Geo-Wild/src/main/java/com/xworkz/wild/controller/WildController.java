package com.xworkz.wild.controller;

import com.xworkz.wild.dto.WildDto;
import com.xworkz.wild.service.WildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.List;

@Controller
@RequestMapping("/")
public class WildController {
    @Autowired
    WildService wildService;

    public WildController() {
        System.out.println("Running in the WildController Constructor ");
    }

    @GetMapping("click")
    public String RedirectPage() {
        System.out.println("Running in RedirectPage method ");
        return "Wild";
    }

    @PostMapping("details")
    public String fillDetails(WildDto wildDto, Model model) {
        System.out.println("Running in the fillDetails method ");
        System.out.println(wildDto);


        boolean check = wildService.saveDetails(wildDto);
        if (check) {
            model.addAttribute("message", "Done");
            List<WildDto> ref = wildService.fetchListOfEntities();
            model.addAttribute("listOfDto", ref);
            System.out.println("Final returned value");
            ref.forEach(System.out::println);

            return "WildEntities";
        } else {
            model.addAttribute("error", "Failed");

            System.out.println("Not Saved for DataBase");
            return "Wild";
        }
    }

    @GetMapping({"getAllData","wback"})
    public String getAllData(Model model) {
        System.out.println("Running in the getAllData");
        List<WildDto> ref = wildService.fetchListOfEntities();
        model.addAttribute("listOfDto", ref);
        System.out.println("Final returned value");
        ref.forEach(System.out::println);

        return "WildEntities";
    }

    @GetMapping("back")
    public String indexPage() {
        System.out.println("Running in the indexPage Method");
        return "index";
    }



    @GetMapping("view/{id}")
    public String getId(@PathVariable Integer id,Model model)
    {
        System.out.println("get by id");
        WildDto byId=wildService.fetchById(id);

        System.out.println("controller a fetched ID :  "+byId);

        model.addAttribute("onlyId",byId);

        return "DisplayId";
    }

//    @GetMapping("/wback")
//    public String wildEntitesTablePage() {
//        System.out.println("Running in the wildEntitesTablePage Method");
//        return "WildEntities";
//    }


}