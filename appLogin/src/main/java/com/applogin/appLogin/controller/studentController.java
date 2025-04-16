package com.applogin.appLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.applogin.appLogin.model.student;
import com.applogin.appLogin.repository.studentRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class studentController {
    
     @Autowired//Repositorios 
    private studentRepository sr;//Rep Aluno


        @GetMapping("/loginscreenstudent")//Tela de login do aluno
    public String loginscreenstudent(){
        return "loginscreen/loginscreenstudent";
    }


     @PostMapping("/loginscreenstudent")//Confirmação de dados do aluno
    public String loginStudent(student student, Model model, HttpServletResponse response, HttpSession session){
        student stu = this.sr.loginStudent(student.getMatricula(),student.getSenha());
        if (stu != null) {
            session.setAttribute("studentId", stu.getId());
            return "redirect:/mainStudent";
        }else{
            model.addAttribute("errorMessage", "Matrícula ou senha inválidos! Tente novamente.");
            return "loginscreen/loginscreenstudent";
        }
    }


    @GetMapping("/mainStudent")
    public String mainScreenStudent(Model model, HttpSession session) {
        Long studentId = (Long) session.getAttribute("studentId");
        student stu = this.sr.findById(studentId).orElse(null);
    
        if (stu != null) {
            model.addAttribute("nome", stu.getNome());
            model.addAttribute("matricula", stu.getMatricula());
            model.addAttribute("email", stu.getEmail());
           // model.addAttribute("curso", stu.getNome());
        }
    
        return "mainscreen/mainScreenStudent";
    }
    
}
