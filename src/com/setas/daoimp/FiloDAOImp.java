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
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(filo);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Filo> getFilo() {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Filo u order by filo");
		List<Filo> lista = (List<Filo>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public void modificarFilo(Filo filo) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().update(filo);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void eliminarFilo(Filo filo) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(filo);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public Filo recuperaFilo(String filo) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Filo u where filo=:filo");
		q.setParameter("filo", filo);
		Filo unFilo = (Filo) q.getSingleResult();
		sf.getCurrentSession().getTransaction().commit();
		return unFilo;
	}

}
