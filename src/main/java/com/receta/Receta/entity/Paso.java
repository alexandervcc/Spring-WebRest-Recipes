/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.entity;

import com.sun.istack.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paso")
public class Paso {

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
     * @return the idReceta
     */
    public int getIdReceta() {
        return idReceta;
    }

    /**
     * @param idReceta the idReceta to set
     */
    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    /**
     * @return the nombre
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setDescripcion(String nombre) {
        this.descripcion = nombre;
    }

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
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
