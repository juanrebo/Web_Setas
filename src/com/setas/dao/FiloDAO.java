package com.setas.dao;

import java.util.List;

import com.setas.modelo.Filo;

public interface FiloDAO {
	public void insertarFilo(Filo filo);
	public List<Filo> getFilo();
	public void modificarFilo(Filo filo);
	public void eliminarFilo(Filo filo);
	public Filo recuperaFilo(String filo);
}
