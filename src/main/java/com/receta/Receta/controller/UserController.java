/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.controller;

import com.receta.Receta.dto.*;
import com.receta.Receta.entity.User;
import com.receta.Receta.service.UserService;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;

// -> Convierte en un Controlador tipo REST
@RestController
public class UserController {
	//inyectando el servicio para los usuarios
    @Autowired
    UserService userService;

    //@PostMapping | GetMapping | PutMapping -> ("PATH")
    //post /login
    @PostMapping("login")
    @SuppressWarnings("empty-statement")
    public ResponseEntity<?> login(
    		@RequestBody UserDto userDto
    ) {
    	//@RequestBody -> acceder o recibir datos desde el body 

    	//obtener desde la db un usuario a partir del correo en el dto
        User userBBDD = userService.obtenerUsuarioByEmail(userDto.Email);
        
        Respuesta respuesta;
        //Si el resultado de la busqyeda en db es null -> no existe el usuario
        if (userBBDD == null) {
        	//Se envia esta respuesta al cliente
            respuesta = new Respuesta("error", "No existe el usuario o contraseña incorrecta", null);
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        }

        //Si existe el Usuario
        //Obtener un objecto de encriptacion de contrasenas -> Viene dentro de framework seguridad
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        //Verificar que mi contrasen enviada es igual a la de la db
        Boolean resultado = b.matches(userDto.Contrasena, userBBDD.Contrasena);

        //Si no son las mismas
        if (!resultado) {
        	//Envia un mensaje de error de usuairo o contrasena
            respuesta = new Respuesta("error", "No existe el usuario o contraseña incorrecta", null);
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        }

        //Ejecutamos funcion para la generacion del JWT
        String token = getJWTToken(userDto.Email);
        //Creamos un DTO para la respuesta
        UserDto user = new UserDto();
        //Configuramos el DTO para enviarlo
        user.setNombre(userBBDD.getNombre());
        user.setApellidos(userBBDD.getApellidos());
        user.setSexo(userBBDD.getSexo());
        user.setTelefono(userBBDD.getTelefono());
        user.setEmail(userDto.Email);
        user.setToken(token);
        user.setId(userBBDD.getId());
        
        respuesta = new Respuesta("ok", "", user);
        
        //Devolvemos la respuesta al cliente
        return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
    }

    //POST /registerUser
    @PostMapping("/registerUser")
    public ResponseEntity<?> Register(@RequestBody UserDto userDto) {
        Respuesta respuesta;
        //obtener el usuario desde la db
        User userBBDD = userService.obtenerUsuarioByEmail(userDto.Email);
        //Si el usuario no es null -> existe
        if (userBBDD != null) {
        	//respuesta de correo ya en uso
            respuesta = new Respuesta("error", "El usuario con email " + userDto.Email + " ya existe.", null);
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        }

        //creamos un encriptado de contrasenas
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //encriptar la contrasena
        String encodedPassword = passwordEncoder.encode(userDto.getContrasena());

        //Generamos un objecto usuario, y configuramos con los datos del body del post
        User user = new User(userDto.getNombre(),
                userDto.getApellidos(),
                userDto.getSexo(),
                userDto.getTelefono(),
                userDto.getEmail(),
                encodedPassword);

        //Guardo en la db
        userService.save(user);
        
        //Devuelvo una respuesta
        respuesta = new Respuesta("ok", "", null);
        return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
    }

    private String getJWTToken(String username) {
    	//Un string secreto
        String secretKey = "mySecretKey";
        //la damos en el JWT las autoridades o roles opara el presente usuario: role_user
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");//ADMINISTRADOR y AUDITORIA

        //Construccion del JWT
        String token = Jwts
                .builder()//patron builder para la construccion del objeto
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))//emision
                .setExpiration(new Date(System.currentTimeMillis() + 600000))//caducidad
                .signWith(SignatureAlgorithm.HS512, //hasheo
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
