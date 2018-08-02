package com.setas.service;

import java.util.List;

import com.setas.modelo.Familia;
import com.setas.modelo.Genero;

public interface ServiceGenero {
	public void insertarGenero(Genero genero);
	public List<Genero> getGenero();
	public List<Genero> getGeneroFamilia(Familia familia);
	public void modificarGenero(Genero genero);
	public void eliminarGenero(Genero genero);
	public Genero recuperaGenero(String genero);
}
