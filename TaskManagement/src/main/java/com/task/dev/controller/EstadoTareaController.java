package com.task.dev.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.task.dev.model.EstadoTarea;
import com.task.dev.service.EstadoTareaService;

import java.util.List;

@RestController
@RequestMapping("/api/estado-tareas")
public class EstadoTareaController {

    @Autowired
    private EstadoTareaService estadoTareaService;

    @GetMapping
    public List<EstadoTarea> getAllEstadoTareas() {
        return estadoTareaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoTarea> getEstadoTareaById(@PathVariable Long id) {
        EstadoTarea estadoTarea = estadoTareaService.findById(id);
        if (estadoTarea == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estadoTarea);
    }

    @PostMapping
    public EstadoTarea createEstadoTarea(@RequestBody EstadoTarea estadoTarea) {
        return estadoTareaService.save(estadoTarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoTarea> updateEstadoTarea(@PathVariable Long id, @RequestBody EstadoTarea estadoTareaDetails) {
        EstadoTarea estadoTarea = estadoTareaService.findById(id);
        if (estadoTarea == null) {
            return ResponseEntity.notFound().build();
        }
        estadoTarea.setNombre(estadoTareaDetails.getNombre());

        EstadoTarea updatedEstadoTarea = estadoTareaService.save(estadoTarea);
        return ResponseEntity.ok(updatedEstadoTarea);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoTarea(@PathVariable Long id) {
        EstadoTarea estadoTarea = estadoTareaService.findById(id);
        if (estadoTarea == null) {
            return ResponseEntity.notFound().build();
        }
        estadoTareaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
