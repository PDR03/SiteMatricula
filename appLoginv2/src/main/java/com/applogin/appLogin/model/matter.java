package com.applogin.appLogin.model;

import java.util.List;

import org.springframework.lang.NonNull;

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
    private String periodo;
    
    @ManyToMany(mappedBy = "matters")//relacionamento com sala de aula
    private List<classRoom> classrooms;

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

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }

    public List<teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<teacher> teachers) {
        this.teachers = teachers;
    }
}
