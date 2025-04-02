package com.applogin.appLogin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.applogin.appLogin.model.student;
import com.applogin.appLogin.repository.studentRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/matriculaAluno")
public class matterController{

    @Autowired
    private studentRepository stu;

        @GetMapping("")
        public String mostrarMatricula(Model model, HttpSession session){
            Long studentId = (Long) session.getAttribute("studentId");
            Optional<student> matterStudent = stu.findById(studentId);
            
            if (matterStudent.isPresent()) {
                model.addAttribute("matters", matterStudent.get().getMatters());
            } else {
                model.addAttribute("error", "Aluno não encontrado.");
            }
            return "enrollscreen/enrollrecorded";
        }

        
}