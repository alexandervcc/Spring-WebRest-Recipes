package com.receta.Receta;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecetaApplication {

   
    //Punto de arranque de la aplicacion
	public static void main(String[] args) {
		SpringApplication.run(RecetaApplication.class, args);
	}

	//Configuraciones adicionales
	@Bean
    ModelMapper modelMapper() {
            return new ModelMapper();
    }  
	
}
