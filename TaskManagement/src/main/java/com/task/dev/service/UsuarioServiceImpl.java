package com.task.dev.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dev.model.Usuario;
import com.task.dev.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAll() {
        return usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
	}

   
}
