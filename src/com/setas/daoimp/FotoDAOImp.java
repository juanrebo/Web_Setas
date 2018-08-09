package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.FotoDAO;
import com.setas.modelo.Foto;

public class FotoDAOImp implements FotoDAO {
	SessionFactory sf;
	
	public FotoDAOImp(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insertarFoto(Foto foto) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(foto);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void eliminarFoto(Foto foto) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(foto);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void modificarFoto(Foto foto) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().update(foto);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Foto> recuperaFoto(int idseta) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Foto u where idseta=:idseta");
		q.setParameter("idseta", idseta);
		List<Foto> listaFotos = (List<Foto>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return listaFotos;
	}

}
