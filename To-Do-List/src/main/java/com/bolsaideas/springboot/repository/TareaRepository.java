package com.bolsaideas.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bolsaideas.springboot.models.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long>{
	
	List<Tarea> findByUsuarioId(Long usuarioId);
	
	
}
