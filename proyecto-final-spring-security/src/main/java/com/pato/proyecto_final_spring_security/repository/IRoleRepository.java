package com.pato.proyecto_final_spring_security.repository;

import com.pato.proyecto_final_spring_security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
}
