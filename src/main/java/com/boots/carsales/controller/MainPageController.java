package com.boots.carsales.controller;

import com.boots.carsales.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("carList", carService.allCars());
        return "index";
    }
}
