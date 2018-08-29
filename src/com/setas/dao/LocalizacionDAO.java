package com.setas.dao;

import java.util.List;

import com.setas.modelo.Localizacion;
import com.setas.modelo.Seta;
import com.setas.modelo.Usuario;

public interface LocalizacionDAO {
	public void insertarLocalizacion(Localizacion localizacion);
	public void eliminarLocalizacion(Localizacion localizacion);
	public void modificarLocalizacion(Localizacion localizacion);
	public Localizacion recuperarLocalizacion(int idlocalizacion);
	public List<Localizacion> recuperarLocalizaUsu(Usuario usuario);
	public List<Localizacion> recuperarLocalizaSeta(Usuario usuario, Seta seta);
}
