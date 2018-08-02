package com.setas.service;

import java.util.List;

import com.setas.dao.GeneroDAO;
import com.setas.modelo.Familia;
import com.setas.modelo.Genero;
import com.setas.util.DAOFactory;

public class ServiceGeneroImp implements ServiceGenero {
	GeneroDAO gd = DAOFactory.getSingleton().getGenero();
	
	@Override
	public void insertarGenero(Genero genero) {
		gd.insertarGenero(genero);
	}

	@Override
	public List<Genero> getGenero() {
		return gd.getGenero();
	}

	@Override
	public List<Genero> getGeneroFamilia(Familia familia) {
		return gd.getGeneroFamilia(familia);
	}

	@Override
	public void modificarGenero(Genero genero) {
		gd.modificarGenero(genero);
	}

	@Override
	public void eliminarGenero(Genero genero) {
		gd.eliminarGenero(genero);
	}

	@Override
	public Genero recuperaGenero(String genero) {
		return gd.recuperaGenero(genero);
	}

}
