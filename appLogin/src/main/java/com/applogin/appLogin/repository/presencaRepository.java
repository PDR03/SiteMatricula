package com.applogin.appLogin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.applogin.appLogin.model.matter;
import com.applogin.appLogin.model.presenca;

public interface presencaRepository extends CrudRepository<presenca,Long>{

    List<presenca> findByAulaMateria(matter materia);

}
