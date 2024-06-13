package com.task.dev.service;

import java.util.List;

import com.task.dev.model.EstadoTarea;

public interface EstadoTareaService {
    List<EstadoTarea> findAll();
    EstadoTarea findById(Long id);
    EstadoTarea save(EstadoTarea estadoTarea);
    void deleteById(Long id);
}
