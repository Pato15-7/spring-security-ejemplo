package com.pato.proyecto_final_spring_security.service;

import java.util.List;

public interface IGenericService<T> {
    T add(T objeto);
    void delete(Long id);
    T getObjeto(Long id);
    List<T> getAll();
    T edit(Long id, T objeto);
}
