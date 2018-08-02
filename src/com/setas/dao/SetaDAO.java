package com.setas.dao;

import java.util.List;

import com.setas.modelo.Familia;
import com.setas.modelo.Seta;

public interface SetaDAO {
	public void insertarSeta(Seta seta);
	public List<Seta> getSeta();
	public List<Seta> getSetaFamilia(Familia familia);
	public List<Seta> getSetaGenero(String genero);
	public void modificarSeta(Seta seta);
	public void eliminarSeta(Seta seta);
	public Seta recuperaSeta(String genero, String especie);
}
