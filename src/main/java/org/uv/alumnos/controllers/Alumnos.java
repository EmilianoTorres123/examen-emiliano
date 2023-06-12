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
import javax.persistence.Table;

/**
 *
 * @author aaron-emiliano
 */
@Entity
@Table(name = "alumnos")
public class Alumnos {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long clavealumnos;

    @Column(name="nombre")
    String nombre;
    
    @Column(name="direccion")
    String direccion;
    
    @Column(name="telefono")
    String telefono;

    public Long getClavealumnos() {
        return clavealumnos;
    }

    public void setClavealumnos(Long clavealumnos) {
        this.clavealumnos = clavealumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
   
}