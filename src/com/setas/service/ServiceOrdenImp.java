package com.setas.service;

import java.util.List;

import com.setas.dao.OrdenDAO;
import com.setas.modelo.Orden;
import com.setas.modelo.Subclase;
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
	public List<Orden> getOrdenSubclase(Subclase subclase) {
		return od.getOrdenSubclase(subclase);
	}

	@Override
	public void modificarOrden(Orden orden) {
		od.modificarOrden(orden);
	}

	@Override
	public void eliminarOrden(Orden orden) {
		od.eliminarOrden(orden);
	}

}
