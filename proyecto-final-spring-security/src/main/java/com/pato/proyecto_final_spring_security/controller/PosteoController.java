package com.pato.proyecto_final_spring_security.controller;

import com.pato.proyecto_final_spring_security.model.Posteo;
import com.pato.proyecto_final_spring_security.service.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posteo")
public class PosteoController {
    @Autowired
    IGenericService<Posteo> posteoService;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN','AUTHOR')")
    public ResponseEntity Add(@RequestBody Posteo posteo){
        try {
            return ResponseEntity.ok(posteoService.add(posteo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno: " + e.getMessage());
        }
    }

    @GetMapping("/get/all")
    @PreAuthorize("hasAnyRole('ADMIN','USER','AUTHOR')")
    public ResponseEntity getAll(){
        try {
            return ResponseEntity.ok(posteoService.getAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno: " + e.getMessage());
        }
    }

    @GetMapping("/get/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','USER','AUTHOR')")
    public ResponseEntity getPosteo(@PathVariable Long id){
        try {
            return ResponseEntity.ok(posteoService.getObjeto(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno: " + e.getMessage());
        }
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','AUTHOR')")
    public ResponseEntity edit(@PathVariable Long id, @RequestBody Posteo posteo){
        try {
            return ResponseEntity.ok(posteoService.edit(id, posteo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            posteoService.delete(id);
            return ResponseEntity.ok("Se elimino el Posteo correctamente!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno: " + e.getMessage());
        }
    }
}
