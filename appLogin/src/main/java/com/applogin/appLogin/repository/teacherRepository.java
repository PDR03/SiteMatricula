package com.applogin.appLogin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.applogin.appLogin.model.teacher;

public interface teacherRepository extends CrudRepository<teacher, Long> {
    
    @Query(value = "SELECT * FROM applogin.teacher WHERE login_de_rede = :login_de_rede AND senha = :senha", nativeQuery = true)
    public teacher loginTeacher(@Param("login_de_rede") String loginDeRede, @Param("senha") String senha);

    
}
