package com.setas.service;

import java.util.List;

import com.setas.dao.FavoritoDAO;
import com.setas.modelo.Favorito;
import com.setas.modelo.Usuario;
import com.setas.util.DAOFactory;

public class ServiceFavoritoImp implements ServiceFavorito {
	FavoritoDAO fd = DAOFactory.getSingleton().getFavorito();
	
	@Override
	public void insertarFavorito(Favorito favorito) {
		fd.insertarFavorito(favorito);
	}

	@Override
	public void eliminarFavorito(Favorito favorito) {
		fd.eliminarFavorito(favorito);
	}

	@Override
	public List<Favorito> recuperaFavoritos(Usuario usuario) {
		return fd.recuperaFavoritos(usuario);
	}

}
