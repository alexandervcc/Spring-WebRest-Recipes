/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.entity;

import com.receta.Receta.enums.*;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    
    @NotNull
    private String Nombre;
    
    @NotNull
    private String Apellidos;

    @Column(columnDefinition = "ENUM('HOMBRE', 'MUJER')")
    @Enumerated(EnumType.STRING)
    private Sexo Sexo;

    @NotNull
    private Integer Telefono;


    @Email(message = "Formato de email invalido")
    @NotNull
    private String email;
    
    @NotNull
    private String Contrasena;

    @NotNull
    private Boolean enabled;

    @NotNull
    @Column(columnDefinition = "ENUM('ROLE_ADMIN', 'ROLE_USER')")
    @Enumerated(EnumType.STRING)
    private Rol role;

    @ManyToMany
    @JoinTable(
        name = "map_user_recetas",
        joinColumns = @JoinColumn(name="fk_id_user"),
        inverseJoinColumns = @JoinColumn(name = "fk_id_receta")
    )
    private Set<Receta> listaRecetas;

}
