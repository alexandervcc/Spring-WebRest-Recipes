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
import java.util.Set;
import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "receta")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    @ManyToMany(mappedBy = "listaRecetas")
    private Set<User> users;
    
    public Receta(){        
        this.fechaCreacion = Date.valueOf(LocalDate.now());
    }
    
    public Receta(String nombre, String url){
        this.nombre = nombre;
        this.url = url;
        this.fechaCreacion = Date.valueOf(LocalDate.now());
    }
}
