package com.applogin.appLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.applogin.appLogin.repository.teacherRepository;

@Controller
public class teacherController {
    
    @Autowired
    teacherRepository tr;

    @GetMapping("/loginscreenteacher")
    public String loginScreenTeacher(){
        return "loginscreen/loginscreenteacher";
    }
}
