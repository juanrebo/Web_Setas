package com.setas.service;

import com.setas.dao.RolDAO;
import com.setas.modelo.Rol;
import com.setas.modelo.Usuario;
import com.setas.util.DAOFactory;

public class ServiceRolImp implements ServiceRol {
	RolDAO rd = DAOFactory.getSingleton().getRol(); 
	
	@Override
	public Rol getRol(Usuario usuario) {
		return rd.getRol(usuario);
	}

	@Override
	public Rol getRol(int idRol) {
		return rd.getRol(idRol);
	}

}
