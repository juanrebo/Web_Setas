package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.FavoritoDAO;
import com.setas.modelo.Favorito;
import com.setas.modelo.Usuario;

public class FavoritoDAOImp implements FavoritoDAO {
	SessionFactory sf;
	
	public FavoritoDAOImp(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insertarFavorito(Favorito favorito) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().save(favorito);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void eliminarFavorito(Favorito favorito) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(favorito);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
	@Override
	public List<Favorito> recuperaFavoritos(Usuario usuario) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Favorito u where usuario=:usuario");
			q.setParameter("usuario", usuario);
			List<Favorito> listaFavoritos = (List<Favorito>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return listaFavoritos;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
}
