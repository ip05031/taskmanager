package com.task.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dev.model.Tarea;
import com.task.dev.repository.TareaRepository;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea findById(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public void deleteById(Long id) {
        tareaRepository.deleteById(id);
    }
    
    public List<Tarea> getTareasByUsuarioAndEstado(Long usuarioId, Long estadoId) {
        if (estadoId != null) {
            return tareaRepository.findByUsuarioIdAndEstadoId(usuarioId, estadoId);
        } else {
            return tareaRepository.findByUsuarioId(usuarioId);
        }
    }

    public List<Tarea> getTareasByUsuario(Long usuarioId) {
        return tareaRepository.findByUsuarioId(usuarioId);
    }

}
