package com.applogin.appLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.applogin.appLogin.model.teacher;
import com.applogin.appLogin.repository.teacherRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class teacherController {
    
    @Autowired
    teacherRepository tr;

    @GetMapping("/loginscreenteacher")
    public String loginScreenTeacher(){
        return "loginscreen/loginscreenteacher";
    }

    @GetMapping("/mainscreenteacher")
    public String mainscreenteacher(Model model, HttpSession session){
        Long teacherId = (long) session.getAttribute("teacherId");
        teacher teach = this.tr.findById(teacherId).orElse(null);

        if(teach != null){
            model.addAttribute("nome", teach.getNome());
            model.addAttribute("loginDeRede", teach.getLoginDeRede());
        }
        return "mainscreen/mainscreenteacher";
    }

         @PostMapping("/loginscreenteacher")//Confirmação de dados do aluno
    public String loginTeacher(teacher teacher, Model model, HttpServletResponse response, HttpSession session){
        teacher teach = this.tr.loginTeacher(teacher.getLoginDeRede(), teacher.getSenha());
        if (teach != null) {
            session.setAttribute("teacherId", teach.getId());
            return "redirect:/mainscreenteacher";
        }else{
            model.addAttribute("errorMessage", "Matrícula ou senha inválidos! Tente novamente.");
            return "loginscreen/loginscreenteacher";
        }
    }
}
