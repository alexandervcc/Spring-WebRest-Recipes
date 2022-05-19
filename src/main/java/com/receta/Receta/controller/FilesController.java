package com.receta.Receta.controller;

import com.receta.Receta.dto.Respuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos/")
public class FilesController {
	
	@PostMapping("/new")
	public ResponseEntity<?> uploadVideo() {
		Respuesta respuesta;
		respuesta = new Respuesta("ok", "", null);
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
	
	@GetMapping("/download")
	public ResponseEntity<?> downloadVideo(@RequestParam("video") String video) {
		Respuesta respuesta;
		respuesta = new Respuesta("ok", "", null);
		return new ResponseEntity<Respuesta>(respuesta, HttpStatus.OK);
	}
}
