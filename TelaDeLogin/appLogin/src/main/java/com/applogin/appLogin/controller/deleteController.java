package com.applogin.appLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.applogin.appLogin.model.student;
import com.applogin.appLogin.repository.studentRepository;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/registrationchoice")
public class deleteController {  // Corrigido nome da classe

    @Autowired
    private studentRepository stu;  // Corrigido nome do repositório para seguir convenção Java

    @GetMapping("")
    public String registerChoice() {
        return "registerscreen/registrationchoice";
    }

    @GetMapping("/delete")
    public String deleteStudent(HttpSession session, Model model) {
        Object matriculaObj = session.getAttribute("matricula");
        Object senhaObj = session.getAttribute("senha");

        if (matriculaObj == null || senhaObj == null) {
            model.addAttribute("mensagemErro", "Aluno não encontrado ou senha inválida.");
            return "redirect:/registrationchoice";
        }

        try {
            String matricula = matriculaObj.toString();
            String senha = senhaObj.toString();
            return deleteStudentPost(senha, matricula, model);
        } catch (NumberFormatException e) {
            model.addAttribute("mensagemErro", "Erro ao processar os dados do aluno.");
            return "redirect:/registrationchoice";
        }
    }

    @PostMapping("/confirm")
    public String deleteStudentPost(@RequestParam String senha, @RequestParam String matricula, Model model) {
        Optional<student> studentOpt = stu.findByMatricula(matricula);

        if (studentOpt.isPresent()) {
            stu.delete(studentOpt.get());
            model.addAttribute("mensagemSucesso", "Aluno removido com sucesso!");
            return "registerscreen/registrationchoice";
        } else {
            System.out.println("Erro: Aluno não encontrado.");
            return "registerscreen/registrationchoice";
        }
    }
}
