package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.LocalizacionDAO;
import com.setas.modelo.Localizacion;
import com.setas.modelo.Seta;
import com.setas.modelo.Usuario;

public class LocalizacionDAOImp implements LocalizacionDAO {
	SessionFactory sf;
	
	public LocalizacionDAOImp(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insertarLocalizacion(Localizacion localizacion) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().save(localizacion);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void eliminarLocalizacion(Localizacion localizacion) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().delete(localizacion);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void modificarLocalizacion(Localizacion localizacion) {
		try {
			sf.getCurrentSession().beginTransaction();
			sf.getCurrentSession().update(localizacion);
			sf.getCurrentSession().getTransaction().commit();
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
	
	@Override
	public Localizacion recuperarLocalizacion(int idlocalizacion) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Localizacion u where idlocalizacion=:idlocalizacion");
			q.setParameter("idlocalizacion", idlocalizacion);
			Localizacion localizacion = (Localizacion) q.getSingleResult();
			sf.getCurrentSession().getTransaction().commit();
		return localizacion;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Localizacion> recuperarLocalizaUsu(Usuario usuario) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Localizacion u where usuario=:usuario");
			q.setParameter("usuario", usuario);
			List<Localizacion> listaLocalizacionUsu = (List<Localizacion>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return listaLocalizacionUsu;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public List<Localizacion> recuperarLocalizaSeta(Usuario usuario, Seta seta) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Localizacion u where idusuario=:idusuario and idseta=:idseta");
			q.setParameter("idusuario", usuario.getIdusuario());
			q.setParameter("idseta", seta.getIdseta());
			List<Localizacion> listaLocalizacionSeta = (List<Localizacion>) q.getResultList();
			sf.getCurrentSession().getTransaction().commit();
			return listaLocalizacionSeta;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

}
