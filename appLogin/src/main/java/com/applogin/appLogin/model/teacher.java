package com.applogin.appLogin.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class teacher {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String loginDeRede;

    @NotEmpty
    private String senha;
    
    @ManyToMany//Relacionamento com Matérias
    @JoinTable(
        name = "teacher_matter",
        joinColumns = @JoinColumn(name = "teacher_id"),
        inverseJoinColumns = @JoinColumn(name = "matter_id")
    )

    private List<matter> matters;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLoginDeRede() {
        return loginDeRede;
    }

    public void setLoginDeRede(String loginDeRede) {
        this.loginDeRede = loginDeRede;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<matter> getMatters() {
        return matters;
    }

    public void setMatters(List<matter> matters) {
        this.matters = matters;
    }

    
}
