package com.applogin.appLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.applogin.appLogin.model.manager;
import com.applogin.appLogin.model.student;
import com.applogin.appLogin.repository.managerRepository;
import com.applogin.appLogin.repository.studentRepository;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class urlcontroller {
    

    @Autowired//Repositorios 
    private studentRepository sr;//Rep Aluno
    @Autowired
    private managerRepository mr; //Rep Gerente

    @GetMapping("/loginscreenstudent")
    public String loginscreenstudent(){
        return "loginscreen/loginscreenstudent";
    }

    @PostMapping("/loginscreenstudent")
    public String loginStudent(student student, Model model, HttpServletResponse response, HttpSession session){
        student stu = this.sr.loginStudent(student.getMatricula(),student.getSenha());
        if (stu != null) {
            session.setAttribute("studentId", stu.getId());
            return "redirect:/matricula";
        }else{
            model.addAttribute("errorMessage", "Matrícula ou senha inválidos! Tente novamente.");
            return "loginscreen/loginscreenstudent";
        }
    }

    @GetMapping("/loginscreenmanager")
    public String loginscreenmanager(){
        return "loginscreen/loginscreenmanager";
    }

    @PostMapping("/loginscreenmanager")
    public String loginManager(manager manager, Model model, HttpServletResponse response, HttpSession session){
        manager mng = this.mr.loginManager(manager.getLoginDeRede(), manager.getSenha());
        if (mng != null) {
            return "redirect:/registrationchoice";
        }else{
            model.addAttribute("errorMessage", "Usuário ou senha inválidos! Tente novamente.");
            return "loginscreen/loginscreenmanager";
        }
    
        
    }
    

    @GetMapping("/homescreen")
    public String homeScreen(){
        return "homescreen/homescreen";
    }

    @GetMapping("/registerstudent")
    public String registerScreenStudent(){
        return "registerscreen/registerstudent";
    }

    @GetMapping("/registermanager")
    public String registerScreenManager(){
        return "registerscreen/registermanager";
 
    }

    @PostMapping("/registerstudent")
    public String registerStudent(@Valid student student, BindingResult result){
        if(result.hasErrors()){
            System.out.println("Deu ruim pedrão");
        }
        sr.save(student);
        return "redirect:/homescreen";
    }

    @PostMapping("/registermanager")
    public String registerManager(@Valid manager manager, BindingResult result){
        if(result.hasErrors()){
            System.out.println("Deu ruim pedrão");
        }

        mr.save(manager);
        return "redirect:/homescreen";
    }

}
 
