package com.example.lab5_20206442.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lugares")
public class LugaresControllers {

    @GetMapping("")
    public String principal(){
        return "inicio";
    }
}
