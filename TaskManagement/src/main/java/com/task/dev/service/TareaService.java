package com.task.dev.service;


import java.util.List;

import com.task.dev.model.Tarea;

public interface TareaService {
    List<Tarea> findAll();
    Tarea findById(Long id);
    Tarea save(Tarea tarea);
    void deleteById(Long id);
    List<Tarea> getTareasByUsuarioAndEstado(Long usuarioId, Long estadoId);
    List<Tarea> getTareasByUsuario(Long usuarioId);

}
