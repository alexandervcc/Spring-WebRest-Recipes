/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "paso")
public class Paso {

    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  
    
    @NotNull
    private int idReceta;
    
    @NotNull
    private String descripcion;
    
    @NotNull
    private int orden;
    
    @NotNull
    private Date fechaCreacion;    
    
    public Paso(){
        this.fechaCreacion = Date.valueOf(LocalDate.now());
        
    }
}
