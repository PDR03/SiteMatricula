package com.applogin.appLogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.applogin.appLogin.model.student;

public interface studentRepository extends CrudRepository<student, Long> {
    Optional<student> findById(long id);
    Optional<student> findByMatricula(String matricula); 
    @Query(value = "SELECT * FROM applogin.students where matricula = :matricula and senha = :senha" ,nativeQuery = true)//Confirmação de login e senha
    public student loginStudent(String matricula, String senha);
}

