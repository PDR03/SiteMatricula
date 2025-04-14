package com.applogin.appLogin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.applogin.appLogin.model.teacher;

public interface teacherRepository extends CrudRepository<teacher, Long> {
    
    @Query(value = "SELECT * FROM applogin.teachers where loginDeRede = :LoginDeRede and senha = :senha" ,nativeQuery = true)
    public String loginTeacher(String loginDeRede, String senha);
}
