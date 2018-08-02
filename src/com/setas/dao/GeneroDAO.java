package com.setas.dao;

import java.util.List;

import com.setas.modelo.Familia;
import com.setas.modelo.Genero;

public interface GeneroDAO {
	public void insertarGenero(Genero genero);
	public List<Genero> getGenero();
	public List<Genero> getGeneroFamilia(Familia familia);
	public void modificarGenero(Genero genero);
	public void eliminarGenero(Genero genero);
	public Genero recuperaGenero(String genero);
}
