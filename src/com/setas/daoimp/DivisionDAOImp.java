package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.DivisionDAO;
import com.setas.modelo.Division;

public class DivisionDAOImp implements DivisionDAO {
	SessionFactory sf;
	
	public DivisionDAOImp(SessionFactory sf){
		this.sf = sf;
	}
	
	@Override
	public void insertarDivision(Division division) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(division);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Division> getDivision() {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Division u order by division");
		List<Division> lista = (List<Division>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public void modificarDivision(Division division) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().update(division);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void eliminarDivision(Division division) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(division);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public Division recuperaDivision(int iddivision) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Division u where iddivision=:iddivision");
		q.setParameter("iddivision", iddivision);
		Division division = (Division) q.getSingleResult();
		sf.getCurrentSession().close();
		return division;
	}

}
