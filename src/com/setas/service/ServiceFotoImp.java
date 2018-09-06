package com.setas.service;

import java.util.List;

import com.setas.dao.FotoDAO;
import com.setas.modelo.Foto;
import com.setas.modelo.Seta;
import com.setas.util.DAOFactory;

public class ServiceFotoImp implements ServiceFoto {
	FotoDAO fd = DAOFactory.getSingleton().getFoto();

	@Override
	public void insertarFoto(Foto foto) {
		fd.insertarFoto(foto);
	}

	@Override
	public void eliminarFoto(Foto foto) {
		fd.eliminarFoto(foto);
	}

	@Override
	public void modificarFoto(Foto foto) {
		fd.modificarFoto(foto);
	}

	@Override
	public List<Foto> recuperaFoto(Seta seta) {
		return fd.recuperaFoto(seta);
	}

}
