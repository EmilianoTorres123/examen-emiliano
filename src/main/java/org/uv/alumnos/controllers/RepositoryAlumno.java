/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.alumnos.controllers;

import org.springframework.data.jpa.repository.JpaRepository;




/**
 *
 * @author aaron-emiliano
 */
public interface RepositoryAlumno extends JpaRepository<Alumnos, Long> {
    
}
