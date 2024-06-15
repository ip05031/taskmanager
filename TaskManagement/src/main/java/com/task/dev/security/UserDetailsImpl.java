package com.task.dev.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.task.dev.model.Usuario;


public class UserDetailsImpl implements UserDetails {

	
	
	public UserDetailsImpl(Usuario usuario) {
		this.usuario = usuario;
	}

	private final Usuario usuario;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public String getPassword() {
		return usuario.getContraseña();
	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}

	
	public String getNombre() {
		return usuario.getNombre();
	}
}
