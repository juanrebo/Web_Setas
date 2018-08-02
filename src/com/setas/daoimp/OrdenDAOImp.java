package com.setas.daoimp;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;

import com.setas.dao.OrdenDAO;
import com.setas.modelo.Clase;
import com.setas.modelo.Orden;

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
	public List<Orden> getOrdenClase(Clase clase) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Orden u where idclase=:idclase order by orden");
		q.setParameter("idclase", clase.getIdclase().toString());
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
	@Override
	public Orden recuperaOrden(String orden) {
		sf.getCurrentSession().beginTransaction();
		Query q = sf.getCurrentSession().createQuery("select u from Orden u where orden=:orden");
		q.setParameter("orden", orden);
		Orden unaOrden = (Orden) q.getSingleResult();
		sf.getCurrentSession().close();
		return unaOrden;
	}

}
