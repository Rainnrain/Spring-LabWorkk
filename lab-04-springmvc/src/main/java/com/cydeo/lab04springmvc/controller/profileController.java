package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class profileController {

    @RequestMapping("/profile")
    public String profile( Model model){
      Profile profile= new Profile("Lo@gmail.com", "2342341212", "Lorraine",
        "lcan", "lcanUser",LocalDateTime.now());
        model.addAttribute("profile",profile);

        return "profile/profile-info";
    }
}
