/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.service;

import com.receta.Receta.entity.*;
import com.receta.Receta.repository.PasoRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PasoService {
    
    @Autowired
    PasoRepository pasoRepository;
    
    public void saveAll(List<Paso> pasos, int idReceta){
        
        for(Paso paso : pasos){
            paso.setIdReceta(idReceta);
            pasoRepository.save(paso);
        }        
    }    
    
    public void save(Paso paso){
        pasoRepository.save(paso);
    }
    
    public List<Paso> obtenerPasosByIdReceta(Integer idReceta) {
        
        List<Paso> pasos = pasoRepository.findByIdReceta(idReceta);
        return pasos;
    }    
}
