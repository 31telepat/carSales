package com.boots.carsales.controller;

import com.boots.carsales.entity.Car;
import com.boots.carsales.entity.CarToDelete;
import com.boots.carsales.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/news")
    public String carList(Model model){
        model.addAttribute("saveCar", new Car());
        model.addAttribute("deleteCar", new CarToDelete());
        model.addAttribute("carlist", carService.allCars());
        return "news";
    }

    @PostMapping("/saveCar")
    public String saveCar(Car car, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("saveCar", new Car());
            model.addAttribute("deleteCar", new CarToDelete());
            model.addAttribute("carlist", carService.allCars());
            return "news";
        }else{
            carService.saveCar(car);
            return "redirect:/";
        }
    }
}
