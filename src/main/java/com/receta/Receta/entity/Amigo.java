/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.entity;

import com.sun.istack.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//anotacion de entidad -> clase que se mapea con las tablas de la db
@Entity
//@table -> darle el nombre de la tabla
@Table(name = "amigo")
public class Amigo {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idUsuarioPrimero
     */
    public int getIdUsuarioPrimero() {
        return idUsuarioPrimero;
    }

    /**
     * @param idUsuarioPrimero the idUsuarioPrimero to set
     */
    public void setIdUsuarioPrimero(int idUsuarioPrimero) {
        this.idUsuarioPrimero = idUsuarioPrimero;
    }

    /**
     * @return the idUsuarioSegundo
     */
    public int getIdUsuarioSegundo() {
        return idUsuarioSegundo;
    }

    /**
     * @param idUsuarioSegundo the idUsuarioSegundo to set
     */
    public void setIdUsuarioSegundo(int idUsuarioSegundo) {
        this.idUsuarioSegundo = idUsuarioSegundo;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }




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
