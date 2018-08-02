package com.setas.service;

import java.util.List;

import com.setas.dao.OrdenDAO;
import com.setas.modelo.Clase;
import com.setas.modelo.Orden;
import com.setas.util.DAOFactory;

public class ServiceOrdenImp implements ServiceOrden {
	OrdenDAO od = DAOFactory.getSingleton().getOrden();
	
	@Override
	public void insertarOrden(Orden orden) {
		od.insertarOrden(orden);
	}

	@Override
	public List<Orden> getOrden() {
		return od.getOrden();
	}

	@Override
	public List<Orden> getOrdenClase(Clase clase) {
		return od.getOrdenClase(clase);
	}

	@Override
	public void modificarOrden(Orden orden) {
		od.modificarOrden(orden);
	}

	@Override
	public void eliminarOrden(Orden orden) {
		od.eliminarOrden(orden);
	}

	@Override
	public Orden recuperaOrden(String orden) {
		return od.recuperaOrden(orden);
	}

}
