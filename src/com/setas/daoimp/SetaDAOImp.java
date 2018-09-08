package com.setas.daoimp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.SetaDAO;
import com.setas.modelo.Familia;
import com.setas.modelo.Genero;
import com.setas.modelo.Seta;

public class SetaDAOImp implements SetaDAO {
	SessionFactory sf;
	
	public SetaDAOImp(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insertarSeta(Seta seta) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().save(seta);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Seta> getSeta() {
		try {
			ArrayList<Seta> lista = new ArrayList<Seta>();
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("Select u from Seta u order by genero.genero, especie");
			lista = (ArrayList<Seta>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return lista;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
	
	@Override
	public List<Seta> getSetaGenero(Genero genero) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Seta u where idgenero=:idgenero order by especie");
			q.setParameter("idgenero", genero.getIdgenero().toString());
			List<Seta> lista = (List<Seta>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return lista;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
	
	@Override
	public void modificarSeta(Seta seta) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().update(seta);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void eliminarSeta(Seta seta) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(seta);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public Seta recuperaSetaId(int idseta) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Seta u where idseta=:idseta");
			q.setParameter("idseta", idseta);
			Seta seta = (Seta) q.getSingleResult();
			sf.getCurrentSession().getTransaction().commit();
			return seta;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
	
	@Override
	public Seta recuperaSeta(int idgenero, String especie) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Seta u where idgenero=:idgenero and especie=:especie order by genero, especie");
			q.setParameter("idgenero", idgenero);
			q.setParameter("especie", especie);
			Seta seta = (Seta) q.getSingleResult();
			sf.getCurrentSession().getTransaction().commit();
			return seta;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
}
