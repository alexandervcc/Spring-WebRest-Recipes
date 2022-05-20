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
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name="menusemanal")
@Table(name = "menusemanal")
public class MenuSemanal {


    @Id
    //Se le indica que el campo ID es Autonumerico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private Date fechaInicio;    
    
    @NotNull
    private Date fechaFin;
    
    @NotNull
    private Date fechaCreacion;
    
    @NotNull
    private int id_usuario;
        
    public MenuSemanal(){
        this.fechaCreacion = Date.valueOf(LocalDate.now());
    }
    
}
