package com.applogin.appLogin.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class classRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true) //Só pode ter uma valor unico
    private String numDaSala;

    @NotNull
    private String area;

    @NotNull
    private String bloco;


    @ManyToMany//Relacionamento com materias
    @JoinTable(
        name = "class_matter",
        joinColumns = @JoinColumn(name = "classroom_id"),
        inverseJoinColumns = @JoinColumn(name = "matter_id")
    )
    private List<matter> matters;

    @ManyToMany//Relacionamento com aluno
    @JoinTable(
        name = "class_students",
        joinColumns = @JoinColumn(name = "classroom_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<student> students;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumDaSala() {
        return numDaSala;
    }

    public void setNumDaSala(String numDaSala) {
        this.numDaSala = numDaSala;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public List<matter> getMatters() {
        return matters;
    }

    public void setMatters(List<matter> matters) {
        this.matters = matters;
    }

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }


}
