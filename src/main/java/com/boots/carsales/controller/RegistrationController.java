package com.boots.carsales.controller;

import com.boots.carsales.entity.User;
import com.boots.carsales.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    Logger logger = Logger.getLogger(RegistrationController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        logger.info("you got form reg");
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            logger.info("binding errors reg");
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
           model.addAttribute("passwordError", "Пароли не совпадают");
            logger.info("paroly ne sovpadaut!");

           return "registration";
        }
        if (!userService.saveUser(userForm)){
            logger.info("reg start");

            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            logger.info("reg finish");

            return "registration";
        }
        return "redirect:/";
    }
}
