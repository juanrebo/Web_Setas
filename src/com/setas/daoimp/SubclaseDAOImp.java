package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.SubclaseDAO;
import com.setas.modelo.Clase;
import com.setas.modelo.Subclase;

public class SubclaseDAOImp implements SubclaseDAO {
	SessionFactory sf;
	
	public SubclaseDAOImp(SessionFactory sf){
		this.sf = sf;
	}
	@Override
	public void insertarSubclase(Subclase subclase) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(subclase);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Subclase> getSubclase() {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Sublase u order by subclase");
		List<Subclase> lista = (List<Subclase>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public List<Subclase> getSubclaseClase(Clase clase) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Subclase u where idclase =: idclase order by subclase");
		q.setParameter("idclase", clase.getIdclase().toString());
		List<Subclase> lista = (List<Subclase>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public void modificarSubclase(Subclase subclase) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().update(subclase);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void eliminarSubclase(Subclase subclase) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(subclase);
		sf.getCurrentSession().getTransaction().commit();
	}

}
