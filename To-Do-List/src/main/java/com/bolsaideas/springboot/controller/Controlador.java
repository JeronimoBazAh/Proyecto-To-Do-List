package com.bolsaideas.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bolsaideas.springboot.models.Tarea;
import com.bolsaideas.springboot.service.TareaService;

@RestController
@RequestMapping
public class Controlador {
	
	private TareaService tareaService;
	
	@GetMapping
	public List<Tarea> obtenerTodas(){
		return tareaService.obtenerTodas();
	}
	
	@GetMapping("/{id}")
	public List<Tarea> obtenerPorId(@PathVariable Long id){
		Optional<Tarea> tarea = tareaService.obtenerPorId(id);
		return (List<Tarea>) tarea.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());	}

	
	@PostMapping
	public Tarea crearTarea(@RequestBody Tarea tarea) {
		return tareaService.crearTarea(tarea);
	}
	
	
	@DeleteMapping("/{id}")
	 public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
	     tareaService.eliminarTarea(id);
	     return ResponseEntity.noContent().build();
	     
	     
	 }
	
}
