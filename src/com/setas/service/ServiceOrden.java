package com.setas.service;

import java.util.List;

import com.setas.modelo.Clase;
import com.setas.modelo.Orden;

public interface ServiceOrden {
	public void insertarOrden(Orden orden);
	public List<Orden> getOrden();
	public List<Orden> getOrdenClase(Clase clase);
	public void modificarOrden(Orden orden);
	public void eliminarOrden(Orden orden);
	public Orden recuperaOrden(String orden);
}
