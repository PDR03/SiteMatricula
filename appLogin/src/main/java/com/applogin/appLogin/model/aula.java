package com.applogin.appLogin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
public class aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String horario;

    @ManyToOne
    @JoinColumn(name = "matter_id")
    private matter materia;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private teacher professor;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private classRoom sala;

    @ManyToMany
    @JoinTable(
        name = "aula_student",
        joinColumns = @JoinColumn(name = "aula_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<student> students;

    

    public Long getId() {
        return id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public matter getMateria() {
        return materia;
    }

    public void setMateria(matter materia) {
        this.materia = materia;
    }

    public teacher getProfessor() {
        return professor;
    }

    public void setProfessor(teacher professor) {
        this.professor = professor;
    }

    public classRoom getSala() {
        return sala;
    }

    public void setSala(classRoom sala) {
        this.sala = sala;
    }

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }


}
