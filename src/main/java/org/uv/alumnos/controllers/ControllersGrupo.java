/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.alumnos.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/grupo")
public class ControllersGrupo {
    
@Autowired
    private RepositoryGrupo repositorygrupo;

    @Autowired
    private RepositoryAlumno repositoryalumno;

    @Autowired
    private RepositoryMateria repositorymateria;
    
    @GetMapping("/msg")
    public String holamundo() {
        return "Hola mundo";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> obtenergrupo(@PathVariable("id") long id) {
        Optional<Grupo> optionalGrupo = repositorygrupo.findById(id);
        if (!optionalGrupo.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalGrupo.get());
    }

    @GetMapping
    public ResponseEntity<List<Grupo>> obtenerTodosLasmaterias() {
        return ResponseEntity.ok(repositorygrupo.findAll());
    }

    @PostMapping
    public Grupo crearGrupo(@RequestBody DTOGrupo grupoDTO) {
        Grupo grupo = new Grupo();

        BeanUtils.copyProperties(grupoDTO, grupo, "clavemateria", "clavealumnos"); // Excluir los campos claveMateria y claveAlumno de la copia
        // Asignar manualmente los valores de claveMateria y claveAlumno
        Materia materia = repositorymateria.findById(grupoDTO.getClavemateria())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada con ID: " + grupoDTO.getClavemateria()));
        Alumnos alumno = repositoryalumno.findById(grupoDTO.getClavealumnos())
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con ID: " + grupoDTO.getClavealumnos()));

        grupo.setMateria(materia);
        grupo.setAlumnos(alumno);
        grupo.setNombregrupo(grupoDTO.getNombregrupo());

        return repositorygrupo.save(grupo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Grupo> actualizarGrupo(@PathVariable("id") Long id, @RequestBody DTOGrupo grupoDTO) {
        Grupo grupo = new Grupo();
        grupo.setNombregrupo(grupoDTO.getNombregrupo());
        Optional<Grupo> optionalGrupo = repositorygrupo.findById(id);

        if (!optionalGrupo.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        grupo.setId(optionalGrupo.get().getId());
        repositorygrupo.save(grupo);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Grupo> eliminarGrupo(@PathVariable("id") Long id) {
        Optional<Grupo> optionalGrupo = repositorygrupo.findById(id);

        if (!optionalGrupo.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        repositorygrupo.delete(optionalGrupo.get());
        return ResponseEntity.noContent().build();
    }
    
    
}
