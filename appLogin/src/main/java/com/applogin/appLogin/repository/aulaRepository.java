package com.applogin.appLogin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.applogin.appLogin.model.aula;
import com.applogin.appLogin.model.matter;

public interface aulaRepository extends CrudRepository<aula,Long> {
    
    List<aula> findByMateriaIn(List<matter> materias);

    @Query("SELECT DISTINCT a FROM aula a JOIN a.students s WHERE s.id = :studentId")
    List<aula> findDistinctByStudentsId(@Param("studentId") Long studentId);

}
