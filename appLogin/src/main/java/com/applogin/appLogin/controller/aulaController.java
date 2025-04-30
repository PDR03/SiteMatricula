package com.applogin.appLogin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.applogin.appLogin.model.student;
import com.applogin.appLogin.repository.studentRepository;


import jakarta.servlet.http.HttpSession;

@Controller
public class aulaController {
    
    @Autowired
    private studentRepository stu;


    @GetMapping("/aulas")
    public String aulas(Model model, HttpSession session ){
    
        Long studentId = (Long) session.getAttribute("studentId");
        Optional<student> aulasStudent = stu.findById(studentId);
    
        if(aulasStudent.isPresent()){
            model.addAttribute("aulas", aulasStudent.get().getAulas());
        }
        return "mainscreen/actionsStudent/seeClasses";
    } 
}
