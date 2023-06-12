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
@Table(name = "materia")
public class Materia {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long clavemateria;

    @Column(name="nombre")
    String nombre;
    
    @Column(name="credito")
    String credito;

    public Long getClavemateria() {
        return clavemateria;
    }

    public void setClavemateria(Long clavemateria) {
        this.clavemateria = clavemateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }
    
    
}
