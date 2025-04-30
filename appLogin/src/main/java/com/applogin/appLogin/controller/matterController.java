package com.applogin.appLogin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.applogin.appLogin.model.matter;
import com.applogin.appLogin.model.student;
import com.applogin.appLogin.repository.studentRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/matriculaAluno")
public class matterController{

    @Autowired
    private studentRepository sr;

    @GetMapping("")
    public String mostrarMatricula(Model model, HttpSession session){
        Long studentId = (Long) session.getAttribute("studentId");
        student stu = sr.findById(studentId).orElse(null);
    
        if (stu != null && stu.getPeriodo() != null) {
            List<matter> matterStudent = stu.getPeriodo().getMatters();
            model.addAttribute("matters", matterStudent);
        } else {
            model.addAttribute("error", "Aluno não encontrado ou período não definido.");
        }
    
        return "enrollscreen/enrollrecorded";
    }

        
}