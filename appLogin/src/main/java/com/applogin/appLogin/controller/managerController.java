package com.applogin.appLogin.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.applogin.appLogin.model.manager;
import com.applogin.appLogin.model.student;
import com.applogin.appLogin.repository.managerRepository;
import com.applogin.appLogin.repository.studentRepository;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class managerController {
    
    @Autowired//Repositorios 
    private studentRepository sr;//Rep Aluno
    @Autowired
    private managerRepository mr; //Rep Gerente

    @GetMapping("/loginscreenmanager")//Tela de login do gestor
    public String loginscreenmanager(){
        return "loginscreen/loginscreenmanager";
    }

    @PostMapping("/loginscreenmanager")//confirmação de acesso do gestor
    public String loginManager(manager manager, Model model, HttpServletResponse response, HttpSession session){
        manager mng = this.mr.loginManager(manager.getLoginDeRede(), manager.getSenha());
        if (mng != null) {
            return "redirect:/registrationchoice";
        }else{
            model.addAttribute("errorMessage", "Usuário ou senha inválidos! Tente novamente.");
            return "loginscreen/loginscreenmanager";
        }   
    }
    
    @GetMapping("/registerstudent")//tela de registro de estudante
    public String registerScreenStudent(){
        return "registerscreen/registerstudent";
    }

    @GetMapping("/registermanager")//tela de registro do gestor
    public String registerScreenManager(){
        return "registerscreen/registermanager";
 
    }

    @PostMapping("/registerstudent")
    public String registerStudent(@Valid student student, BindingResult result){
        if(result.hasErrors()){
            System.out.println("Deu ruim pedrão");
        }
        sr.save(student);
        return "redirect:/registrationchoice";
    }

    @PostMapping("/registermanager")
    public String registerManager(@Valid manager manager, BindingResult result){
        if(result.hasErrors()){
            System.out.println("Deu ruim pedrão");
        }

        mr.save(manager);
        return "redirect:/registrationchoice";
    }


     @GetMapping("/registrationchoice")
    public String registerChoice() {
        return "registerscreen/registrationchoice";
    }

    @GetMapping("/deleteStudent")
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

    @PostMapping("/confirmStudent")
    public String deleteStudentPost(@RequestParam String senha, @RequestParam String matricula, Model model) {
        Optional<student> studentOpt = sr.findByMatricula(matricula);

        if (studentOpt.isPresent()) {
            sr.delete(studentOpt.get());
            model.addAttribute("mensagemSucesso", "Aluno removido com sucesso!");
            return "registerscreen/registrationchoice";
        } else {
            return "registerscreen/registrationchoice";
        }
    }

    @GetMapping("/delteManager")
    public String deleteManager(HttpSession session, Model model){
        Object loginDeRedeObj = session.getAttribute("LoginDeRede");
        Object senhaObj = session.getAttribute("senha");

        if( loginDeRedeObj == null ){//Valida se o login de rede do gestor que vai ser deletado existe
            model.addAttribute("mensagemErro", "Gestor não encontrato, verifique os dados");
            return "redirect:/registrationchoice";
        }
        if(senhaObj == null){//Valida se a senha do Gestor que está deletando o usuario está correta
            model.addAttribute("ensagemErro", "Senha incorreta, confira sua senha!" );
            return "redirect:/registrationchoice";
        }

        try{//Tenta deletar o usuario
            String loginDeRede = loginDeRedeObj.toString();
            String senha = senhaObj.toString();
            deleteManager(loginDeRede, senha, model);
            return "redirect:/registrationchoice";
        }catch(NumberFormatException e){
            model.addAttribute("mensagemErro", "Erro ao processar os dados do aluno.");
            return "redirect:/registrationchoice";
        }
    }

    @PostMapping("/confirmManager")
    public String deleteManager(@RequestParam String LoginDeRede, @RequestParam String senha, Model model){
        Optional<manager> managerOpt = mr.findByLoginDeRede(LoginDeRede);
       
        if(managerOpt.isPresent()){
            mr.delete(managerOpt.get());
            model.addAttribute("mensagemSucesso", "Gestor deletado com sucesso!");
            return "registerscreen/registrationchoice";
        } else {
            return "registerscreen/registrationchoice";
        }
        
    }
  
}
 
