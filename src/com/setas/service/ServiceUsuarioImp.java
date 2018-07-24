package com.setas.service;

import com.setas.dao.UsuarioDAO;
import com.setas.modelo.Usuario;
import com.setas.util.DAOFactory;

public class ServiceUsuarioImp implements ServiceUsuario {
	UsuarioDAO ud = DAOFactory.getSingleton().getUsuario();
	
	@Override
	public void insertarUsuario(Usuario usuario) {
		ud.insertarUsuario(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		ud.modificarUsuario(usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		ud.eliminarUsuario(usuario);
	}

	@Override
	public Usuario obtenerUsuario(String nombre) {
		return ud.obtenerUsuario(nombre);
	}

}
