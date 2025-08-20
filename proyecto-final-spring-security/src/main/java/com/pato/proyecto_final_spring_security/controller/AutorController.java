package com.pato.proyecto_final_spring_security.controller;

import com.pato.proyecto_final_spring_security.model.Autor;
import com.pato.proyecto_final_spring_security.repository.IAutorRepository;
import com.pato.proyecto_final_spring_security.service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    IGenericService<Autor> autorService;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity Add(@RequestBody Autor autor){
        try {
            return ResponseEntity.ok(autorService.add(autor));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno: " + e.getMessage());
        }
    }

    @GetMapping("/get/all")
    @PreAuthorize("hasAnyRole('ADMIN','USER','AUTHOR')")
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(autorService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno: " + e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER','AUTHOR')")
    public ResponseEntity getAutor(@PathVariable Long id){
        try {
            return ResponseEntity.ok(autorService.getObjeto(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno: " + e.getMessage());
        }
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity edit(@PathVariable Long id,@RequestBody Autor autor){
        try {
            return ResponseEntity.ok(autorService.edit(id, autor));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            autorService.delete(id);
            return ResponseEntity.ok("Se elimino el Autor correctamente!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno: " + e.getMessage());
        }
    }
}
