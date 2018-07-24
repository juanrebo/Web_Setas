package com.setas.service;

import java.util.List;

import com.setas.modelo.Seta;

public interface ServiceSeta {
	public void insertarSeta(Seta seta);
	public List<Seta> getSeta();
	public void modificarSeta(Seta seta);
	public void eliminarSeta(Seta seta);
}
