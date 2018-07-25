package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.ClaseDAO;
import com.setas.modelo.Clase;
import com.setas.modelo.Subdivision;

public class ClaseDAOImp implements ClaseDAO {
	SessionFactory sf;
	
	public ClaseDAOImp(SessionFactory sf){
		this.sf = sf;
	}
	@Override
	public void insertarClase(Clase clase) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(clase);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Clase> getClase() {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Clase u order by clase");
		List<Clase> lista = (List<Clase>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public List<Clase> getClaseSubdivison(Subdivision subdivision) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Clase u where idsubdivision =: idsubdivision order by clase");
		q.setParameter("idsubdivision", subdivision.getIdsubdivision().toString());
		List<Clase> lista = (List<Clase>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public void modificarClase(Clase clase) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().update(clase);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void eliminarClase(Clase clase) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(clase);
		sf.getCurrentSession().getTransaction().commit();
	}

}
