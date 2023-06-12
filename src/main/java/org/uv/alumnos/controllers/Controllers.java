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
@RequestMapping("/api/alumno")
public class Controllers {

    @Autowired
    private RepositoryAlumno repositoryalumno;

    @GetMapping("/msg")
    public String holamundo(){
        return "Hola mundo";
    }
    
    @GetMapping("/{id}")
    public Alumnos obtenerAlumno(@PathVariable("id") long id) {
        Optional<Alumnos> optionalAlumnos = repositoryalumno.findById(id);
        if (optionalAlumnos.isPresent()) {
            Alumnos alumno = optionalAlumnos.get();
            return alumno;
        } else {
            return null;
        }
    }

    @GetMapping
    public List<Alumnos> obtenerTodosLosalumnos() {
        List<Alumnos> alumnos = (List<Alumnos>) repositoryalumno.findAll();

        return alumnos;
    }

    @PostMapping
    public Alumnos crearAlumno(@RequestBody DTOAlumnos alumnoDTO) {
        Alumnos alumno = new Alumnos();
        BeanUtils.copyProperties(alumnoDTO, alumno);
        return repositoryalumno.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumnos actualizarAlumnos(@PathVariable("id") Long id, @RequestBody DTOAlumnos alumnoDTO) {
        Optional<Alumnos> optionalAlumnos = repositoryalumno.findById(id);
        if (optionalAlumnos.isPresent()) {
            Alumnos alumno = optionalAlumnos.get();
            alumno.setNombre(alumnoDTO.getNombre());
            alumno.setDireccion(alumnoDTO.getDireccion());
            alumno.setTelefono(alumnoDTO.getTelefono());

            Alumnos empleadoActualizado = repositoryalumno.save(alumno);

            return empleadoActualizado;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarEmpleado(@PathVariable("id") Long id) {
        repositoryalumno.deleteById(id);
    }
    
}
