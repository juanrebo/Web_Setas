package com.setas.service;

import java.util.List;

import com.setas.modelo.Clase;
import com.setas.modelo.Subdivision;

public interface ServiceClase {
	public void insertarClase(Clase clase);
	public List<Clase> getClase();
	public List<Clase> getClaseSubdivison(Subdivision subdivision);
	public void modificarClase(Clase clase);
	public void eliminarClase(Clase clase);
}
