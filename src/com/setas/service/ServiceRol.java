package com.setas.service;

import com.setas.modelo.Rol;
import com.setas.modelo.Usuario;

public interface ServiceRol {
	public Rol getRol(Usuario usuario);
	public Rol getRol(int idRol);
}
