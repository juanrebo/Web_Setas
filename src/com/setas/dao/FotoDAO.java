package com.setas.dao;

import java.util.List;

import com.setas.modelo.Foto;
import com.setas.modelo.Seta;

public interface FotoDAO {
	public void insertarFoto(Foto foto);
	public void eliminarFoto(Foto foto);
	public void modificarFoto(Foto foto);
	public List<Foto> recuperaFoto(Seta seta);
}
