/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.dto;

import com.receta.Receta.enums.Sexo;
import lombok.*;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    public String Nombre;
    public String Apellidos;
    public Sexo Sexo;
    public int Telefono;
    public String Email;
    public String Contrasena;
    public String SegundaContrasena;
    private String token;
    private int id;
}