package com.applogin.appLogin.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.applogin.appLogin.model.manager;

public interface managerRepository extends CrudRepository<manager, String>{
    manager findById(Long id);

    @Query(value = "SELECT * FROM applogin.managers WHERE login_de_rede = :login_de_rede AND senha = :senha", nativeQuery = true)
    public manager loginManager(@Param("login_de_rede") String loginDeRede, @Param("senha") String senha);
}
