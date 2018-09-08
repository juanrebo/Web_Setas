package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.FiloDAO;
import com.setas.modelo.Filo;

public class FiloDAOImp implements FiloDAO {
	SessionFactory sf;
	
	public FiloDAOImp(SessionFactory sf){
		this.sf = sf;
	}
	
	@Override
	public void insertarFilo(Filo filo) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().save(filo);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Filo> getFilo() {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Filo u order by filo");
			List<Filo> lista = (List<Filo>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return lista;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void modificarFilo(Filo filo) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().update(filo);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void eliminarFilo(Filo filo) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(filo);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public Filo recuperaFilo(String filo) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Filo u where filo=:filo");
			q.setParameter("filo", filo);
			Filo unFilo = (Filo) q.getSingleResult();
			sf.getCurrentSession().getTransaction().commit();
			return unFilo;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

}
