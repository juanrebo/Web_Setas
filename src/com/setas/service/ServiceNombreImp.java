package com.setas.service;

import com.setas.dao.NombreDAO;
import com.setas.modelo.Nombre;
import com.setas.util.DAOFactory;

public class ServiceNombreImp implements ServiceNombre {
	NombreDAO nd = DAOFactory.getSingleton().getNombre();
	
	@Override
	public void insertarNombre(Nombre nombre) {
		nd.insertarNombre(nombre);
	}

	@Override
	public void eliminarNombre(Nombre nombre) {
		nd.eliminarNombre(nombre);
	}

}
