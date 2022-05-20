/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.entity;

import com.sun.istack.NotNull;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "amigo")
public class Amigo {
    //Atributos -> mapean con la base de datos
    
    //@id -> senalar un atributo como la clave primariva
    @Id    
    // -> definir la estrategia de generacion de los id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  
    
    //no puede ser null
    @NotNull   
    private int idUsuarioPrimero;
    
    @NotNull
    private int idUsuarioSegundo;
        
    @NotNull
    private Date fechaCreacion;        
    
    //constructor
    public Amigo(){
        this.fechaCreacion = Date.valueOf(LocalDate.now());
    }
}
