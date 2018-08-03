package com.setas.service;

import java.util.List;

import com.setas.modelo.Genero;
import com.setas.modelo.Seta;

public interface ServiceSeta {
	public void insertarSeta(Seta seta);
	public List<Seta> getSeta();
	public List<Seta> getSetaGenero(Genero genero);
	public void modificarSeta(Seta seta);
	public void eliminarSeta(Seta seta);
	public Seta recuperaSeta(String genero, String especie);
}
