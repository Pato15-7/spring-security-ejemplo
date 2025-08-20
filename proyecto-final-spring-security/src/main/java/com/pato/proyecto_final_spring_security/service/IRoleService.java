package com.pato.proyecto_final_spring_security.service;


import com.pato.proyecto_final_spring_security.model.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleService {
    List findAll();
    Optional<Role> findById(Long id);
    Role save(Role role);
    void deleteById(Long id);
    Role update(Role role);
}
