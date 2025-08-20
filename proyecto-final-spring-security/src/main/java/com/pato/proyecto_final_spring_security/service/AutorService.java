package com.pato.proyecto_final_spring_security.service;

import com.pato.proyecto_final_spring_security.model.Autor;
import com.pato.proyecto_final_spring_security.model.Posteo;
import com.pato.proyecto_final_spring_security.repository.IAutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService implements IGenericService<Autor>{

    @Autowired
    IAutorRepository autorRepository;

    @Override
    public Autor add(Autor objeto) {
        return autorRepository.save(objeto);
    }

    @Override
    public void delete(Long id) {
        Autor autor=getObjeto(id);
        autorRepository.deleteById(id);
    }

    @Override
    public Autor getObjeto(Long id) {
        return autorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No existe Autor con ese id!"));
    }

    @Override
    public List<Autor> getAll() {
        return autorRepository.findAll();
    }

    @Override
    public Autor edit(Long id, Autor objeto) {
        Autor autor=getObjeto(id);
        autor.setNombre(objeto.getNombre());
        autor.setFechaNacimiento(objeto.getFechaNacimiento());
        autorRepository.save(autor);
        return autor;
    }
}
