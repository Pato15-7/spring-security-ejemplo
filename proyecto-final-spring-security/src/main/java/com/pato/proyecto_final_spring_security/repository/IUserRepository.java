package com.pato.proyecto_final_spring_security.repository;

import com.pato.proyecto_final_spring_security.model.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<UserSec, Long> {

    //Crea la sentencia en base al nombre en inglés del método
    //Tmb se puede hacer mediante Query pero en este caso no es necesario
    Optional<UserSec> findUserEntityByUsername(String username);

}
