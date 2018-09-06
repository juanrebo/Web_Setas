package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.LugarDAO;
import com.setas.modelo.Lugar;
import com.setas.modelo.Orden;
import com.setas.modelo.Usuario;

public class LugarDAOImp implements LugarDAO{
	SessionFactory sf;
	
	public LugarDAOImp(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insertarLugar(Lugar lugar) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(lugar);
		sf.getCurrentSession().getTransaction().commit();
	}
	
	@Override
	public void eliminarLugar(Lugar lugar) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(lugar);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public Lugar recuperaLugar(int idlugar) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Lugar u where idlugar=:idlugar");
		q.setParameter("idlugar", idlugar);
		Lugar lugar = (Lugar) q.getSingleResult();
		sf.getCurrentSession().getTransaction().commit();
		return lugar;
	}

	@Override
	public List<Lugar> recuperaLugares(Usuario usuario) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Lugar u where usuario=:usuario");
		q.setParameter("usuario", usuario);
		List<Lugar> lugares = (List<Lugar>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lugares;
	}
}
