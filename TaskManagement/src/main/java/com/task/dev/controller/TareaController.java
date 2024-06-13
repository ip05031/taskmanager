package com.task.dev.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.task.dev.model.Tarea;
import com.task.dev.service.TareaService;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable Long id) {
        Tarea tarea = tareaService.findById(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarea);
    }
    
    @GetMapping("/user/{usuarioId}/status/{estadoId}")
    public ResponseEntity<List<Tarea>> getTareasByUsuarioAndEstado(
            @PathVariable Long usuarioId,
            @PathVariable Long estadoId) {

        if (estadoId != 0 ) {
            List<Tarea> tareas = tareaService. getTareasByUsuarioAndEstado(usuarioId, estadoId);
            return new ResponseEntity<>(tareas, HttpStatus.OK);
        } else {
            List<Tarea> tareas = tareaService.getTareasByUsuario(usuarioId);
            return new ResponseEntity<>(tareas, HttpStatus.OK);
        }
    }

    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaService.save(tarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable Long id, @RequestBody Tarea tareaDetails) {
        Tarea tarea = tareaService.findById(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        tarea.setDescripcion(tareaDetails.getDescripcion());
        tarea.setEstado(tareaDetails.getEstado());

        Tarea updatedTarea = tareaService.save(tarea);
        return ResponseEntity.ok(updatedTarea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarea(@PathVariable Long id) {
        Tarea tarea = tareaService.findById(id);
        if (tarea == null) {
            return ResponseEntity.notFound().build();
        }
        tareaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
