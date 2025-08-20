package com.pato.proyecto_final_spring_security.repository;

import com.pato.proyecto_final_spring_security.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPermissionRepository extends JpaRepository<Permission,Long> {
}
