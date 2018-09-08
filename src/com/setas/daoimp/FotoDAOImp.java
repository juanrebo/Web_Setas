package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.FotoDAO;
import com.setas.modelo.Foto;
import com.setas.modelo.Seta;

public class FotoDAOImp implements FotoDAO {
	SessionFactory sf;
	
	public FotoDAOImp(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insertarFoto(Foto foto) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().save(foto);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void eliminarFoto(Foto foto) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(foto);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void modificarFoto(Foto foto) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().update(foto);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Foto> recuperaFoto(Seta seta) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Foto u where seta=:seta");
			q.setParameter("seta", seta);
			List<Foto> listaFotos = (List<Foto>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return listaFotos;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

}
