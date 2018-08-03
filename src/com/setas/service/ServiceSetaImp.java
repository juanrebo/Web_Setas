package com.setas.service;

import java.util.List;

import com.setas.dao.SetaDAO;
import com.setas.modelo.Genero;
import com.setas.modelo.Seta;
import com.setas.util.DAOFactory;

public class ServiceSetaImp implements ServiceSeta {
	SetaDAO sd = DAOFactory.getSingleton().getSeta();
	
	@Override
	public void insertarSeta(Seta seta) {
		sd.insertarSeta(seta);
	}

	@Override
	public List<Seta> getSeta() {
		return sd.getSeta();
	}

	@Override
	public List<Seta> getSetaGenero(Genero genero) {
		return sd.getSetaGenero(genero);
	}

	@Override
	public void modificarSeta(Seta seta) {
		sd.modificarSeta(seta);
	}

	@Override
	public void eliminarSeta(Seta seta) {
		sd.eliminarSeta(seta);
	}

	@Override
	public Seta recuperaSeta(String genero, String especie) {
		return sd.recuperaSeta(genero, especie);
	}

}
