package com.pato.proyecto_final_spring_security.repository;

import com.pato.proyecto_final_spring_security.model.Posteo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPosteoRepository extends JpaRepository<Posteo,Long> {
}
