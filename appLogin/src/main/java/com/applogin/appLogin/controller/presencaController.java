package com.applogin.appLogin.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.applogin.appLogin.model.matter;
import com.applogin.appLogin.model.presenca;
import com.applogin.appLogin.model.student;
import com.applogin.appLogin.repository.matterRepository;
import com.applogin.appLogin.repository.presencaRepository;
import com.applogin.appLogin.repository.studentRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class presencaController {

    @Autowired
    private studentRepository sr;

    @Autowired
    private presencaRepository pr;

    @Autowired
    private matterRepository mr;

    @GetMapping("/presenca")
    public String verPresencas(Model model, HttpSession session) {
        Long studentId = (Long) session.getAttribute("studentId");
        student stu = sr.findById(studentId).orElse(null);
    
        if (stu == null || stu.getPeriodo() == null) {
            return "redirect:/mainStudent";
        }
    
        // Agora pegamos as matérias diretamente do período do estudante
        List<matter> materias = stu.getPeriodo().getMatters();
    
        for (matter materia : materias) {
            List<presenca> presencasDaMateria = pr.findByAulaMateria(materia);
            List<presenca> presencasTrue = presencasDaMateria.stream()
                .filter(p -> p.isPresente())
                .collect(Collectors.toList());
            materia.setPresencasTrue(presencasTrue); 
        }
    
        model.addAttribute("materias", materias);
        return "mainscreen/actionsStudent/attendance";
    }
}
