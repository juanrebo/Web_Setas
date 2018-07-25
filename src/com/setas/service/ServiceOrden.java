package com.setas.service;

import java.util.List;

import com.setas.modelo.Orden;
import com.setas.modelo.Subclase;

public interface ServiceOrden {
	public void insertarOrden(Orden orden);
	public List<Orden> getOrden();
	public List<Orden> getOrdenSubclase(Subclase subclase);
	public void modificarOrden(Orden orden);
	public void eliminarOrden(Orden orden);
}
