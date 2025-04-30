package com.applogin.appLogin.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
public class periodo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String periodo;

    @OneToMany(mappedBy = "periodo")
    private List<student> students;

    @ManyToMany
    @JoinTable(
        name = "matter_periodo",
        joinColumns = @JoinColumn(name = "periodo_id"),
        inverseJoinColumns = @JoinColumn(name = "matter_id")
    )
    private List<matter> matters;
    
    public List<matter> getMatters() {
        return matters;
    }

    public void setMatters(List<matter> matters) {
        this.matters = matters;
    }

    public Long getId() {
        return id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public List<student> getStudents() {
        return students;
    }

    public void setStudents(List<student> students) {
        this.students = students;
    }

}
