package com.task.dev.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dev.model.EstadoTarea;
import com.task.dev.repository.EstadoTareaRepository;

import java.util.List;

@Service
public class EstadoTareaServiceImpl implements EstadoTareaService {

    @Autowired
    private EstadoTareaRepository estadoTareaRepository;

	@Override
	public List<EstadoTarea> findAll() {
        return estadoTareaRepository.findAll();

	}

	@Override
	public EstadoTarea findById(Long id) {
        return estadoTareaRepository.findById(id).orElse(null);

	}

	@Override
	public EstadoTarea save(EstadoTarea estadoTarea) {
        return estadoTareaRepository.save(estadoTarea);

	}

	@Override
	public void deleteById(Long id) {
        estadoTareaRepository.deleteById(id);
	}

}