package com.bolsaideas.springboot.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsaideas.springboot.models.Tarea;
import com.bolsaideas.springboot.repository.TareaRepository;

@Service
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;
	
	public List<Tarea> obtenerTodas(){
		return tareaRepository.findAll();
	}
	
	
	public Optional<Tarea> obtenerPorId(Long id){
		return tareaRepository.findById(id);
		
	}
	
	public Tarea crearTarea(Tarea tarea) {
		tarea.setFechaCreacion(LocalDateTime.now());
		
		return tareaRepository.save(tarea);
	}
	
	public void eliminarTarea(Long id) {
		
		tareaRepository.deleteById(id);
		
	}
	
	
}
