package com.setas.service;

import java.util.List;

import com.setas.modelo.Filo;

public interface ServiceFilo {
	public void insertarFilo(Filo filo);
	public List<Filo> getFilo();
	public void modificarFilo(Filo filo);
	public void eliminarFilo(Filo filo);
	public Filo recuperaFilo(String filo);
}
