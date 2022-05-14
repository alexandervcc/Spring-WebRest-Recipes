/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.receta.Receta.controller;

import com.receta.Receta.dto.ItemRecetaDTO;
import com.receta.Receta.dto.RecetaDTO;
import com.receta.Receta.dto.Respuesta;
import com.receta.Receta.entity.*;
import com.receta.Receta.service.*;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecetaController {

    @Autowired
    RecetaService recetaService;

    @Autowired
    IngredienteService ingredienteService;

    @Autowired
    PasoService pasoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/crearReceta")
    public ResponseEntity<?> CrearReceta(@RequestBody RecetaDTO recetaDTO) {

        Respuesta respuesta;
        try {
        	//Mapear el contenido del DTO recibido en un objeto Receta
            Receta receta = modelMapper.map(recetaDTO, Receta.class);
            //guarda en la db
            recetaService.save(receta);

            //Obtener la lsita de ingredientes -> map() sobre la lista de ingredientes en el DTO
            //Mapping a objetos Ingrediente 
            List<Ingrediente> ingredientes = recetaDTO.getIngredientes().stream()
                    .map(ingrediente -> modelMapper.map(ingrediente, Ingrediente.class))
                    .collect(Collectors.toList());

            //Almacenar la lista de Ingedientes en la base de datos, con el ID de la receta
            ingredienteService.saveAll(ingredientes, receta.getId());

            //Obtener la lsita de pasos -> map() sobre la lista del DTO
            //Mapping a objetos PAso
            List<Paso> pasos = recetaDTO.getPasos().stream()
                    .map(paso -> modelMapper.map(paso, Paso.class))
                    .collect(Collectors.toList());

            //Almaceno en la db, con el Identificar de la receta que le corresponde
            pasoService.saveAll(pasos, receta.getId());

            //Exitoso, devuelve el resultado
            respuesta = new Respuesta("ok", "", null);

            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        } catch (Exception oex) {
        	//devuelve mensaje de error
            respuesta = new Respuesta("error", "Se ha producido un error al crear la receta", null);
            return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
        }
    }

    @RequestMapping("/recetas")
    public ResponseEntity<?> Recetas() {

        List<Receta> recetas = recetaService.obtenerTodasRecetas();

        List<ItemRecetaDTO> recetasDTO = recetas.stream()
                .map(receta -> modelMapper.map(receta, ItemRecetaDTO.class))
                .collect(Collectors.toList());

        Respuesta respuesta = new Respuesta("ok", "", recetasDTO);

        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    @RequestMapping("/buscarReceta")
    public ResponseEntity<?> BuscarReceta(String palabra) {

        List<Receta> recetasEncontradas = recetaService.obtenerRecetaByPalabra(palabra);

        List<Ingrediente> ingredientesEncontrados = ingredienteService.obtenerIngredientesByPalabra(palabra);

        List<Integer> idsReceta = ingredientesEncontrados.stream().map(Ingrediente::getIdReceta).collect(Collectors.toList());;

        List<Receta> recetasEncontradasByIngrediente = recetaService.obtenerRecetasByIds(idsReceta);

        recetasEncontradas.addAll(recetasEncontradasByIngrediente);

        List<Receta> totalRecetasEncontradas = recetasEncontradas.stream()
                .distinct()
                .collect(Collectors.toList());

        Respuesta respuesta = new Respuesta("ok", "", totalRecetasEncontradas);

        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    @RequestMapping("/receta")
    public ResponseEntity<?> ObtenerReceta(Integer id) {
        Receta receta = recetaService.obtenerRecetaById(id);
        Respuesta respuesta = new Respuesta("ok", "", receta);

        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    @RequestMapping("/ingredientes")
    public ResponseEntity<?> ObtenerIngredientesByReceta(Integer idReceta) {
        List<Ingrediente> ingredientes = ingredienteService.obtenerIngredientesByIdReceta(idReceta);
        Respuesta respuesta = new Respuesta("ok", "", ingredientes);

        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    @RequestMapping("/pasos")
    public ResponseEntity<?> ObtenerPasosByReceta(Integer idReceta) {
        List<Paso> pasos = pasoService.obtenerPasosByIdReceta(idReceta);
        Respuesta respuesta = new Respuesta("ok", "", pasos);

        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

}
