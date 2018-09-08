package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.FamiliaDAO;
import com.setas.modelo.Familia;
import com.setas.modelo.Orden;

public class FamiliaDAOImp implements FamiliaDAO {
	SessionFactory sf;
	
	public FamiliaDAOImp(SessionFactory sf){
		this.sf = sf;
	}
	
	@Override
	public void insertarFamilia(Familia familia) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().save(familia);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Familia> getFamilia() {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Familia u order by familia");
			List<Familia> lista = (List<Familia>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return lista;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Familia> getFamiliaOrden(Orden orden) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Familia u where idorden=:idorden order by familia");
			q.setParameter("idorden", orden.getIdorden().toString());
			List<Familia> lista = (List<Familia>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return lista;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void modificarFamilia(Familia familia) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().update(familia);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void eliminarFamilia(Familia familia) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(familia);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public Familia recuperaFamilia(String familia) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Familia u where familia=:familia");
			q.setParameter("familia", familia);
			Familia unaFamilia = (Familia) q.getSingleResult();
			unaFamilia.getOrden();
			sf.getCurrentSession().getTransaction().commit();
			return unaFamilia;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
}
