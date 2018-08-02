package com.setas.service;

import java.util.List;

import com.setas.dao.FamiliaDAO;
import com.setas.modelo.Familia;
import com.setas.modelo.Orden;
import com.setas.util.DAOFactory;

public class ServiceFamiliaImp implements ServiceFamilia {
	FamiliaDAO fd = DAOFactory.getSingleton().getFamilia();
	
	@Override
	public void insertarFamilia(Familia familia) {
		fd.insertarFamilia(familia);
	}

	@Override
	public List<Familia> getFamilia() {
		return fd.getFamilia();
	}

	@Override
	public List<Familia> getFamiliaOrden(Orden orden) {
		return fd.getFamiliaOrden(orden);
	}

	@Override
	public void modificarFamilia(Familia familia) {
		fd.modificarFamilia(familia);
	}

	@Override
	public void eliminarFamilia(Familia familia) {
		fd.eliminarFamilia(familia);
	}

	@Override
	public Familia recuperaFamilia(String familia) {
		return fd.recuperaFamilia(familia);
	}

}
