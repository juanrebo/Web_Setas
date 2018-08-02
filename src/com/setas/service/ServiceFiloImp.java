package com.setas.service;

import java.util.List;

import com.setas.dao.FiloDAO;
import com.setas.modelo.Filo;
import com.setas.util.DAOFactory;

public class ServiceFiloImp implements ServiceFilo {
	FiloDAO dd = DAOFactory.getSingleton().getFilo();
	
	@Override
	public void insertarFilo(Filo filo) {
		dd.insertarFilo(filo);
	}

	@Override
	public List<Filo> getFilo() {
		return dd.getFilo();
	}

	@Override
	public void modificarFilo(Filo filo) {
		dd.modificarFilo(filo);
	}

	@Override
	public void eliminarFilo(Filo filo) {
		dd.eliminarFilo(filo);
	}

	@Override
	public Filo recuperaFilo(String filo) {
		return dd.recuperaFilo(filo);
	}

}
