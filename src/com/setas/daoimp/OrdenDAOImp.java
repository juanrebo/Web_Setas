package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.OrdenDAO;
import com.setas.modelo.Orden;
import com.setas.modelo.Subclase;

public class OrdenDAOImp implements OrdenDAO {
	SessionFactory sf;
	
	public OrdenDAOImp(SessionFactory sf){
		this.sf = sf;
	}
	@Override
	public void insertarOrden(Orden orden) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().save(orden);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public List<Orden> getOrden() {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Orden u order by orden");
		List<Orden> lista = (List<Orden>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public List<Orden> getOrdenSubclase(Subclase subclase) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Orden u where idsubclase =: idsubclase order by orden");
		q.setParameter("idsubclase", subclase.getIdsubclase().toString());
		List<Orden> lista = (List<Orden>) q.getResultList();
		sf.getCurrentSession().getTransaction().commit();
		return lista;
	}

	@Override
	public void modificarOrden(Orden orden) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().update(orden);
		sf.getCurrentSession().getTransaction().commit();
	}

	@Override
	public void eliminarOrden(Orden orden) {
		sf.getCurrentSession().beginTransaction();
		sf.getCurrentSession().delete(orden);
		sf.getCurrentSession().getTransaction().commit();
	}

}
