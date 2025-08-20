package com.pato.proyecto_final_spring_security.service;

import com.pato.proyecto_final_spring_security.model.Permission;

import java.util.List;
import java.util.Optional;

public interface IPermissionService {
    List findAll();
    Optional<Permission> findById(Long id);
    Permission save(Permission permission);
    void deleteById(Long id);
    Permission update(Permission permission);
}