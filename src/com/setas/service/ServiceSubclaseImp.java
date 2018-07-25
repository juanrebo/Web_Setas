package com.setas.service;

import java.util.List;

import com.setas.dao.SubclaseDAO;
import com.setas.modelo.Clase;
import com.setas.modelo.Subclase;
import com.setas.util.DAOFactory;

public class ServiceSubclaseImp implements ServiceSubclase {
	SubclaseDAO sd = DAOFactory.getSingleton().getSubclase();
	
	@Override
	public void insertarSubclase(Subclase subclase) {
		sd.insertarSubclase(subclase);
	}

	@Override
	public List<Subclase> getSubclase() {
		return sd.getSubclase();
	}

	@Override
	public List<Subclase> getSubclaseClase(Clase clase) {
		return sd.getSubclaseClase(clase);
	}

	@Override
	public void modificarSubclase(Subclase subclase) {
		sd.modificarSubclase(subclase);
	}

	@Override
	public void eliminarSubclase(Subclase subclase) {
		sd.eliminarSubclase(subclase);
	}

}
