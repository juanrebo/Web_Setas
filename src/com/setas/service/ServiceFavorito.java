package com.setas.service;

import java.util.List;

import com.setas.modelo.Favorito;
import com.setas.modelo.Usuario;

public interface ServiceFavorito {
	public void insertarFavorito(Favorito favorito);
	public void eliminarFavorito(Favorito favorito);
	public List<Favorito> recuperaFavoritos(Usuario usuario);
}
