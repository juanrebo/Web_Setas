package com.setas.daoimp;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.UsuarioDAO;
import com.setas.modelo.Rol;
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

	@Override
	public Usuario obtenerUsuario(String nombre) {
		sf.getCurrentSession().getTransaction().begin();
		Query q = sf.getCurrentSession().createQuery("select u from Usuario u where nombre=:nombre");
		q.setParameter("nombre", nombre);
		Usuario usuario = (Usuario) q.getSingleResult();
		/*Rol rol = usuario.getRol();
		usuario.setRol(rol);*/
		sf.getCurrentSession().getTransaction().commit();
		return usuario;
	}
}
