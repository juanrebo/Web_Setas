package com.setas.daoimp;

import org.hibernate.SessionFactory;

import com.setas.dao.UsuarioDAO;
import com.setas.modelo.Usuario;

public class UsuarioDAOImp implements UsuarioDAO {
	SessionFactory sf;
	
	public UsuarioDAOImp (SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insertarUsuario(Usuario usuario) {
		sf.getCurrentSession().getTransaction().begin();
		sf.getCurrentSession().save(usuario);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		sf.getCurrentSession().getTransaction().begin();
		sf.getCurrentSession().update(usuario);
		sf.getCurrentSession().getTransaction().commit();

	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		sf.getCurrentSession().getTransaction().begin();
		sf.getCurrentSession().delete(usuario);
		sf.getCurrentSession().getTransaction().commit();
	}

}
