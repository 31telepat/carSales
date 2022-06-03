package com.boots.carsales.controller;

import com.boots.carsales.entity.Car;
import com.boots.carsales.entity.CarToDelete;
import com.boots.carsales.service.CarService;
import com.boots.carsales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {

    private final CarService carService;
    private final UserService userService;

    @Autowired
    public MainPageController(CarService carService, UserService userService) {
        this.carService = carService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String getMainPage(Model model){
        model.addAttribute("carList", carService.allCars());
        model.addAttribute("saveCar", new Car());
        model.addAttribute("deleteCar", new CarToDelete());
        return "index";
    }

    @PostMapping("/")
    public String postMainPage(Model model){
        model.addAttribute("saveCar", new Car());
        model.addAttribute("deleteCar", new CarToDelete());
        model.addAttribute("carList", carService.allCars());
        return "redirect:/";
    }

    @PostMapping("/saveCar")
    public String saveCar(Car car, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("saveCar", new Car());
            model.addAttribute("deleteCar", new CarToDelete());
            model.addAttribute("carList", carService.allCars());
            return "/";
        }else{
            carService.saveCar(car);
            return "redirect:/";
        }
    }
}
