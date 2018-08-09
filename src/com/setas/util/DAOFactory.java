package com.setas.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.setas.dao.ClaseDAO;
import com.setas.dao.FamiliaDAO;
import com.setas.dao.FiloDAO;
import com.setas.dao.FotoDAO;
import com.setas.dao.GeneroDAO;
import com.setas.dao.OrdenDAO;
import com.setas.dao.RolDAO;
import com.setas.dao.SetaDAO;
import com.setas.dao.UsuarioDAO;
import com.setas.daoimp.ClaseDAOImp;
import com.setas.daoimp.FamiliaDAOImp;
import com.setas.daoimp.FiloDAOImp;
import com.setas.daoimp.FotoDAOImp;
import com.setas.daoimp.GeneroDAOImp;
import com.setas.daoimp.OrdenDAOImp;
import com.setas.daoimp.RolDAOImp;
import com.setas.daoimp.SetaDAOImp;
import com.setas.daoimp.UsuarioDAOImp;

public class DAOFactory {
	private final static DAOFactory INSTANCE = new DAOFactory();
	SessionFactory sf;
	
	private DAOFactory() {
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static DAOFactory getSingleton() {
		return INSTANCE;
	}
	
	public RolDAO getRol() {
		return new RolDAOImp(sf);
	}
	
	public SetaDAO getSeta() {
		return new SetaDAOImp(sf);
	}
	
	public UsuarioDAO getUsuario() {
		return new UsuarioDAOImp(sf);
	}
	
	public FiloDAO getFilo() {
		return new FiloDAOImp(sf);
	}
	
	public ClaseDAO getClase() {
		return new ClaseDAOImp(sf);
	}
	
	public OrdenDAO getOrden() {
		return new OrdenDAOImp(sf);
	}
	
	public FamiliaDAO getFamilia() {
		return new FamiliaDAOImp(sf);
	}
	
	public GeneroDAO getGenero() {
		return new GeneroDAOImp(sf);
	}
	
	public FotoDAO getFoto() {
		return new FotoDAOImp(sf);
	}
}
