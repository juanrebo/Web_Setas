package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.ClaseDAO;
import com.setas.modelo.Clase;
import com.setas.modelo.Filo;
import com.setas.modelo.Orden;

public class ClaseDAOImp implements ClaseDAO {
	SessionFactory sf;
	
	public ClaseDAOImp(SessionFactory sf){
		this.sf = sf;
	}
	
	@Override
	public void insertarClase(Clase clase) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().save(clase);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Clase> getClase() {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Clase u order by clase");
			List<Clase> lista = (List<Clase>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return lista;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Clase> getClaseFilo(Filo filo) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Clase u where idfilo=:idfilo order by clase");
			q.setParameter("idfilo", filo.getIdfilo().toString());
			List<Clase> lista = (List<Clase>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return lista;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void modificarClase(Clase clase) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().update(clase);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void eliminarClase(Clase clase) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(clase);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
	@Override
	public Clase recuperaClase(String clase) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Clase u where clase=:clase");
			q.setParameter("clase", clase);
			Clase unClase = (Clase) q.getSingleResult();
			unClase.getClase();
			sf.getCurrentSession().getTransaction().commit();
			return unClase;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

}
