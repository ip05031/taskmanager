package com.task.dev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.task.dev.model.EstadoTarea;
import com.task.dev.model.Tarea;
import com.task.dev.model.Usuario;
import com.task.dev.repository.EstadoTareaRepository;
import com.task.dev.repository.TareaRepository;
import com.task.dev.repository.UsuarioRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private EstadoTareaRepository estadoTareaRepository;
    
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insertar usuarios
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Usuario1");
        usuario1.setUsuario("usuario1");
        usuario1.setContraseña("contraseña1");
        usuario1.setEmail("usuario1@example.com");
        usuario1.setEstado("activo");
        usuarioRepository.save(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Usuario2");
        usuario2.setUsuario("usuario2");
        usuario2.setContraseña("contraseña2");
        usuario2.setEmail("usuario2@example.com");
        usuario2.setEstado("activo");
        usuarioRepository.save(usuario2);

        Usuario usuario3 = new Usuario();
        usuario3.setNombre("Usuario3");
        usuario3.setUsuario("usuario3");
        usuario3.setContraseña("contraseña3");
        usuario3.setEmail("usuario3@example.com");
        usuario3.setEstado("activo");
        usuarioRepository.save(usuario3);
        
        // Insertar estados
        EstadoTarea estado1 = new EstadoTarea();
        estado1.setNombre("Activa");
        estadoTareaRepository.save(estado1);
        
        EstadoTarea estado2 = new EstadoTarea();
        estado2.setNombre("En Proceso");
        estadoTareaRepository.save(estado2);
        
        EstadoTarea estado3 = new EstadoTarea();
        estado3.setNombre("Finalizada");
        estadoTareaRepository.save(estado3);
        
        // Insertar tareas
        
        Tarea tarea1 = new Tarea();
        tarea1.setDescripcion("Definir objetivos");
        tarea1.setUsuario(usuario1);
        tarea1.setEstado(estado2);
        tareaRepository.save(tarea1);

        Tarea tarea2 = new Tarea();
        tarea2.setDescripcion("Definir historias de usuario");
        tarea2.setUsuario(usuario1);
        tarea2.setEstado(estado1);
        tareaRepository.save(tarea2);
        
        Tarea tarea3 = new Tarea();
        tarea3.setDescripcion("Hacer Inception");
        tarea3.setUsuario(usuario1);
        tarea3.setEstado(estado3);
        tareaRepository.save(tarea3);
        
    }
}

