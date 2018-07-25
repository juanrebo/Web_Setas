package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.SubdivisionDAO;
import com.setas.modelo.Division;
import com.setas.modelo.Familia;
import com.setas.modelo.Subdivision;

public class SubdivisionDAOImp implements SubdivisionDAO {
	SessionFactory sf;
	
	public SubdivisionDAOImp(SessionFactory sf){
		this.sf = sf;
	}
	
	@Override
	public void insertarSubdivision(Subdivision subdivision) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(subdivision);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Subdivision> getSubdivision() {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Subdivision u order by subdivision");
		List<Subdivision> lista = (List<Subdivision>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public List<Subdivision> getSubdivisonDivision(Division division) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Subdivision u where iddivision =: iddivision order by subdivision");
		q.setParameter("iddivision", division.getIddivision().toString());
		List<Subdivision> lista = (List<Subdivision>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public void modificarSubdivision(Subdivision subdivision) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().update(subdivision);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void eliminarSubdivision(Subdivision subdivision) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(subdivision);
		sf.getCurrentSession().getTransaction().commit();
	}

}
