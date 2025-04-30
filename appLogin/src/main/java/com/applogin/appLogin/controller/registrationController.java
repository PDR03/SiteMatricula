package com.applogin.appLogin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.applogin.appLogin.model.aula;
import com.applogin.appLogin.model.matter;
import com.applogin.appLogin.model.student;
import com.applogin.appLogin.repository.aulaRepository;
import com.applogin.appLogin.repository.matterRepository;
import com.applogin.appLogin.repository.studentRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/matricula")
public class registrationController {


    @Autowired
    private matterRepository mr;

    @Autowired
    private studentRepository studentRepository;

    @Autowired
    private aulaRepository ar;

    @GetMapping("")
    public String materias(Model model, HttpSession session){
        Long studentId = (Long) session.getAttribute("studentId");
        student stu = studentRepository.findById(studentId).orElse(null);
        Iterable<matter> matters = stu.getPeriodo().getMatters();
        model.addAttribute("matters", matters);
        return "enrollscreen/enrollScreen";
    }

    @PostMapping("")
    public String registrarMatricula(
        @RequestParam List<Long> matterIds, 
        HttpSession session,
        RedirectAttributes redirectAttributes) {
    
        // Validação básica
        if (matterIds == null || matterIds.isEmpty()) {
            redirectAttributes.addFlashAttribute("erro", "Selecione pelo menos uma matéria");
            return "redirect:/matriculaAluno";
        }
    
        Long studentId = (Long) session.getAttribute("studentId");
        if (studentId == null) {
            redirectAttributes.addFlashAttribute("erro", "Sessão expirada. Faça login novamente");
            return "redirect:/login";
        }
    
        Optional<student> studentOpt = studentRepository.findById(studentId);
        if (!studentOpt.isPresent()) {
            redirectAttributes.addFlashAttribute("erro", "Aluno não encontrado");
            return "redirect:/matriculaAluno";
        }
    
        try {
            student student = studentOpt.get();
            
            // Corrigindo o type mismatch - convertendo Iterable para List
            List<matter> selectedMatters = new ArrayList<>();
            mr.findAllById(matterIds).forEach(selectedMatters::add);
            
            // Verifica se todas as matérias foram encontradas
            if (selectedMatters.size() != matterIds.size()) {
                redirectAttributes.addFlashAttribute("erro", "Algumas matérias não foram encontradas");
                return "redirect:/matriculaAluno";
            }
    
            student.setMatters(selectedMatters);
            studentRepository.save(student);
    
            // Corrigindo o nome do método (de Material para Materia)
            List<aula> aulas = ar.findByMateriaIn(selectedMatters);
            
            // Atualiza todas as aulas de uma vez
            for (aula aula : aulas) {
                List<student> alunos = aula.getStudents();
                if (alunos == null) {
                    alunos = new ArrayList<>();
                }
                if (!alunos.contains(student)) {
                    alunos.add(student);
                    aula.setStudents(alunos);
                }
            }
            ar.saveAll(aulas);
    
            redirectAttributes.addFlashAttribute("sucesso", "Matrícula realizada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao processar matrícula: " + e.getMessage());
        }
    
        return "redirect:/matriculaAluno";
    }
}
