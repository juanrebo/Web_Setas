package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.GeneroDAO;
import com.setas.modelo.Familia;
import com.setas.modelo.Genero;

public class GeneroDAOImp implements GeneroDAO {
	SessionFactory sf;
	
	public GeneroDAOImp(SessionFactory sf){
		this.sf = sf;
	}
	@Override
	public void insertarGenero(Genero genero) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(genero);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Genero> getGenero() {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Genero u order by genero");
		List<Genero> lista = (List<Genero>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public List<Genero> getGeneroFamilia(Familia familia) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Genero u where idfamilia=:idfamilia order by genero");
		q.setParameter("idfamilia", familia.getIdfamilia().toString());
		List<Genero> lista = (List<Genero>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public void modificarGenero(Genero genero) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().update(genero);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void eliminarGenero(Genero genero) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(genero);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public Genero recuperaGenero(String genero) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Genero u where genero=:genero");
		q.setParameter("genero", genero);
		Genero unGenero = (Genero) q.getSingleResult();
		sf.getCurrentSession().close();
		return unGenero;
	}

}
