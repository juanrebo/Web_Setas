package com.setas.daoimp;

import org.hibernate.SessionFactory;

import com.setas.dao.NombreDAO;
import com.setas.modelo.Nombre;

public class NombreDAOImp implements NombreDAO {
	SessionFactory sf;
	
	public NombreDAOImp (SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insertarNombre(Nombre nombre) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().save(nombre);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void eliminarNombre(Nombre nombre) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(nombre);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
}
