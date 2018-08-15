package com.setas.service;

import java.util.List;

import com.setas.dao.LocalizacionDAO;
import com.setas.modelo.Localizacion;
import com.setas.modelo.Seta;
import com.setas.modelo.Usuario;
import com.setas.util.DAOFactory;

public class ServiceLocalizacionImp implements ServiceLocalizacion {
	LocalizacionDAO ld = DAOFactory.getSingleton().getLocalizacion();

	@Override
	public void insertarLocalizacion(Localizacion localizacion) {
		ld.insertarLocalizacion(localizacion);
	}

	@Override
	public void eliminarLocalizacion(Localizacion localizacion) {
		ld.eliminarLocalizacion(localizacion);
	}

	@Override
	public void modificarLocalizacion(Localizacion localizacion) {
		ld.modificarLocalizacion(localizacion);
	}

	@Override
	public List<Localizacion> recuperarLocalizaUsu(Usuario usuario) {
		return ld.recuperarLocalizaUsu(usuario);
	}

	@Override
	public List<Localizacion> recuperarLocalizaSeta(Usuario usuario, Seta seta) {
		return ld.recuperarLocalizaSeta(usuario, seta);
	}

}
