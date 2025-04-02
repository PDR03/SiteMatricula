package com.applogin.appLogin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.applogin.appLogin.model.matter;
import com.applogin.appLogin.model.student;
import com.applogin.appLogin.repository.matterRepository;
import com.applogin.appLogin.repository.studentRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/matricula")
public class registrationController {


    @Autowired
    private matterRepository matterRepository;

    @Autowired
    private studentRepository studentRepository;

    @GetMapping("")
    public String materias(Model model){
        Iterable<matter> matters = matterRepository.findAll();
        model.addAttribute("matters", matters);
        return "enrollscreen/enrollScreen";
    }

    @PostMapping("")
    public String registrarMatricula(@RequestParam List<Long> matterIds, HttpSession session) {
        Long studentId = (Long) session.getAttribute("studentId");

        if (studentId != null) {
            Optional<student> studentOpt = studentRepository.findById(studentId);
        
            if (studentOpt.isPresent()) {
                student student = studentOpt.get();
                List<matter> selectedMatters = (List<matter>) matterRepository.findAllById(matterIds);
                student.setMatters(selectedMatters);
                studentRepository.save(student);
            }         
        }
    return "redirect:/matriculaAluno";
    }
}
