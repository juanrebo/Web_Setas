package com.setas.service;

import java.util.List;

import com.setas.modelo.Foto;

public interface ServiceFoto {
	public void insertarFoto(Foto foto);
	public void eliminarFoto(Foto foto);
	public void modificarFoto(Foto foto);
	public List<Foto> recuperaFoto(int idseta);
}
