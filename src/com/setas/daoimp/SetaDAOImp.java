package com.setas.daoimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.SetaDAO;
import com.setas.modelo.Seta;

public class SetaDAOImp implements SetaDAO {
	SessionFactory sf;
	
	public SetaDAOImp(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insertarSeta(Seta seta) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(seta);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Seta> getSeta() {
		ArrayList<Seta> lista = new ArrayList<Seta>();
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("Select u from setas u");
		lista = (ArrayList<Seta>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public void modificarSeta(Seta seta) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().update(seta);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void eliminarSeta(Seta seta) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(seta);
		sf.getCurrentSession().getTransaction().commit();
	}

}
