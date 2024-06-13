package com.task.dev.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.dev.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
	
	   List<Tarea> findByUsuarioId(Long usuarioId);
	    List<Tarea> findByUsuarioIdAndEstadoId(Long usuarioId, Long estadoId);
}