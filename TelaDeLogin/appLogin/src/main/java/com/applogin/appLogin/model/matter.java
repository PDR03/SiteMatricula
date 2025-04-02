package com.applogin.appLogin.model;

import java.util.List;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "matters")
public class matter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   
    @NonNull
    @Column(name="nome_materia")
    private String nomeMateria;

    @NotNull
    private String sala;


    @ManyToMany(mappedBy = "matters")// Relacionamento com estudantes
    private List<student> students;

    @ManyToMany(mappedBy = "matters")//Realacionamento com professores
    private List<teacher> teachers;
    
    public long getId() {
        return id;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }



}
