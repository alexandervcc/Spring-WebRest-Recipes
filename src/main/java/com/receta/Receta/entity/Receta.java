/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.entity;

import com.receta.Receta.enums.TipoComida;
import com.sun.istack.NotNull;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "receta")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String nombre;
    
    @NotNull
    private String url;    
    
    @NotNull
    private Date fechaCreacion;
    
    @Column(columnDefinition = "ENUM('DESAYUNO', 'COMIDA', 'CENA')")
    @Enumerated(EnumType.STRING)    
    private TipoComida tipo;

    private String pathVideo;
    
    public Receta(){        
        this.fechaCreacion = Date.valueOf(LocalDate.now());
    }
    
    public Receta(String nombre, String url){
        this.nombre = nombre;
        this.url = url;
        this.fechaCreacion = Date.valueOf(LocalDate.now());
    }
}
