package com.pato.proyecto_final_spring_security.service;

import com.pato.proyecto_final_spring_security.model.UserSec;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List findAll();
    public Optional findById(Long id);
    public UserSec save(UserSec userSec);
    public void deleteById(Long id);
    public void update(UserSec userSec);
    //agregamos el método de encriptado
    public String encriptPassword(String password);
}
