package com.pato.proyecto_final_spring_security.service;

import com.pato.proyecto_final_spring_security.model.Posteo;
import com.pato.proyecto_final_spring_security.repository.IPosteoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPosteoService implements IGenericService<Posteo>{

    @Autowired
    IPosteoRepository posteoRepository;

    @Override
    public Posteo add(Posteo objeto) {
        return posteoRepository.save(objeto);
    }

    @Override
    public void delete(Long id) {
        Posteo posteo=getObjeto(id);
        posteoRepository.deleteById(id);
    }

    @Override
    public Posteo getObjeto(Long id) {
        return posteoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("No existe posteo con ese id!"));
    }

    @Override
    public List<Posteo> getAll() {
        return posteoRepository.findAll();
    }

    @Override
    public Posteo edit(Long id, Posteo objeto) {
        Posteo posteo=getObjeto(id);
        posteo.setTitulo(objeto.getTitulo());
        posteo.setCuerpo(objeto.getCuerpo());
        posteo.setAutor(objeto.getAutor());
        posteoRepository.save(posteo);
        return posteo;
    }
}
