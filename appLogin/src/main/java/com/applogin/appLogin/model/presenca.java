package com.applogin.appLogin.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class presenca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
       
    @ManyToOne
    private aula aula;

    @ManyToOne
    private student aluno;

    private boolean presente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public aula getAula() {
        return aula;
    }

    public void setAula(aula aula) {
        this.aula = aula;
    }

    public student getAluno() {
        return aluno;
    }

    public void setAluno(student aluno) {
        this.aluno = aluno;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
