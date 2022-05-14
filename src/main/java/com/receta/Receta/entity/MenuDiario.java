/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.entity;

import com.receta.Receta.enums.Dias;
import com.receta.Receta.enums.TipoComida;
import com.sun.istack.NotNull;
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

@Entity(name = "menudiario")
@Table(name = "menudiario")
public class MenuDiario {

    /**
     * @return the id_menusemanal
     */
    public int getId_menusemanal() {
        return id_menusemanal;
    }

    /**
     * @param id_menusemanal the id_menusemanal to set
     */
    public void setId_menusemanal(int id_menusemanal) {
        this.id_menusemanal = id_menusemanal;
    }

    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the id_receta
     */
    public int getId_receta() {
        return id_receta;
    }

    /**
     * @param id_receta the id_receta to set
     */
    public void setId_receta(int id_receta) {
        this.id_receta = id_receta;
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
     * @return the dia
     */
    public Dias getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(Dias dia) {
        this.dia = dia;
    }

    /**
     * @return the tipo
     */
    public TipoComida getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoComida tipo) {
        this.tipo = tipo;
    }


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
    
    public MenuDiario(){
        
    }
}
