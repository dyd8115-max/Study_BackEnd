package com.example.Java_spring.controller;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class First {

    @GetMapping("/hi")
    public String nice(Model model)
    {
        model.addAttribute("username", "용균");
        return "greetings";

    }

    @GetMapping("/bye")
    public String good(Model model)
    {
        model.addAttribute("name", "윤서");
        return "goodbye";
    }


}
