package com.boots.carsales.controller;

import com.boots.carsales.service.CarService;
import com.boots.carsales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getMainPage(Model model){
        model.addAttribute("carList", carService.allCars());
        return "index";
    }

    @PostMapping("/")
    public String postMainPage(Model model){
        model.addAttribute("carList", carService.allCars());
        return "redirect:/";
    }
}
