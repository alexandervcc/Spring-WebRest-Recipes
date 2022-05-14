/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.service;

import com.receta.Receta.entity.*;
import com.receta.Receta.repository.AmigoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Encapsuladas en un Servicio-> anadir la propiedad de ser transaccional
//@Service -> dentro del contexto Spring como un sevicio
@Service
//@transaction -> maneje las oepraciones a la db como transacciones -> ATOM
@Transactional
public class AmigoService {
    
	//@AUTOWIRED: inyeccion de dependecias -> Spring te configura elk objecto y entraga listo para ser usado
    @Autowired
    AmigoRepository amigoRepository;
    
    
    //Funciones a ser utilizadas en el contexto transaccional
    public void save(Amigo amigo){
        amigoRepository.save(amigo);
    }

    public List<Amigo> ObtenerAmigos(Integer idUsuario1){
        return amigoRepository.findByIdUsuarioPrimero(idUsuario1);
    }
}
