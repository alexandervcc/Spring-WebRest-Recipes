/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.entity;

import com.receta.Receta.enums.Dias;
import com.receta.Receta.enums.TipoComida;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "menudiario")
@Table(name = "menudiario")
public class MenuDiario {

     @Id
    //Se le indica que el campo ID es Autonumerico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(columnDefinition = "ENUM('LUNES', 'MARTES', 'MIERCOLES', 'JUEVES', 'VIERNES')")
    @Enumerated(EnumType.STRING)    
    private Dias dia;

    @NotNull
    @Column(columnDefinition = "ENUM('DESAYUNO', 'COMIDA', 'CENA')")
    @Enumerated(EnumType.STRING)    
    private TipoComida tipo;

    @NotNull
    private int id_receta;
    
    @NotNull
    private int id_menusemanal;

    @NotNull
    private int id_usuario;
    
    @NotNull
    private Date fechaCreacion;      

}
