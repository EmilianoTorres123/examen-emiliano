/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.alumnos.controllers;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aaron-emiliano
 */
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/materia")
public class ControllersMaterias {
    
     @Autowired
    private RepositoryMateria repositorymateria;

    @GetMapping("/msg")
    public String holamundo() {
        return "Hola mundo";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Materia> obtenermateria(@PathVariable("id") long id) {
        Optional<Materia> optionalMateria = repositorymateria.findById(id);
        if (!optionalMateria.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalMateria.get());
    }

    @GetMapping
    public ResponseEntity<Page<Materia>> obtenerTodosLasmaterias(Pageable pageable) {
        return ResponseEntity.ok(repositorymateria.findAll(pageable));
    }

    @PostMapping
    public Materia crearMateria(@RequestBody DTOMateria materiaDTO) {
        Materia materia = new Materia();
        BeanUtils.copyProperties(materiaDTO, materia);
        return repositorymateria.save(materia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Materia> actualizarMateria(@PathVariable("id") Long id, @RequestBody DTOMateria materiaDTO) {
        Materia materia = new Materia();
        materia.setNombre(materiaDTO.getNombre());
        materia.setCredito(materiaDTO.getCredito());
        Optional<Materia> optionalMateria = repositorymateria.findById(id);

        if (!optionalMateria.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        materia.setClavemateria(optionalMateria.get().getClavemateria());
        repositorymateria.save(materia);

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public void eliminarMateria(@PathVariable("id") Long id) {
        repositorymateria.findById(id);
    }  
}
