package com.applogin.appLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homescreenController {
    
        @GetMapping("/homescreen")
    public String homeScreen(){
        return "homescreen/homescreen";
    }
}
