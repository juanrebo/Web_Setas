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
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Rol u where idRol := idRol");
		q.setParameter("idRol", usuario.getRol());
		Rol rol = (Rol) q.getSingleResult();
		sf.getCurrentSession().getTransaction().commit();
		return rol;
	}

	@Override
	public Rol getRol(int idrol) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Rol u where idrol=:idrol");
		q.setParameter("idrol", idrol);
		Rol rol = (Rol) q.getSingleResult();
		sf.getCurrentSession().getTransaction().commit();
		return rol;
	}

}
