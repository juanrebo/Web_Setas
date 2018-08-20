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
		sf = this.sf;
	}

	@Override
	public void insertarLocalizacion(Localizacion localizacion) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(localizacion);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void eliminarLocalizacion(Localizacion localizacion) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(localizacion);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void modificarLocalizacion(Localizacion localizacion) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().update(localizacion);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Localizacion> recuperarLocalizaUsu(Usuario usuario) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Localizacion u where idusuario=:idusuario");
		q.setParameter("idusuario", usuario.getIdusuario());
		List<Localizacion> listaLocalizacionUsu = (List<Localizacion>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return listaLocalizacionUsu;
	}

	@Override
	public List<Localizacion> recuperarLocalizaSeta(Usuario usuario, Seta seta) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Localizacion u where idusuario=:idusuario and idseta=:idseta");
		q.setParameter("idusuario", usuario.getIdusuario());
		q.setParameter("idseta", seta.getIdseta());
		List<Localizacion> listaLocalizacionSeta = (List<Localizacion>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return listaLocalizacionSeta;
	}

}