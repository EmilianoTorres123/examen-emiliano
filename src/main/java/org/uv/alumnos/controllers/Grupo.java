/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.alumnos.controllers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author aaron-emiliano
 */
@Entity
@Table(name = "grupo")
public class Grupo {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id;
   
   @ManyToOne
   @JoinColumn(name = "clave_alumno")
   private Alumnos alumnos;
   
   @ManyToOne
   @JoinColumn(name = "clave_materia")
   private Materia materia;

   @Column(name="nombregrupo")
    String nombregrupo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumnos getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }

    public String getNombregrupo() {
        return nombregrupo;
    }

    public void setNombregrupo(String nombregrupo) {
        this.nombregrupo = nombregrupo;
    }

}
    
    
 

  


    
