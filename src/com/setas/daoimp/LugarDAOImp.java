package com.setas.daoimp;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.LugarDAO;
import com.setas.modelo.Lugar;
import com.setas.modelo.Orden;

public class LugarDAOImp implements LugarDAO{
	SessionFactory sf;
	
	public LugarDAOImp(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Lugar getLugarId(int idlugar) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Lugar u where idlugar=:idlugar");
		q.setParameter("idlugar", idlugar);
		Lugar lugar = (Lugar) q.getSingleResult();
		sf.getCurrentSession().getTransaction().commit();
		return lugar;
	}
}
