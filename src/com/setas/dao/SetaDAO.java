package com.setas.dao;

import java.util.List;

import com.setas.modelo.Seta;

public interface SetaDAO {
	public void insertarSeta(Seta seta);
	public List<Seta> getSeta();
	public void modificarSeta(Seta seta);
	public void eliminarSeta(Seta seta);
}
