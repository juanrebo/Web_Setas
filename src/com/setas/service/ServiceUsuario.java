package com.setas.service;

import com.setas.modelo.Usuario;

public interface ServiceUsuario {
	public void insertarUsuario(Usuario usuario);
	public void modificarUsuario(Usuario usuario);
	public void eliminarUsuario(Usuario usuario);
	public Usuario obtenerUsuario(String nombre);
}
