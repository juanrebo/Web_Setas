package com.setas.daoimp;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.RolDAO;
import com.setas.modelo.Rol;
import com.setas.modelo.Usuario;

public class RolDAOImp implements RolDAO {
	SessionFactory sf;
	
	public RolDAOImp(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Rol getRol(Usuario usuario) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Rol u where idRol := idRol");
			q.setParameter("idRol", usuario.getRol());
			Rol rol = (Rol) q.getSingleResult();
			sf.getCurrentSession().getTransaction().commit();
			return rol;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public Rol getRol(int idrol) {
		try {
			sf.getCurrentSession().beginTransaction();
			Query q = sf.getCurrentSession().createQuery("select u from Rol u where idrol=:idrol");
			q.setParameter("idrol", idrol);
			Rol rol = (Rol) q.getSingleResult();
			sf.getCurrentSession().getTransaction().commit();
			return rol;
		}catch(Exception e) {
			sf.getCurrentSession().getTransaction().rollback();
			throw e;
		}
	}
}
