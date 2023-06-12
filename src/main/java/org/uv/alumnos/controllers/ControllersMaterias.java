/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.alumnos.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String holamundo(){
        return "Hola mundo";
    }
    
    @GetMapping("/{id}")
    public Materia obtenermateria(@PathVariable("id") long id) {
        Optional<Materia> optionalMateria = repositorymateria.findById(id);
        if (optionalMateria.isPresent()) {
            Materia materia = optionalMateria.get();
            return materia;
        } else {
            return null;
        }
    }

    @GetMapping
    public List<Materia> obtenerTodosLasmaterias() {
        List<Materia> materia = (List<Materia>) repositorymateria.findAll();
        return materia;
    }

    @PostMapping
    public Materia crear(@RequestBody DTOMateria materiaDTO) {
    Materia materia = new Materia();
    BeanUtils.copyProperties(materiaDTO, materia);
    
    Materia materiaNuevo = repositorymateria.save(materia);
    
    return materiaNuevo;
}

    @PutMapping("/{id}")
    public Materia actualizarMateria(@PathVariable("id") Long id, @RequestBody DTOMateria materiaDTO) {
        Optional<Materia> optionalMateria = repositorymateria.findById(id);
        if (optionalMateria.isPresent()) {
            Materia materia = optionalMateria.get();
            materia.setNombre(materiaDTO.getNombre());
            materia.setCredito(materiaDTO.getCredito());
            

            Materia materiaActualizado = repositorymateria.save(materia);

            return materiaActualizado;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable("id") Long id) {
        repositorymateria.deleteById(id);
    }
    
}
