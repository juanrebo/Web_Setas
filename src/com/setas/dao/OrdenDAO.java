package com.setas.dao;

import java.util.List;

import com.setas.modelo.Orden;
import com.setas.modelo.Subclase;

public interface OrdenDAO {
	public void insertarOrden(Orden orden);
	public List<Orden> getOrden();
	public List<Orden> getOrdenSubclase(Subclase subclase);
	public void modificarOrden(Orden orden);
	public void eliminarOrden(Orden orden);
}
