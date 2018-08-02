package com.setas.dao;

import java.util.List;

import com.setas.modelo.Clase;
import com.setas.modelo.Filo;

public interface ClaseDAO {
	public void insertarClase(Clase clase);
	public List<Clase> getClase();
	public List<Clase> getClaseFilo(Filo filo);
	public void modificarClase(Clase clase);
	public void eliminarClase(Clase clase);
	public Clase recuperaClase(String clase);
}
