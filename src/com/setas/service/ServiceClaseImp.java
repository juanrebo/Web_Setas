package com.setas.service;

import java.util.List;

import com.setas.dao.ClaseDAO;
import com.setas.modelo.Clase;
import com.setas.modelo.Filo;
import com.setas.util.DAOFactory;

public class ServiceClaseImp implements ServiceClase {
	ClaseDAO cd = DAOFactory.getSingleton().getClase();
	
	@Override
	public void insertarClase(Clase clase) {
		cd.insertarClase(clase);
	}

	@Override
	public List<Clase> getClase() {
		return cd.getClase();
	}

	@Override
	public List<Clase> getClaseFilo(Filo filo) {
		return cd.getClaseFilo(filo);
	}

	@Override
	public void modificarClase(Clase clase) {
		cd.modificarClase(clase);
	}

	@Override
	public void eliminarClase(Clase clase) {
		cd.eliminarClase(clase);
	}

	@Override
	public Clase recuperaClase(String clase) {
		return cd.recuperaClase(clase);
	}

}
