/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.entity;

import com.receta.Receta.enums.*;
import com.sun.istack.NotNull;
import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public Sexo getSexo() {
        return Sexo;
    }

    public void setSexo(Sexo Sexo) {
        this.Sexo = Sexo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    @Id
    //Se le indica que el campo ID es Autonumerico
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    public int id;
    
    @NotNull
    public String Nombre;
    
    @NotNull
    public String Apellidos;    
    
    //columnDefinition -> 'HOMBRE' o 'MUJER'
    @Column(columnDefinition = "ENUM('HOMBRE', 'MUJER')")
    @Enumerated(EnumType.STRING)
    public Sexo Sexo;        

    @NotNull
    public int Telefono;
    
    @Column(name="Email")
    @NotNull
    public String email;    
    
    @NotNull
    public String Contrasena;
    
    public User(String nombre, String apellidos, Sexo sexo, int telefono, String email, String contrasena){
        this.Nombre = nombre;
        this.Apellidos = apellidos;
        this.Sexo = sexo;
        this.Telefono = telefono;
        this.email = email;
        this.Contrasena = contrasena;
    }
    
    public User(){
        
    }
}
